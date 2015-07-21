package com.cineplex.service;

import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;





import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.cineplex.dao.BaseDao;
import com.cineplex.model.Event;
import com.cineplex.model.VoteRecord;

public class EventService {

	@Autowired
	private BaseDao dao;
	
	public boolean createEvent(String planInfo,String question){
		
		Event e=new Event();
		e.setQuestion(question);
		
		String[] infos=planInfo.split(" ");
		String planidStr=infos[0];
		int planid=Integer.valueOf(planidStr).intValue();
		String filmname=infos[1];
		e.setFilmname(filmname);
		e.setPlanid(planid);
		e.setGood(0);
		e.setMedium(0);
		e.setBad(0);
		
		dao.save(e);		
		return true;
	}
	
 
	public List<Event> getEventInvolved(String userid){
		List<Event> list= dao.doInHibernate("select e.id as id,e.filmname as filmname,e.question as question,e.planid as planid,e.good as good,e.medium as medium,e.bad as bad ,e.online as online from Event e,Order1 o where e.planid=o.planid and e.online='1' and o.userid="+userid,Event.class);
		List<VoteRecord> vrList=dao.getAllList(VoteRecord.class);
		Iterator<Event> i=list.iterator();
		System.out.println("old num="+list.size());
		while(i.hasNext()){
			Event e=i.next();
			for(VoteRecord vr:vrList){
				if(vr.getUserid().equals(userid)&&vr.getEventid()==e.getId()){
					i.remove();
					break;
				}
			}
		}
		System.out.println("new num="+list.size());
		return list;
	}
	
	public Event getEvent(int id){
		List list=dao.find(Event.class, "id", id+"");
		Event e=(Event) list.get(0);
		return e;
	}
	
	public void terminateEvent(int id){
		Event e=getEvent(id);
		e.setOnline(0);
		int total=e.getGood()+e.getBad()+e.getMedium();
		double goodPer=e.getGood()/total;
		double badPer=e.getBad()/total;
		double mediumPer=e.getMedium()/total;
		ApplicationContext appliationContext=new ClassPathXmlApplicationContext("applicationContext.xml");
		VoteService vs=(VoteService) appliationContext.getBean("voteservice");
		UserService us=(UserService)appliationContext.getBean("userservice");
		List<VoteRecord> vrlist=vs.getAllList();
		for(VoteRecord vr:vrlist){
			if(vr.getEventid()==id){
				if(goodPer>=0.75&&vr.getOptionValue()==1){
					us.addCredit(vr.getUserid(), 50);
				}else if(badPer>=0.75&&vr.getOptionValue()==3){
					us.addCredit(vr.getUserid(), 50);
				}else if(mediumPer>=0.75&&vr.getOptionValue()==2){
					us.addCredit(vr.getUserid(), 50);
				}
			}
		}
		
		dao.update(e);
	}
	
	public void vote(int id,int option){
		Event e=getEvent(id);
		if(option==1){
			e.setGood(e.getGood()+1);
		}else if(option==2){
			e.setMedium(e.getMedium()+1);
		}else if(option==3){
			e.setBad(e.getBad()+1);
		}
		dao.update(e);
	}
	
	
	public List getAllEvent(){
		return dao.getAllList(Event.class);
	}
	
}
