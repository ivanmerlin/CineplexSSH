package com.cineplex.action;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.cineplex.model.User;
import com.cineplex.service.RegisterService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class MemberQualifyAction extends ActionSupport {

	
	String bankId;
	public String getBankId() {
		return bankId;
	}

	public void setBankId(String bankId) {
		this.bankId = bankId;
	}
	User user;
	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		
		
		System.out.println("bankId="+bankId);
		if(bankId!=null ){
			System.out.println("∑¢œ÷¡ÀbankId!");
			
			HttpServletRequest request = ServletActionContext.getRequest();

			user= (User) request.getSession().getAttribute("user");
			String username=user.getUsername();
			System.out.println(username);
			ApplicationContext appliationContext=new ClassPathXmlApplicationContext("applicationContext.xml");
			RegisterService rs=(RegisterService) appliationContext.getBean("registerservice");
			boolean result=rs.insertBankId(bankId, username);
			System.out.println("insert bank id "+result);
			setBankId(null);
			return "activateSuccess";
			
			
		}
			
		return SUCCESS;
	}
	
	
	
	
}
