package com.cineplex.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;



import com.cineplex.dao.BaseDao;
import com.cineplex.model.FilmPlan;
import com.cineplex.model.Order1;
import com.cineplex.model.User;

public class OrderService {

	@Autowired
	private BaseDao dao;
	
	public List getOrders(String userid){
		List list=dao.find(Order1.class, "userid", userid);
		System.out.println("find the userid");
		return list;		
	}
	public boolean createOrder(String userid,int planid,int num){
		Order1 o=new Order1();
		o.setNum(num);
		o.setPlanid(planid);
		o.setUserid(userid);
		
	
		
		ApplicationContext appliationContext=new ClassPathXmlApplicationContext("applicationContext.xml");
		FilmPlanService fps=(FilmPlanService) appliationContext.getBean("filmplanservice");
		FilmPlan fp=fps.getPlan(planid+"");
		o.setFilmname(fp.getFilmName());
		o.setRoomname(fp.getRoomName());
		o.setPrice(fp.getPrice());
		o.setStarttime(fp.getStarttime());
		

		
		dao.save(o);
		System.out.println("创建订单完成--");
		return true;
		
	}
	
	public boolean createOrder(int planid,int num){
		Order1 o=new Order1();
		o.setNum(num);
		o.setPlanid(planid);
		ApplicationContext appliationContext=new ClassPathXmlApplicationContext("applicationContext.xml");
		FilmPlanService fps=(FilmPlanService) appliationContext.getBean("filmplanservice");
		FilmPlan fp=fps.getPlan(planid+"");
		o.setFilmname(fp.getFilmName());
		o.setRoomname(fp.getRoomName());
		o.setPrice(fp.getPrice());
		o.setStarttime(fp.getStarttime());
		
		
		dao.save(o);
		System.out.println("创建订单完成--");
		return true;
		
	}
	
	public List getAllOrders(){
		return dao.getAllList(Order1.class);
	}
}
