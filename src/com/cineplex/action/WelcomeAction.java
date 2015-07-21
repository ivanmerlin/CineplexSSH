package com.cineplex.action;

import com.opensymphony.xwork2.ActionSupport;

public class WelcomeAction extends ActionSupport{

	private String type;
	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
//		if(type.equals("member"))
//			return "member";
//		if(type.equals("service"))
//			return "service";
		return SUCCESS;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}

}
