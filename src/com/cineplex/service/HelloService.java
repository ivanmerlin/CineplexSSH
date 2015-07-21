package com.cineplex.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.cineplex.dao.BaseDao;
import com.cineplex.model.User;

public class HelloService {
	
	private String abc;
	
	
	@Autowired
	private BaseDao baseDao;
	public String getString(){
		List<User> list=baseDao.getAllList(User.class);
		for(User user : list){
			System.out.println(user.getUsername()+" "+user.getPassword());
		}
		
		
		
		
		
		return "haha";
	}
	public String getAbc() {
		return abc;
	}
	public void setAbc(String abc) {
		this.abc = abc;
	}
	
	
	
}
