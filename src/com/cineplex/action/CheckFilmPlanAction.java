package com.cineplex.action;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.cineplex.model.FilmPlan;
import com.cineplex.model.Opinion;
import com.cineplex.service.FilmPlanService;
import com.cineplex.service.OpinionsService;
import com.opensymphony.xwork2.ActionSupport;

public class CheckFilmPlanAction extends ActionSupport {

	
	
	List<FilmPlan> planList;
	String id;
	String opinion;
	
	public String getOpinion() {
		return opinion;
	}



	public void setOpinion(String opinion) {
		this.opinion = opinion;
	}



	public String getId() {
		return id;
	}



	public void setId(String id) {
		this.id = id;
	}



	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		try {
		
		ApplicationContext appliationContext=new ClassPathXmlApplicationContext("applicationContext.xml");
		FilmPlanService fps=(FilmPlanService) appliationContext.getBean("filmplanservice");
		planList=fps.getUnPassedList();
		
		for(FilmPlan fp:planList){
			System.out.println(fp.getFilmName()+" "+fp.getStarttime());
		}
		System.out.println("id="+id);
		if(id!=null){
			fps.passPlan(id);
			System.out.println("通过了一项");
			setId(null);
		}
		OpinionsService fs=(OpinionsService) appliationContext.getBean("opinionsService");
		Opinion oo=fs.getLatestOp();
		if(oo!=null){
		opinion=fs.getLatestOp().getContent();
		}else{
			opinion="暂无";
		}
		
		} catch (Exception e) {
		e.printStackTrace();}
		return SUCCESS;
	}



	public List<FilmPlan> getPlanList() {
		return planList;
	}



	public void setPlanList(List<FilmPlan> planList) {
		this.planList = planList;
	}
	

}
