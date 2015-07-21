package com.cineplex.service;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.cineplex.dao.BaseDao;
import com.cineplex.model.User;
import com.opensymphony.xwork2.ActionContext;

public class UserService {
	@Autowired
	private BaseDao dao;
	
	public User getUser(String username){
		List list= dao.find(User.class, "username", username);
		User u=(User) list.get(0);
		return u;
	}
	public User getUserById(String userid){
		List list= dao.find(User.class, "id", userid);
		User u=(User) list.get(0);
		return u;
	}
	public boolean match(String username,String password){
		User u=getUser(username);
		System.out.println("finish query");			
		if(u.getPassword().equals(password)){
			System.out.println("match successfully");
			return true;
		}
		return false;
	}
	public boolean updateInfo(User u){
		dao.update(u);
		return true;
	}
	public boolean recharge(User u,int money){
		System.out.println("OldBalance="+u.getBalance());
		u.setBalance(u.getBalance()+money);
		u.setSum(u.getSum()+money);
		System.out.println("NewBalance="+u.getBalance());
		checkGrade(u);
		if(u.getActivate()==0 && money>200){
			u.setActivate(1);
			Timestamp d = new Timestamp(System.currentTimeMillis());
			u.setActivatetime(d);
		}
		dao.update(u);
		
		ApplicationContext appliationContext=new ClassPathXmlApplicationContext("applicationContext.xml");
		RechargeRecService rrs=(RechargeRecService) appliationContext.getBean("rechargeservice");
		rrs.createRecord(u.getId(), money);
		
		ActionContext.getContext().getSession().put("user", u);
		return true;
	}
	public boolean cost(User u,int cost){
		cost=(int) (cost*getDiscount(u));
		if(u.getBalance()>=cost){
			System.out.println("Óà¶î×ã¹»¿Û¿î");
			u.setBalance(u.getBalance()-cost);
			u.setCredit(u.getCredit()+cost);
			dao.update(u);
			ApplicationContext appliationContext=new ClassPathXmlApplicationContext("applicationContext.xml");
			ConsumeRecService crs=(ConsumeRecService) appliationContext.getBean("consumeservice");
			crs.createRecord(u.getId(), cost);
			
			ActionContext.getContext().getSession().put("user", u);
			return true;
		}else{
			return false;
		}
	}
	public float getDiscount(User u){
		String type=u.getGrade();
		if(type.equals("Òø¿¨")){
			return (float) 0.95;
		}else if(type.equals("½ð¿¨")){
			return (float) 0.92;
		}else if(type.equals("×êÊ¯¿¨")){
			return (float) 0.88;
		}else if(type.equals("ÖÁ×ðVIP¿¨")){
			return (float) 0.85;
		}
		return 1;
		
		
	}
	public boolean checkGrade(User u){
		int sum=u.getSum();
		if(sum>500){
			if(sum<1000)
				u.setGrade("Òø¿¨");
			else if(sum<2000)
				u.setGrade("½ð¿¨");
			else if(sum<5000)
				u.setGrade("×êÊ¯¿¨");
			else{
				u.setGrade("ÖÁ×ðVIP¿¨");
			}
			
		}
		
		return true;
	}
	public boolean inactivate(User u){
		u.setActivate(0);
		dao.update(u);
		return true;
	}
	
	public boolean creditExchange(int creditNum,User u){
		int toAdd=creditNum/10;
		u.setBalance(u.getBalance()+toAdd);
		u.setCredit(u.getCredit()-toAdd*10);
		dao.update(u);
		return true;
		
	}
	public List getAllUsers(){
		return dao.getAllList(User.class);
	}
	
	public void addCredit(String userid,int num){
		User u=getUserById(userid);
		u.setCredit(u.getCredit()+num);
		dao.update(u);
	}
	
	public void dailyCheck(){
		List<User> list=getAllUsers();
		
		for(User u:list){
			if(u.getActivate()==1){
				if(u.getBalance()<200){
					Date old=new Date();
					old=u.getActivatetime();
					Date now=new Date();
					long diff=now.getTime()-old.getTime();
					long day=diff/(24*60*60*1000);
					if(day>=365){
						u.setActivate(0);
						dao.update(u);
					}
				}
			}
			
		}
	}
	
}
