package com.cineplex.action;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.cineplex.model.User;
import com.cineplex.service.UserService;
import com.opensymphony.xwork2.ActionSupport;

public class VipQualificationAction extends ActionSupport{

	User user;

	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		HttpServletRequest request = ServletActionContext.getRequest();
		user= (User) request.getSession().getAttribute("user");
		
		
		
		
		return SUCCESS;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	




	
}
