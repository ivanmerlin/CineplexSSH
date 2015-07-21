package com.cineplex.action;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.RequestAware;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.cineplex.service.EventService;
import com.cineplex.service.FilmPlanService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class MakeEventAction extends ActionSupport  implements RequestAware{

	String question;
	String planInfo;
	List planList;
	String type;
	String again;
	
	public String getPlanInfo() {
		return planInfo;
	}

	public void setPlanInfo(String planInfo) {
		this.planInfo = planInfo;
	}

	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		try {
			ApplicationContext appliationContext=new ClassPathXmlApplicationContext("applicationContext.xml");
			EventService es=(EventService) appliationContext.getBean("eventservice");
			FilmPlanService fps=(FilmPlanService) appliationContext.getBean("filmplanservice");
			System.out.println("get all service");
			planList=fps.getPassedList();
			System.out.println("get all film plan"+planList.size());
			
			if(question!=null && planInfo!=null){
				System.out.println("info completed");
				boolean hasCreate=es.createEvent(planInfo, question);
				System.out.println("hasCreate="+hasCreate);
				setPlanInfo(null);

				ActionContext.getContext().getSession().put("question", question);

				return "addAnother";
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		return SUCCESS;
	}
	
	public String addPlan(){
		try {
			System.out.println("****************************");
			System.out.println("½øÈëaddPlan()");
			System.out.println("****************************");
			ApplicationContext appliationContext=new ClassPathXmlApplicationContext("applicationContext.xml");
			EventService es=(EventService) appliationContext.getBean("eventservice");
			FilmPlanService fps=(FilmPlanService) appliationContext.getBean("filmplanservice");
			planList=fps.getPassedList();
			HttpServletRequest request=ServletActionContext.getRequest();
			String questionInfo=(String) request.getSession().getAttribute("question");
			System.out.println("*************************");
			System.out.println("again="+again);
			System.out.println("*********************************");
			if(again!=null && again.equals("no")){
				System.out.println("get No action");
				setAgain(null);
				setPlanInfo(null);
				setQuestion(null);
				ActionContext.getContext().getSession().put("question", null);
				return "end";
			}
			if(questionInfo!=null && planInfo!=null){
				System.out.println("info completed");
				boolean hasCreate=es.createEvent(planInfo, questionInfo);
				System.out.println("hasCreate="+hasCreate);
				setPlanInfo(null);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		return SUCCESS;
		
	}
	
	
	@Override
	public void setRequest(Map<String, Object> arg0) {
		// TODO Auto-generated method stub
		
	}

	

	public String getAgain() {
		return again;
	}

	public void setAgain(String again) {
		this.again = again;
	}

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public List getPlanList() {
		return planList;
	}

	public void setPlanList(List planList) {
		this.planList = planList;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}



	
}
