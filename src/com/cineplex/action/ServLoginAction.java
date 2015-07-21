package com.cineplex.action;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.cineplex.service.LoginService;
import com.cineplex.service.ServiceUserService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class ServLoginAction extends ActionSupport{
	
	String username;
	String password;
	String type;
	public ServLoginAction(){
		type="service";
	}
	
	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		
		System.out.println("username="+username);
		System.out.println("password="+password);
		
		ApplicationContext appliationContext=new ClassPathXmlApplicationContext("applicationContext.xml");
		LoginService ls=(LoginService) appliationContext.getBean("loginservice");

		
		if(username!=null && password!=null){
			System.out.println("µΩ’‚¡À£°");
			boolean ifMacth=ls.match(username, password, type);
			System.out.println("ifMacth="+ifMacth);
			
			ServiceUserService sus=(ServiceUserService) appliationContext.getBean("serviceuserservice");
			if(sus.match(username, password)){
				setPassword(null);
				ActionContext.getContext().getSession().put("user", sus.getUser(username));
				if(sus.isManager(username)==1){
					
					return "managerSuccess";
				}else if(sus.isManager(username)==0){
					return "serviceSuccess";
				}else{
					return "bossSuccess";
				}
			}else{
				return "loginFailed";
			}
			
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
