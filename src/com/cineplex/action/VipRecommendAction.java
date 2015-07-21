package com.cineplex.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.cineplex.model.Film;
import com.cineplex.model.User;
import com.cineplex.service.FilmService;
import com.opensymphony.xwork2.ActionSupport;

public class VipRecommendAction extends ActionSupport{

	
	List filmRecommendList;
	User user;
	private List<Film> filmList;
	
	@Override
	public String execute() throws Exception {
		 
		HttpServletRequest request = ServletActionContext.getRequest();
		user= (User) request.getSession().getAttribute("user");
		ApplicationContext appliationContext=new ClassPathXmlApplicationContext("applicationContext.xml");
		FilmService fs=(FilmService) appliationContext.getBean("filmservice");
		List<Film> list=fs.getRecommendFilms(user);
		
		this.filmList=list;
		return SUCCESS;
	}

	public List getFilmRecommendList() {
		return filmRecommendList;
	}

	public void setFilmRecommendList(List filmRecommendList) {
		this.filmRecommendList = filmRecommendList;
	}

	public List<Film> getFilmList() {
		return filmList;
	}

	public void setFilmList(List<Film> filmList) {
		this.filmList = filmList;
	}
	
	
}
