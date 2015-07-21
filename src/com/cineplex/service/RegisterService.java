package com.cineplex.service;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;

import com.cineplex.dao.BaseDao;
import com.cineplex.model.User;
import com.opensymphony.xwork2.ActionContext;

@Service("registerservice")
public class RegisterService {
	
	@Autowired
	private BaseDao dao;
	
	public boolean createUser(User u){
		boolean ifExist=dao.ifContain(User.class, "username", u.getUsername());
		
		if(!ifExist){
			if(!isPureDigit(u.getUsername())){
				String id="0000000";
				System.out.println("正在分配ID······");
				while(dao.ifContain(User.class,"id",id)){
					System.out.println("包含了呢");
					int temp=(int) (Math.random()*10000000);
					System.out.println("randomID="+temp);
					id=temp+"";
				}
				System.out.println("no包含了呢");
				u.setId(id);
				
				dao.save(u);
				ActionContext.getContext().getSession().put("user", u);
				return true;
			}
		}
		
		
		return false;
		
	}
	public boolean insertBankId(String bankId,String username){
	
		
		List<User> list=dao.find(User.class, "username", username);
		System.out.println("啊找到了username了呢");
		User u=list.get(0);
		u.setBankid(bankId);
		u.setBalance(200);
		u.setActivate(1);
		u.setSum(200);
		ApplicationContext appliationContext=new ClassPathXmlApplicationContext("applicationContext.xml");
		RechargeRecService rrs=(RechargeRecService) appliationContext.getBean("rechargeservice");
		rrs.createRecord(u.getId(), 200);
		Timestamp d = new Timestamp(System.currentTimeMillis());
		u.setActivatetime(d);
		
		dao.update(u);
		ActionContext.getContext().getSession().put("user", u);
		System.out.println("啊 更新完毕了呢");
		return true;
	}
	

	private boolean isPureDigit(String n){
		
		char[] ch=n.toCharArray();
		for(char c:ch){
			if(!isDigit(c)){
				return false;
			}
				
		}
		
		return true;
	}
	private boolean isDigit(char c){
		if(c>='0'&&c<='9')
			return true;
		return false;
	}
	
}
