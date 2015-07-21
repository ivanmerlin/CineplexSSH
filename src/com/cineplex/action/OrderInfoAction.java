package com.cineplex.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.cineplex.model.Order1;
import com.cineplex.model.User;
import com.cineplex.service.FilmPlanService;
import com.cineplex.service.OrderService;
import com.opensymphony.xwork2.ActionSupport;

public class OrderInfoAction extends ActionSupport{

	User user;
	List<Order1> orderList;
	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		
		HttpServletRequest request=ServletActionContext.getRequest();
		user= (User) request.getSession().getAttribute("user");
		System.out.println("user="+user.getUsername());
		ApplicationContext appliationContext=new ClassPathXmlApplicationContext("applicationContext.xml");
		OrderService os=(OrderService) appliationContext.getBean("orderservice");
		orderList=os.getOrders(user.getId());
		System.out.println("get Order list");
		for(Order1 o:orderList){
			System.out.println("o.filmname="+o.getFilmname());
		}
		
		
		
		return SUCCESS;
	}
	
	
	
	public List getOrderList() {
		return orderList;
	}



	public void setOrderList(List orderList) {
		this.orderList = orderList;
	}



	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}

	
	
}
