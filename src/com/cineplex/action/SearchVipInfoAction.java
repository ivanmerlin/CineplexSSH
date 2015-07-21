package com.cineplex.action;

import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.RequestAware;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.cineplex.model.User;
import com.cineplex.service.ConsumeRecService;
import com.cineplex.service.RechargeRecService;
import com.cineplex.service.UserService;
import com.opensymphony.xwork2.ActionSupport;

public class SearchVipInfoAction extends ActionSupport implements RequestAware{

	User user;
	String userid;
	List consumeRecord;
	List rechargeRecord;
	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		
		
		
		return SUCCESS;
	}

	public String completeSearch() throws Exception {
		try{
		System.out.println("userid="+userid);
		ApplicationContext appliationContext=new ClassPathXmlApplicationContext("applicationContext.xml");
		UserService us=(UserService) appliationContext.getBean("userservice");
		user=us.getUserById(userid);
		
		RechargeRecService rrs=(RechargeRecService) appliationContext.getBean("rechargeservice");		
		rechargeRecord=rrs.getRecords(userid);
		ConsumeRecService crs=(ConsumeRecService) appliationContext.getBean("consumeservice");		
		consumeRecord=crs.getRecords(userid);
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return SUCCESS;
	}
	
	
	
	
	
	@Override
	public void setRequest(Map<String, Object> arg0) {
		// TODO Auto-generated method stub
		
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public List getConsumeRecord() {
		return consumeRecord;
	}

	public void setConsumeRecord(List consumeRecord) {
		this.consumeRecord = consumeRecord;
	}

	public List getRechargeRecord() {
		return rechargeRecord;
	}

	public void setRechargeRecord(List rechargeRecord) {
		this.rechargeRecord = rechargeRecord;
	}
	
	 
	
	
	
	
	
	

}
