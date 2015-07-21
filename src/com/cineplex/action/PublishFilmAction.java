package com.cineplex.action;

import org.apache.struts2.convention.annotation.Action;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Repository;

import com.cineplex.service.FilmService;
import com.cineplex.service.UserService;
import com.opensymphony.xwork2.ActionSupport;

@Repository("publishFilm")
public class PublishFilmAction extends ActionSupport{

	
	
	String filmname;
	String filmlength;
	String filmtype;
	



	@Override
	public String execute() throws Exception {
		System.out.println(filmname);
		if(filmname!=null && filmlength!=null){
			ApplicationContext appliationContext=new ClassPathXmlApplicationContext("applicationContext.xml");
			FilmService fs=(FilmService) appliationContext.getBean("filmservice");
			fs.publishFilm(filmname, filmlength,filmtype);
			System.out.println("filmname="+filmname);
			setFilmlength(null);
			setFilmname(null);
			
			System.out.println("´´½¨Íê±Ï");
			
			
		}
		
		return SUCCESS;
	}

	
	public String getFilmname() {
		System.out.println("getFilmname process---filmname="+filmname);
		return filmname;
	}



	public void setFilmname(String filmname) {
		System.out.println("setFilmname process---filmname="+filmname);
		this.filmname = filmname;
	}



	public String getFilmlength() {
		return filmlength;
	}



	public void setFilmlength(String filmlength) {
		this.filmlength = filmlength;
	}


	public String getFilmtype() {
		return filmtype;
	}


	public void setFilmtype(String filmtype) {
		this.filmtype = filmtype;
	}

	
}
