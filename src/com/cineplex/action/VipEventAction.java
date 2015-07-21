package com.cineplex.action;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.RequestAware;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.cineplex.model.Event;
import com.cineplex.model.User;
import com.cineplex.service.EventService;
import com.cineplex.service.VoteService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class VipEventAction extends ActionSupport implements RequestAware{

	User user;
	List eventList;
	int option;
	int chosenEvent;
	Event event;
	String result;
	
	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		if(chosenEvent!=0){
			ActionContext.getContext().getSession().put("event", chosenEvent);
			ApplicationContext appliationContext=new ClassPathXmlApplicationContext("applicationContext.xml");
			EventService es=(EventService) appliationContext.getBean("eventservice");
			event=es.getEvent(chosenEvent);
			System.out.println("chosenEvent="+chosenEvent);
			setChosenEvent(0);
			System.out.println("chosenEvent2="+chosenEvent);
			return "EventDetail";
		}
		try{
		HttpServletRequest request=ServletActionContext.getRequest();
		user=(User) request.getSession().getAttribute("user");
		
		ApplicationContext appliationContext=new ClassPathXmlApplicationContext("applicationContext.xml");
		EventService es=(EventService) appliationContext.getBean("eventservice");

		eventList=(List) es.getEventInvolved(user.getId());
		
		System.out.println(eventList.size());
		
		}catch(Exception e){
			e.printStackTrace();
		}
		return SUCCESS;
		
	}
	
	public String eventDetail(){
		try{
			
			HttpServletRequest request=ServletActionContext.getRequest();
			user=(User) request.getSession().getAttribute("user");
			chosenEvent=(Integer) request.getSession().getAttribute("event");
			
			ApplicationContext appliationContext=new ClassPathXmlApplicationContext("applicationContext.xml");
			VoteService vs=(VoteService) appliationContext.getBean("voteservice");
			ActionContext.getContext().getSession().put("event", 0);
			boolean r=vs.createRecord(user, chosenEvent, option);
			
			EventService es=(EventService) appliationContext.getBean("eventservice");
			es.vote(chosenEvent, option);
			
			setChosenEvent(0);
			
			result=(r==true)?"提交成功啦":"失败了";
			
			
			
			
		}catch(Exception e){
			e.printStackTrace();
		}
		return SUCCESS;
		
	}
	
	
	public Event getEvent() {
		return event;
	}

	public void setEvent(Event event) {
		this.event = event;
	}

	public int getChosenEvent() {
		return chosenEvent;
	}

	public void setChosenEvent(int chosenEvent) {
		this.chosenEvent = chosenEvent;
	}




	public int getOption() {
		return option;
	}

	public void setOption(int option) {
		this.option = option;
	}

	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public List getEventList() {
		return eventList;
	}
	public void setEventList(List eventList) {
		this.eventList = eventList;
	}

	@Override
	public void setRequest(Map<String, Object> arg0) {
		// TODO Auto-generated method stub
		
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

}
