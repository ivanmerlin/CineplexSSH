package com.cineplex.action;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.cineplex.model.User;
import com.cineplex.service.RegisterService;
import com.cineplex.service.UserService;
import com.opensymphony.xwork2.ActionSupport;

public class VipCancelAction extends ActionSupport{

	
	String confirm;
	User user;
	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		HttpServletRequest request = ServletActionContext.getRequest();
		user= (User) request.getSession().getAttribute("user");
		if(confirm!=null){
			if(confirm.equals("х╥хо")){				
				ApplicationContext appliationContext=new ClassPathXmlApplicationContext("applicationContext.xml");
				UserService us=(UserService) appliationContext.getBean("userservice");
				us.inactivate(user);
			}
			setConfirm(null);
			return "back";
		}
		
		
		return SUCCESS;
	}

	public String getConfirm() {
		return confirm;
	}

	public void setConfirm(String confirm) {
		this.confirm = confirm;
	}

	
	
}
