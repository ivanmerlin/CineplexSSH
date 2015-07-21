package com.cineplex.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cineplex.dao.BaseDao;
import com.cineplex.model.ServiceUser;
import com.cineplex.model.User;


public class LoginService {
	@Autowired
	private BaseDao dao;

	public boolean match(String username,String password,String type){
		System.out.println("µΩloginservice’‚¡À£°");
//		dao=new BaseDao();
	
		System.out.println("type="+type);
		if(type.equals("member")){
			System.out.println("type.equals member true"+dao);
			
			boolean testMethod=dao.ifContain(User.class, "username", username);
			System.out.println("testMethod="+testMethod);
			
			List<User> list=dao.getAllList(User.class);
			System.out.println("get all list");
			User u=new User();
			for(User user:list){
				if(user.getUsername().equals(username)){
					u=user;
					System.out.println("find the user");
					break;
				}
					
			}		
			System.out.println("finish query");			
			if(u.getPassword().equals(password)){
				System.out.println("match successfully");
				return true;
			}
		}else if(type.equals("service")){
			List<ServiceUser> list=dao.getAllList(ServiceUser.class);
			System.out.println("get all list");
			ServiceUser u=new ServiceUser();
			for(ServiceUser user:list){
				if(user.getUsername().equals(username)){
					u=user;
					System.out.println("find the user");
					break;
				}
					
			}		
			System.out.println("finish query");			
			if(u.getPassword().equals(password)){
				System.out.println("match successfully");
				return true;
			}
		}
		
		return false;
	}
	


}
