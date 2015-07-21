package com.cineplex.action;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.cineplex.service.UserService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class MemLogoutAction extends ActionSupport {

	
	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		
		ActionContext.getContext().getSession().put("user", null);
		
		return SUCCESS;
	}

}
