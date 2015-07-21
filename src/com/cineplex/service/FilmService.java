package com.cineplex.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.cineplex.dao.BaseDao;
import com.cineplex.model.Event;
import com.cineplex.model.Film;
import com.cineplex.model.FilmPlan;
import com.cineplex.model.User;

public class FilmService {

	@Autowired
	private BaseDao dao;
	
	public Film getFilm(String id){
		List list= dao.find(Film.class, "id", id);
		Film f=(Film) list.get(0);
		return f;
	}
	
	
	public List getAllFilm(){
		
		return dao.getAllList(Film.class);
	}
	public boolean publishFilm(String filmname,String time,String filmtype){
		
		Film f=new Film();
		f.setName(filmname);
		f.setType(filmtype);
		int toTime=Integer.valueOf(time).intValue();
		f.setTime(toTime);
		f.setOnline(1);
		dao.save(f);
		return true;		
	}
	public boolean endFilm(String filmName){
		List list= dao.find(Film.class, "name", filmName);
		Film f=(Film) list.get(0);
		f.setOnline(0);
		dao.update(f);
		ApplicationContext appliationContext=new ClassPathXmlApplicationContext("applicationContext.xml");
		EventService es=(EventService) appliationContext.getBean("eventservice");
		FilmPlanService fps=(FilmPlanService) appliationContext.getBean("filmplanservice");
		List<FilmPlan> fplist=fps.getPlanByFilm(filmName);
		List<Event> elist=es.getAllEvent();
		for(Event e:elist){
			for(FilmPlan fp:fplist){
				if(e.getPlanid()==fp.getId()){
					es.terminateEvent(e.getId());
				}
			}
		}
		
		return true;
		
	}
	
	public List getOnlineFilm(){
		List list= dao.find(Film.class, "online", "1");
		return list;
		
	}
	
	public List<Film> getRecommendFilms(User u){
		List<Film> list=dao.dosqlInHibernate("select f2.id as id,f2.name as name,f2.time as time,f2.online as online,f2.type as type from film f2,(select t,max(ma) from(select f.type as t,count(*) as ma from film f,order1 o where f.name=o.filmname and o.userid="+u.getId()+" group by f.type)as sb) sb where f2.type=sb.t",Film.class);
		if(list==null){return new ArrayList<Film>(0);}
		return list;
	}


	public List<Object[]> getTypeSta() {
		List<Object[]> list=dao.dosqlInHibernate2("select f.type,sum(o.num*o.price) from film f,order1 o where o.filmname=f.name group by f.type");
		
		return list;
	}
	
}








