package com.cineplex.action;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.cineplex.service.UserService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class MemLoginAction extends ActionSupport {

	String username;
	String password;
	String type;
	public MemLoginAction(){
		type="member";
	}
	
	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		
		
		System.out.println("username="+username);
		System.out.println("password="+password);

	
		ApplicationContext appliationContext=new ClassPathXmlApplicationContext("applicationContext.xml");
		UserService us=(UserService) appliationContext.getBean("userservice");

		
		if(username!=null && password!=null){
			System.out.println("µΩ’‚¡À£°");
			boolean ifMacth=us.match(username, password);
			System.out.println("ifMacth="+ifMacth);
			
			ActionContext.getContext().getSession().put("user", us.getUser(username));
			setUsername(null);
			setPassword(null);
			return "loginSuccess" ;
		}
		return SUCCESS;
	}


	public String getUsername() {
		return username;
	}


	public void setUsername(String username) {
		this.username = username;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}
	
	

}
