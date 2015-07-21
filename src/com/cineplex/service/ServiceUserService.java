package com.cineplex.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.cineplex.dao.BaseDao;
import com.cineplex.model.ServiceUser;
import com.cineplex.model.User;


public class ServiceUserService {
	@Autowired
	private BaseDao dao;
	
	
	public ServiceUser getUser(String username){
		List list= dao.find(ServiceUser.class, "username", username);
		ServiceUser u=(ServiceUser) list.get(0);
		return u;
	}
	
	public boolean match(String username,String password){
		ServiceUser u=getUser(username);
		System.out.println("finish query");			
		if(u.getPassword().equals(password)){
			System.out.println("match successfully");
			return true;
		}
		return false;
	}
	public int isManager(String username){
		ServiceUser u=getUser(username);
		return u.getIsManager();
	}
	
	
}
