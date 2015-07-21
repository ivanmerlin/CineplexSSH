package com.cineplex.action;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.RequestAware;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.cineplex.model.User;
import com.cineplex.service.ConsumeRecService;
import com.cineplex.service.RechargeRecService;
import com.cineplex.service.UserService;
import com.opensymphony.xwork2.ActionSupport;

public class VipInfoAction extends ActionSupport implements RequestAware{

	User user;
	String birthYear;
	String birthMonth;
	String birthDay;
	String liveCity;
	String gender;
	String result;
	
	List rechargeRecord;
	List consumeRecord;


	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}



	
	int creditNum;

	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		HttpServletRequest request = ServletActionContext.getRequest();
		user= (User) request.getSession().getAttribute("user");
		
		
		
		

		
		return SUCCESS;
	}
	
	public String exchange() throws Exception{
		HttpServletRequest request = ServletActionContext.getRequest();
		user= (User) request.getSession().getAttribute("user");
		
		System.out.println("进入到exchange啦！");
		System.out.println("creditNum="+creditNum);
		if(creditNum!=0){
			ApplicationContext appliationContext=new ClassPathXmlApplicationContext("applicationContext.xml");
			UserService us=(UserService) appliationContext.getBean("userservice");
			us.creditExchange(creditNum, user);
			return "exchangeSuccess";
			
		}
		return SUCCESS;
	}
	
	public String edit() throws Exception{
		HttpServletRequest request = ServletActionContext.getRequest();
		user= (User) request.getSession().getAttribute("user");

	
		Date birthdate=user.getBirthdate();
		if(birthdate!=null){
			DateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss"); 
			sdf = new SimpleDateFormat("yyyy"); 
			birthYear=sdf.format(birthdate);
			sdf = new SimpleDateFormat("MM");
			birthMonth=sdf.format(birthdate);
			sdf = new SimpleDateFormat("dd");
			birthDay=sdf.format(birthdate);
		}
		
		if(user.getGender()!=null){
			gender=user.getGender();
		}
		if(user.getCity()!=null){
			liveCity=user.getCity();
		}
		
		
		return SUCCESS;
	}
	
	public String editComplete() throws Exception{
		HttpServletRequest request = ServletActionContext.getRequest();
		user= (User) request.getSession().getAttribute("user");

	
		ApplicationContext appliationContext=new ClassPathXmlApplicationContext("applicationContext.xml");
		UserService us=(UserService) appliationContext.getBean("userservice");
		
		
		String dateStr=birthYear+"/"+birthMonth+"/"+birthDay;
		DateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");  
        Date date = new Date();  
        date = sdf.parse(dateStr);  
        
        user.setBirthdate(date);
        user.setGender(gender);
		user.setCity(liveCity);
		
		boolean b=us.updateInfo(user);
		
		result=(b==true)?"修改成功":"修改失败了";
		
		return SUCCESS;
	}

	public String rechargeInfo(){
		HttpServletRequest request = ServletActionContext.getRequest();
		user= (User) request.getSession().getAttribute("user");
		ApplicationContext appliationContext=new ClassPathXmlApplicationContext("applicationContext.xml");
		RechargeRecService rrs=(RechargeRecService) appliationContext.getBean("rechargeservice");
		
		rechargeRecord=rrs.getRecords(user.getId());
		System.out.println("rechargeRecord="+rechargeRecord.size());
		
		
		
		return SUCCESS;
	}
	
	public String consumeInfo(){
		HttpServletRequest request = ServletActionContext.getRequest();
		user= (User) request.getSession().getAttribute("user");
		ApplicationContext appliationContext=new ClassPathXmlApplicationContext("applicationContext.xml");
		ConsumeRecService crs=(ConsumeRecService) appliationContext.getBean("consumeservice");
		
		consumeRecord=crs.getRecords(user.getId());
		System.out.println("consumeRecord="+consumeRecord.size());
		return SUCCESS;
		
	}
	
	@Override
	public void setRequest(Map<String, Object> arg0) {
		// TODO Auto-generated method stub
		
	}

	
	
	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public String getBirthYear() {
		return birthYear;
	}

	public void setBirthYear(String birthYear) {
		this.birthYear = birthYear;
	}

 
	public String getBirthMonth() {
		return birthMonth;
	}

	public void setBirthMonth(String birthMonth) {
		this.birthMonth = birthMonth;
	}

	public String getBirthDay() {
		return birthDay;
	}

	public void setBirthDay(String birthDay) {
		this.birthDay = birthDay;
	}

	public String getLiveCity() {
		return liveCity;
	}

	public void setLiveCity(String liveCity) {
		this.liveCity = liveCity;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public int getCreditNum() {
		return creditNum;
	}

	public void setCreditNum(int creditNum) {
		this.creditNum = creditNum;
	}

	
	
	public List getRechargeRecord() {
		return rechargeRecord;
	}

	public void setRechargeRecord(List rechargeRecord) {
		this.rechargeRecord = rechargeRecord;
	}

	public List getConsumeRecord() {
		return consumeRecord;
	}

	public void setConsumeRecord(List consumeRecord) {
		this.consumeRecord = consumeRecord;
	}


	
	
}
