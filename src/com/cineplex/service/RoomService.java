package com.cineplex.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.cineplex.dao.BaseDao;
import com.cineplex.model.Film;
import com.cineplex.model.Room;

public class RoomService {

	@Autowired
	private BaseDao dao;
	
	public Room getRoom(String id){
		List list= dao.find(Room.class, "id", id);
		Room r=(Room) list.get(0);
		return r;
	}
	public int getRoomId(String roomName){
		List list=dao.find(Room.class,"name",roomName);
		System.out.println("’“µΩ¡Àroom");
		Room r=(Room) list.get(0);
		return r.getId();
	}
	
	public List getAllRoom(){
		
		return dao.getAllList(Room.class);
	}
	
	
	
	
}
