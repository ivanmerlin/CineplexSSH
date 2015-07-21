package com.cineplex.action;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.RequestAware;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.cineplex.model.FilmPlan;
import com.cineplex.model.Seat;
import com.cineplex.model.User;
import com.cineplex.service.FilmPlanService;
import com.cineplex.service.OrderService;
import com.cineplex.service.SeatService;
import com.cineplex.service.UserService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class PurchaseDetailAction  extends ActionSupport implements RequestAware{

	int selectPlanId;
	FilmPlan filmPlan;
	String num;
	User user;
	String result;
	int row;
	int col;
	int index;
	List<Seat> seatresult;

	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		
		HttpServletRequest request=ServletActionContext.getRequest();
		selectPlanId=(Integer) request.getSession().getAttribute("planId");
		user=(User) request.getSession().getAttribute("user");
		System.out.println("selectPlanId3="+selectPlanId);
		
		ApplicationContext appliationContext=new ClassPathXmlApplicationContext("applicationContext.xml");
		FilmPlanService fps=(FilmPlanService) appliationContext.getBean("filmplanservice");
		filmPlan=fps.getPlan(selectPlanId+"");
		
		System.out.println("num="+num);
		
		if(num!=null){
			boolean hasConsumed;
			int numInt=Integer.valueOf(num).intValue();
			OrderService os=(OrderService) appliationContext.getBean("orderservice");
			UserService us=(UserService) appliationContext.getBean("userservice");
		
			hasConsumed=us.cost(user,filmPlan.getPrice()*numInt);
			
			ActionContext.getContext().getSession().put("planId", 0);
			if(hasConsumed){
				os.createOrder(user.getId(), selectPlanId, numInt);
				num=null;
				ActionContext.getContext().getSession().put("planId", -1);
				System.out.println("Òª·µ»Øcreatesuccess");
				setSelectPlanId(0);
				return "createSuccess";
			}else{
				setSelectPlanId(0);
				return "balanceFail";
			}

		
			
		}
		
		
		
		
		return SUCCESS;
	}
	

	public String select_seat(){
		
		ApplicationContext applicationContext=new ClassPathXmlApplicationContext("applicationContext.xml");
		SeatService ss=(SeatService) applicationContext.getBean("seatservice");
		ss.createSeat(row, col, selectPlanId);
		return SUCCESS;
	}
	
	public String get_unavailable_seat(){
		ApplicationContext applicationContext=new ClassPathXmlApplicationContext("applicationContext.xml");
		SeatService ss=(SeatService) applicationContext.getBean("seatservice");
		seatresult=ss.getSeat(selectPlanId);
		return SUCCESS;
	}
	
	
	
	
	
	public int getRow() {
		return row;
	}


	public void setRow(int row) {
		this.row = row;
	}


	public int getCol() {
		return col;
	}


	public void setCol(int col) {
		this.col = col;
	}


	
	public int getIndex() {
		return index;
	}


	public void setIndex(int index) {
		this.index = index;
	}


	public FilmPlan getFilmPlan() {
		return filmPlan;
	}


	public User getUser() {
		return user;
	}


	public void setUser(User user) {
		this.user = user;
	}


	public String getResult() {
		return result;
	}


	public void setResult(String result) {
		this.result = result;
	}


	public void setFilmPlan(FilmPlan filmPlan) {
		this.filmPlan = filmPlan;
	}

	public String getNum() {
		return num;
	}


	public List<Seat> getSeatresult() {
		return seatresult;
	}


	public void setSeatresult(List<Seat> seatresult) {
		this.seatresult = seatresult;
	}


	public void setNum(String num) {
		this.num = num;
	}



	public int getSelectPlanId() {
		return selectPlanId;
	}

	public void setSelectPlanId(int selectPlanId) {
		this.selectPlanId = selectPlanId;
	}


	@Override
	public void setRequest(Map<String, Object> arg0) {
		// TODO Auto-generated method stub
		
	}

	

}
