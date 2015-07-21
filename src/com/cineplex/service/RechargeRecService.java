package com.cineplex.service;

import java.sql.Timestamp;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import com.cineplex.dao.BaseDao;
import com.cineplex.model.RechargeRecord;

public class RechargeRecService {

	@Autowired
	private BaseDao dao;
	
	public List getRecords(String userid){
		List list=(List) dao.find(RechargeRecord.class, "userid", userid);
		return list;
		
		
	}
	
	public boolean createRecord(String userid,int num){
		RechargeRecord rr=new RechargeRecord();
		rr.setNum(num);
		rr.setUserid(userid);
		Timestamp ts= new Timestamp(new Date().getTime());
		rr.setTime(ts);
		dao.save(rr);
		
		return true;
	}
}
