package com.cineplex.action;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.cineplex.model.User;
import com.cineplex.service.RegisterService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class RegisterAction  extends ActionSupport {
	
	String username;
	String password;
	String passwordconfirm;
	String email;
	String phone;
	
	



	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		
		if(username!=null &&password!=null &&passwordconfirm!=null&&email!=null&&phone!=null){
			System.out.println("username="+username);
			System.out.println("password="+password);
			System.out.println("passwordconfirm="+passwordconfirm);
			System.out.println("email="+email);
			System.out.println("phone="+phone);
			
			ApplicationContext appliationContext=new ClassPathXmlApplicationContext("applicationContext.xml");
			RegisterService rs=(RegisterService) appliationContext.getBean("registerservice");
			
			if(!password.equals(passwordconfirm)){
				return "fail";
			}
			User u=new User();
			u.setUsername(username);
			u.setPassword(password);
			u.setEmail(email);
			u.setPhone(phone);
			u.setActivate(0);
			u.setBalance(0);
			u.setGrade("普卡");
			u.setSum(0);
			u.setCredit(0);
			System.out.println("完成初始化，正在试图创建用户······");
			boolean ifCreate=rs.createUser(u);
			System.out.println("创建用户成功！");

			if(ifCreate){
				
				setUsername(null);
				setPassword(null);
				setEmail(null);
				setPhone(null);
				setPasswordconfirm(null);
				return "registersuccess";
			}else{
				setPassword(null);
				setPasswordconfirm(null);
				return "fail";
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



	public String getPasswordconfirm() {
		return passwordconfirm;
	}



	public void setPasswordconfirm(String passwordconfirm) {
		this.passwordconfirm = passwordconfirm;
	}



	public String getEmail() {
		return email;
	}



	public void setEmail(String email) {
		this.email = email;
	}



	public String getPhone() {
		return phone;
	}



	public void setPhone(String phone) {
		this.phone = phone;
	}

}
