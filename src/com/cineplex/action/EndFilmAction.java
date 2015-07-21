package com.cineplex.action;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.cineplex.service.EventService;
import com.cineplex.service.FilmService;
import com.opensymphony.xwork2.ActionSupport;

public class EndFilmAction extends ActionSupport{

	List filmList;
	String filmName;
	
	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		ApplicationContext appliationContext=new ClassPathXmlApplicationContext("applicationContext.xml");
		FilmService fs=(FilmService) appliationContext.getBean("filmservice");
		filmList=fs.getOnlineFilm();

		if(filmName!=null){
			boolean hasEnd=fs.endFilm(filmName);
			System.out.println("hasEnd="+hasEnd);
			
			setFilmName(null);
			filmList=fs.getOnlineFilm();
		}
		
		return SUCCESS;
	}

	public List getFilmList() {
		return filmList;
	}

	public void setFilmList(List filmList) {
		this.filmList = filmList;
	}

	public String getFilmName() {
		return filmName;
	}

	public void setFilmName(String filmName) {
		this.filmName = filmName;
	}

	
	
}
