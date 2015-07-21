package com.cineplex.service;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;




import com.cineplex.dao.BaseDao;
import com.cineplex.model.ConsumeRecord;
import com.cineplex.model.RechargeRecord;

public class ConsumeRecService {
	@Autowired
	private BaseDao dao;
	
	public List getRecords(String userid){
		List list=(List) dao.find(ConsumeRecord.class, "userid", userid);
		return list;
		
		
	}
	
	public boolean createRecord(String userid,int num){
		ConsumeRecord cr=new ConsumeRecord();
		cr.setNum(num);
		cr.setUserid(userid);
		Timestamp ts= new Timestamp(new Date().getTime());
		cr.setTime(ts);
		dao.save(cr);
		
		return true;
	}
}
