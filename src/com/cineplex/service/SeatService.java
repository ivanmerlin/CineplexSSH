package com.cineplex.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.cineplex.dao.BaseDao;
import com.cineplex.model.Seat;

public class SeatService {

	@Autowired
	private BaseDao dao;
	
	public void createSeat(int row,int col,int planid){
		Seat s=new Seat();
		s.setRow(row);
		s.setCol(col);
		s.setPlanid(planid);
		dao.save(s);
	}

	public List<Seat> getSeat(int selectPlanId) {
		return dao.executeQuery("from Seat where planid="+selectPlanId);
	}
}
