package com.cineplex.action;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.cineplex.model.User;
import com.cineplex.service.UserService;
import com.opensymphony.xwork2.ActionSupport;

public class RechargeAction extends ActionSupport{

	
	String money;
	User user;

	
	public String getMoney() {
		return money;
	}

	public void setMoney(String money) {
		this.money = money;
	}

	
	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		HttpServletRequest request = ServletActionContext.getRequest();
		user= (User) request.getSession().getAttribute("user");
		ApplicationContext appliationContext=new ClassPathXmlApplicationContext("applicationContext.xml");
		UserService us=(UserService) appliationContext.getBean("userservice");
		
		System.out.println("money="+money);
		if(money!=null){
			int temp=Integer.valueOf(money).intValue();
			System.out.println("temp="+temp);
			us.recharge(user, temp);
			money=null;
			return "rechargeSuccess" ;
		}
		
		
		
		return SUCCESS;
	}
	
	
	
	
	
	
	
}
