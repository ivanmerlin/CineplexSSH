package com.cineplex.action;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.RequestAware;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.cineplex.model.FilmPlan;
import com.cineplex.model.Seat;
import com.cineplex.model.User;
import com.cineplex.service.FilmPlanService;
import com.cineplex.service.FilmService;
import com.cineplex.service.OrderService;
import com.cineplex.service.SeatService;
import com.cineplex.service.UserService;
import com.opensymphony.xwork2.ActionSupport;

public class SellTicketAction extends ActionSupport implements RequestAware{

	
	
	int num;
	String chosenTime;
	String chosenFilm;
	int selectPlanId;
	List filmList;
	List planList;
	ArrayList<String> dayList=new ArrayList<String>();
	String userId;
	int row;
	int col;
	int index;
	List<Seat> seatresult;
	
	
	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");//设置日期格式
		Date date=new Date();
		Calendar calendar=new GregorianCalendar();
		calendar.setTime(date);
		dayList.clear();
		for(int i=0;i<7;i++){
			System.out.println("i="+i);
			String dateStr=df.format(date);
			calendar.add(calendar.DATE, 1);
			date=calendar.getTime();
			System.out.println("dateStr="+dateStr);
			dayList.add(dateStr);			
		}
		ApplicationContext appliationContext=new ClassPathXmlApplicationContext("applicationContext.xml");
		FilmService fs=(FilmService) appliationContext.getBean("filmservice");
		filmList=fs.getAllFilm();
		if(chosenTime!=null){
			FilmPlanService fps=(FilmPlanService) appliationContext.getBean("filmplanservice");
			
			if(chosenFilm!=null&&(!chosenFilm.equals("全部")) ){
				planList=fps.searchPlan(chosenTime, chosenFilm);
				System.out.println("planList.size="+planList.size());
			}else{
				planList=fps.searchPlan(chosenTime);
				System.out.println("planList.size="+planList.size());
			}			
		}
		
		System.out.println("*******************");
		System.out.println("selectPlanid="+selectPlanId);
		System.out.println("num="+num);
		
		System.out.println("*******************");
		
		return SUCCESS;
	}
	
	
	public String cash() throws Exception {
		
		System.out.println("进入到现金购买action了！");
		System.out.println("*******************");
		System.out.println("selectPlanid="+selectPlanId);
		System.out.println("num="+num);
		
		System.out.println("*******************");
		ApplicationContext appliationContext=new ClassPathXmlApplicationContext("applicationContext.xml");
		OrderService os=(OrderService) appliationContext.getBean("orderservice");

		os.createOrder(selectPlanId, num);			
		setUserId(null);
		setChosenTime(null);
		setChosenFilm(null);
		setSelectPlanId(0);
		
		return SUCCESS;
	}
	public String card() throws Exception{

		System.out.println("进入到卡购买action了！");
		System.out.println("*******************");
		System.out.println("selectPlanid="+selectPlanId);
		System.out.println("num="+num);
		
		System.out.println("*******************");
		if(userId!=null){
			ApplicationContext appliationContext=new ClassPathXmlApplicationContext("applicationContext.xml");
			FilmPlanService fps=(FilmPlanService) appliationContext.getBean("filmplanservice");
			FilmPlan filmPlan = fps.getPlan(selectPlanId+"");
			UserService us=(UserService) appliationContext.getBean("userservice");
			User user=us.getUserById(userId);
			boolean hasConsumed=us.cost(user,filmPlan.getPrice()*num);
			
			if(hasConsumed){
			OrderService os=(OrderService) appliationContext.getBean("orderservice");
			os.createOrder(userId,selectPlanId, num);

			setUserId(null);
			setChosenTime(null);
			setChosenFilm(null);
			setSelectPlanId(0);
			
			return "purchaseSuccess";

			}else{
				setUserId(null);
				setChosenTime(null);
				setChosenFilm(null);
				setSelectPlanId(0);
				return "purchaseFail";
			}
			
			
		}
		
		return SUCCESS;
	}
	
	public String select_seat(){
		
		ApplicationContext applicationContext=new ClassPathXmlApplicationContext("applicationContext.xml");
		SeatService ss=(SeatService) applicationContext.getBean("seatservice");
		ss.createSeat(row, col, selectPlanId);
		return SUCCESS;
	}
	
	public String get_unavailable_seat(){
		ApplicationContext applicationContext=new ClassPathXmlApplicationContext("applicationContext.xml");
		SeatService ss=(SeatService) applicationContext.getBean("seatservice");
		seatresult=ss.getSeat(selectPlanId);
		return SUCCESS;
	}

	@Override
	public void setRequest(Map<String, Object> arg0) {
		// TODO Auto-generated method stub
		
	}


	public int getRow() {
		return row;
	}


	public void setRow(int row) {
		this.row = row;
	}


	public int getCol() {
		return col;
	}


	public void setCol(int col) {
		this.col = col;
	}


	public int getIndex() {
		return index;
	}


	public void setIndex(int index) {
		this.index = index;
	}


	public List<Seat> getSeatresult() {
		return seatresult;
	}


	public void setSeatresult(List<Seat> seatresult) {
		this.seatresult = seatresult;
	}


	public List getFilmList() {
		return filmList;
	}


	public String getUserId() {
		return userId;
	}


	public void setUserId(String userId) {
		this.userId = userId;
	}


	public void setFilmList(List filmList) {
		this.filmList = filmList;
	}


	public List getPlanList() {
		return planList;
	}


	public void setPlanList(List planList) {
		this.planList = planList;
	}


	public ArrayList<String> getDayList() {
		return dayList;
	}


	public void setDayList(ArrayList<String> dayList) {
		this.dayList = dayList;
	}


	public int getNum() {
		return num;
	}


	public void setNum(int num) {
		this.num = num;
	}


	public String getChosenTime() {
		return chosenTime;
	}


	public void setChosenTime(String chosenTime) {
		this.chosenTime = chosenTime;
	}


	public String getChosenFilm() {
		return chosenFilm;
	}


	public void setChosenFilm(String chosenFilm) {
		this.chosenFilm = chosenFilm;
	}


	public int getSelectPlanId() {
		return selectPlanId;
	}


	public void setSelectPlanId(int selectPlanId) {
		this.selectPlanId = selectPlanId;
	}
	
	
	
}
