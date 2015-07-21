package com.cineplex.service;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.cineplex.dao.BaseDao;
import com.cineplex.model.FilmPlan;

public class FilmPlanService {

	@Autowired
	private BaseDao dao;
	
	
	public FilmPlan getPlan(String id){
		List list= dao.find(FilmPlan.class, "id", id);
		FilmPlan f=(FilmPlan) list.get(0);
		return f;
	}
	public List getPlanByFilm(String filmName){
		List list= dao.find(FilmPlan.class, "filmName", filmName);		
		return list;
	}
	public List getAllFilmPlan(){
		
		return dao.getAllList(FilmPlan.class);
	}
	public List getUnPassedList(){
		List list= dao.find(FilmPlan.class, "pass", "0");
		return list;		
	}
	public List getPassedList(){
		List list= dao.find(FilmPlan.class, "pass", "1");
		return list;			
	}
	public boolean createPlan(String filmName,String filmPrice,String roomName,String filmTime){
		FilmPlan fp=new FilmPlan();
		System.out.println("新建一个filmPlan");
		int price=Integer.valueOf(filmPrice).intValue();
		System.out.println("int price="+price);
		ApplicationContext appliationContext=new ClassPathXmlApplicationContext("applicationContext.xml");
		System.out.println(" roomName="+roomName);
		Timestamp ts = new Timestamp(System.currentTimeMillis());  
		System.out.println(" 尝试创建timestamp");
        try {  
            ts = Timestamp.valueOf(filmTime);  
            System.out.println(ts);  
        } catch (Exception e) {  
            e.printStackTrace();  
        }  
		fp.setStarttime(ts);
		fp.setFilmName(filmName);
		fp.setPrice(price);	
		fp.setRoomName(roomName);	
		
		fp.setPass(0);
		
		dao.save(fp);
		
		return true;
		
		
		
	}
	
	public boolean editPlan(String id,int price,String time,String roomName){
		FilmPlan fp=getPlan(id);
		Timestamp ts = new Timestamp(System.currentTimeMillis());
		  ts = Timestamp.valueOf(time); 
		  
		fp.setStarttime(ts);
		fp.setPrice(price);
		fp.setRoomName(roomName);
		
		dao.update(fp);
		return true;
	}
	public boolean passPlan(String id){
		FilmPlan fp=getPlan(id);
		fp.setPass(1);
		dao.update(fp);
		
		return true;
		
	}
	
	public ArrayList searchPlan(String dateTime){
		
		List<FilmPlan> list=getAllFilmPlan();
		ArrayList result=new ArrayList();
		for(FilmPlan fp:list){ 
	        String tsStr = "";  
	        DateFormat sdf = new SimpleDateFormat("yyyy-MM-dd"); 	        
	        tsStr=sdf.format(fp.getStarttime());
	        System.out.println("tsStr="+tsStr);  
	        if(dateTime.equals(tsStr)){
	        	result.add(fp);
	        }
		}		
		return result;		
	}
	public ArrayList searchPlan(String dateTime,String filmName){
		
		List<FilmPlan> list=getPlanByFilm(filmName);		
		ArrayList result=new ArrayList();
		for(FilmPlan fp:list){ 
	        String tsStr = "";  
	        DateFormat sdf = new SimpleDateFormat("yyyy-MM-dd"); 	        
	        tsStr=sdf.format(fp.getStarttime());
	        System.out.println("tsStr="+tsStr);  
	        if(dateTime.equals(tsStr)){
	        	result.add(fp);
	        }
		}		
		return result;		
	}	
	
}
