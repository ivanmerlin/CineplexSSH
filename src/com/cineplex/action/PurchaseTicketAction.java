package com.cineplex.action;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.cineplex.model.User;
import com.cineplex.service.FilmPlanService;
import com.cineplex.service.FilmService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class PurchaseTicketAction extends ActionSupport{

	User user;
	ArrayList<String> dayList=new ArrayList<String>();
	String chosenTime;
	List filmList;
	String chosenFilm;
	List planList;
	int selectPlanId;
	
	@Override
	public String execute() throws Exception {
		if(selectPlanId>0){
			System.out.println("selectPlanId="+selectPlanId);
			ActionContext.getContext().getSession().put("planId", selectPlanId);
			setSelectPlanId(0);
			System.out.println("selectPlanId2="+selectPlanId);
			return "detail";
		}
		System.out.println("here");
		// TODO Auto-generated method stub
		HttpServletRequest request = ServletActionContext.getRequest();
		user= (User) request.getSession().getAttribute("user");
		
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");//设置日期格式
		Date date=new Date();
		Calendar calendar=new GregorianCalendar();
		calendar.setTime(date);
		dayList.clear();
		for(int i=0;i<7;i++){
			System.out.println("i="+i);
			String dateStr=df.format(date);
			calendar.add(calendar.DATE, 1);
			date=calendar.getTime();
			System.out.println("dateStr="+dateStr);
			dayList.add(dateStr);			
		}
		ApplicationContext appliationContext=new ClassPathXmlApplicationContext("applicationContext.xml");
		FilmService fs=(FilmService) appliationContext.getBean("filmservice");
		filmList=fs.getAllFilm();
		System.out.println("chosenTime="+chosenTime);
		System.out.println("chosenFilm="+chosenFilm);
		if(chosenTime!=null){
			FilmPlanService fps=(FilmPlanService) appliationContext.getBean("filmplanservice");
			if(chosenFilm!=null&&(!chosenFilm.equals("全部")) ){
				planList=fps.searchPlan(chosenTime, chosenFilm);
				System.out.println("planList.size="+planList.size());
			}else{
				planList=fps.searchPlan(chosenTime);
				System.out.println("planList.size="+planList.size());
			}			
		}
		
		
		
		System.out.println("there");
		
		
		
		return SUCCESS;
	}
	
	
	public List getPlanList() {
		return planList;
	}


	public void setPlanList(List planList) {
		this.planList = planList;
	}


	public List getFilmList() {
		return filmList;
	}


	public void setFilmList(List filmList) {
		this.filmList = filmList;
	}


	public String getChosenFilm() {
		return chosenFilm;
	}


	public void setChosenFilm(String chosenFilm) {
		this.chosenFilm = chosenFilm;
	}




	public String getChosenTime() {
		return chosenTime;
	}
	public void setChosenTime(String chosenTime) {
		this.chosenTime = chosenTime;
	}
	
	public ArrayList<String> getDayList() {
		return dayList;
	}
	public void setDayList(ArrayList<String> dayList) {
		this.dayList = dayList;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public int getSelectPlanId() {
		return selectPlanId;
	}

	public void setSelectPlanId(int selectPlanId) {
		this.selectPlanId = selectPlanId;
	}

	
	
}
