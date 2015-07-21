package com.cineplex.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.cineplex.dao.BaseDao;
import com.cineplex.model.Opinion;
import com.cineplex.model.Order1;

public class OpinionsService {
	@Autowired
	private BaseDao dao;
	
	public Opinion getLatestOp(){
		List list=dao.getAllList(Opinion.class);
		if(list==null || list.size()==0){return null;}
		return (Opinion) list.get(list.size()-1);	
		
	}
	public List<Order1> getOrders(){
		List<Order1> list=dao.getAllList(Order1.class);
		return list;
	}
	
	
	public void saveOp(String content,String from){
		 Opinion o=new Opinion();
		 o.setContent(content);
		 o.setFrom1(from);
		 
		 
		 dao.save(o);
		
	}
	
}
