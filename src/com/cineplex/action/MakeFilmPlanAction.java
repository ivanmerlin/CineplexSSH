package com.cineplex.action;

import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.RequestAware;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Repository;

import com.cineplex.model.Film;
import com.cineplex.model.FilmPlan;
import com.cineplex.service.FilmPlanService;
import com.cineplex.service.FilmService;
import com.cineplex.service.RegisterService;
import com.cineplex.service.RoomService;
import com.opensymphony.xwork2.ActionSupport;

@Repository("makeFilmPlan")
public class MakeFilmPlanAction extends ActionSupport implements RequestAware{
	
	
	List filmList;
	List roomList;
	List<FilmPlan> unpassedPlanList;
	String plan_time;
	String filmPrice;
	String filmName;
	String roomName;
	String planInfo;

	@Override
	public String execute() throws Exception {
		ApplicationContext appliationContext=new ClassPathXmlApplicationContext("applicationContext.xml");
		FilmService fs=(FilmService) appliationContext.getBean("filmservice");
		RoomService rs=(RoomService) appliationContext.getBean("roomservice");
		filmList=fs.getAllFilm();
		roomList=rs.getAllRoom();

		System.out.println("filmName="+filmName);
		System.out.println("roomName="+roomName);
		System.out.println("filmPrice="+filmPrice);
		System.out.println("plan_time="+plan_time);
		
		if(filmPrice!=null && plan_time!=null){
			System.out.println("进入create process----");
			FilmPlanService fps=(FilmPlanService) appliationContext.getBean("filmplanservice");
			System.out.println("初始化filmPlanservice");
			fps.createPlan(filmName, filmPrice, roomName, plan_time);
			System.out.println("successfully create the film plan");
			setFilmPrice(null);
		}
		
		return SUCCESS;
	}

	public String edit(){
		ApplicationContext appliationContext=new ClassPathXmlApplicationContext("applicationContext.xml");
		FilmPlanService fps=(FilmPlanService) appliationContext.getBean("filmplanservice");
		unpassedPlanList=fps.getUnPassedList();

		RoomService rs=(RoomService) appliationContext.getBean("roomservice");

		roomList=rs.getAllRoom();
		
		
		return SUCCESS;
	}
	
	public String editComplete(){
		ApplicationContext appliationContext=new ClassPathXmlApplicationContext("applicationContext.xml");
		FilmPlanService fps=(FilmPlanService) appliationContext.getBean("filmplanservice");
		String[] planSplit=planInfo.split(" ");
		
		System.out.println("这里是editComplete");
		System.out.println("roomName="+roomName);
		System.out.println("filmPrice="+filmPrice);
		System.out.println("plan_time="+plan_time);
		if(filmPrice!=null && plan_time!=null &&roomName!=null){
			FilmPlan fp=fps.getPlan(planSplit[0]);
			if(fp!=null){
				fps.editPlan(planSplit[0], Integer.valueOf(filmPrice).intValue(), plan_time, roomName);
			}
		
			
			setFilmPrice(null);
		}
		
		
		return SUCCESS;
	}
	
	
	public String getPlanInfo() {
		return planInfo;
	}

	public void setPlanInfo(String planInfo) {
		this.planInfo = planInfo;
	}

	public List<FilmPlan> getUnpassedPlanList() {
		return unpassedPlanList;
	}

	public void setUnpassedPlanList(List<FilmPlan> unpassedPlanList) {
		this.unpassedPlanList = unpassedPlanList;
	}

	public String getFilmName() {
		return filmName;
	}



	public void setFilmName(String filmName) {
		this.filmName = filmName;
	}



	public String getRoomName() {
		return roomName;
	}



	public void setRoomName(String roomName) {
		this.roomName = roomName;
	}



	public List getFilmList() {
		return filmList;
	}


	public void setFilmList(List filmList) {
		this.filmList = filmList;
	}


	public List getRoomList() {
		return roomList;
	}
	public void setRoomList(List roomList) {
		this.roomList = roomList;
	}
	public String getPlan_time() {
		return plan_time;
	}



	public void setPlan_time(String plan_time) {
		this.plan_time = plan_time;
	}



	public String getFilmPrice() {
		return filmPrice;
	}



	public void setFilmPrice(String filmPrice) {
		this.filmPrice = filmPrice;
	}

	@Override
	public void setRequest(Map<String, Object> arg0) {
		// TODO Auto-generated method stub
		
	}

}
