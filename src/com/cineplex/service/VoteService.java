package com.cineplex.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.cineplex.dao.BaseDao;
import com.cineplex.model.User;
import com.cineplex.model.VoteRecord;

public class VoteService {

	
	@Autowired
	private BaseDao dao;
	
	
	public boolean createRecord(User u,int eventid,int option){
		VoteRecord vr=new VoteRecord();
		vr.setEventid(eventid);
		vr.setOptionValue(option);
		vr.setUserid(u.getId());
		dao.save(vr);
		return true;		
	}
	
	
	public List getAllList(){
		return dao.getAllList(VoteRecord.class);
	}
	
	
	
}
