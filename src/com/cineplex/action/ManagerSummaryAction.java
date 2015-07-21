package com.cineplex.action;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Map;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.RequestAware;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.cineplex.model.Film;
import com.cineplex.model.Order1;
import com.cineplex.model.Room;
import com.cineplex.model.User;
import com.cineplex.service.FilmService;
import com.cineplex.service.OpinionsService;
import com.cineplex.service.OrderService;
import com.cineplex.service.RoomService;
import com.cineplex.service.UserService;
import com.opensymphony.xwork2.ActionSupport;

public class ManagerSummaryAction extends ActionSupport implements RequestAware {

	List<User> userList;
	int[] ageSum = new int[5];
	int[] genderSum = new int[2];
	int[] citySum = new int[3];
	List<Order1> orderList;
	int[] costSum = new int[4];
	int[] eventSum = new int[3];
	int[] activateSum = new int[2];
	ArrayList<String> dayList = new ArrayList<String>();
	int[] daySum = new int[7];
	int[] monthSum = new int[6];
	ArrayList<String> monthList = new ArrayList<String>();
	List<Room> roomList;
	double[][] roomSum=new double[4][7];
	List<Film> filmList;
	double[][] filmSum=new double[4][7];
	int[] purchaseWaySum=new int[2];
	int[] likeSum=new int[4];
	double[] ratio=new double[4];
	String typeSum;
	String typeName;
	public String roomSummary() {
		try {
			ApplicationContext appliationContext = new ClassPathXmlApplicationContext(
					"applicationContext.xml");
			OrderService os = (OrderService) appliationContext
					.getBean("orderservice");
			orderList = os.getAllOrders();
			
			RoomService rs = (RoomService) appliationContext
					.getBean("roomservice");
			roomList=rs.getAllRoom();
			FilmService fs = (FilmService) appliationContext
					.getBean("filmservice");
			filmList=fs.getAllFilm();

			SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");// 设置日期格式
			Date date = new Date();
			Calendar calendar = new GregorianCalendar();
			calendar.setTime(date);
			dayList.clear();
			monthList.clear();
			for (int i = 0; i < daySum.length; i++) {
				daySum[i] = 0;
			}
			for (int i = 0; i < monthSum.length; i++) {
				monthSum[i] = 0;
			}
			for(int i=0;i<4;i++){
				for(int j=0;j<7;j++){
					roomSum[i][j]=0.0;
				}
			}
			for (int i = 0; i < 7; i++) {
				// System.out.println("i="+i);
				
				String dateStr = df.format(date);
				dayList.add(dateStr);
				calendar.add(calendar.DATE, -1);
				date = calendar.getTime();
				System.out.println("dateStr=" + dateStr);
				
			}
			int index = 0;
			for (String str : dayList) {
				for (Order1 o : orderList) {
					String s = df.format(o.getStarttime());
					if (s.equals(str)) {
						daySum[index]+=o.getNum();
					}
				}
				index++;
			}
			
			for(int i=0;i<4;i++){

				index=0;
				String roomName=roomList.get(i).getName();
				String filmName=filmList.get(i).getName();
				for (String str : dayList) {
					for (Order1 o : orderList) {
						String s = df.format(o.getStarttime());
						if (s.equals(str)&&roomName.equals(o.getRoomname())) {
							roomSum[i][index]+=o.getNum();
						}
						String t=o.getFilmname();
						if(t.equals(filmName)&&s.equals(str)){
							filmSum[i][index]+=o.getNum();
						}
						
					}
					roomSum[i][index]=roomSum[i][index]/roomList.get(i).getSize()*100;
					index++;
					
					
				}
				
				
				
				
				
			}
			
			df = new SimpleDateFormat("yyyy-MM");

			date = new Date();
			calendar.setTime(date);
			for (int i = 0; i < 6; i++) {
				String dateStr = df.format(date);
				monthList.add(dateStr);
				calendar.add(calendar.MONTH, -1);
				date = calendar.getTime();
				// System.out.println("dateStr="+dateStr);
			}
			
			index = 0;
			for (String str : monthList) {
				for (Order1 o : orderList) {
					String s = df.format(o.getStarttime());
					if (s.equals(str)) {
						monthSum[index]+=o.getNum();
					}
				}
				index++;
			}
			
			for(Order1 o:orderList){
				if(o.getUserid()!=null){
					purchaseWaySum[1]+=o.getNum();
				}else{
					purchaseWaySum[0]+=o.getNum();
				}
			}

			
			

		} catch (Exception e) {
			e.printStackTrace();
		}

		return SUCCESS;
	}

	public String likeSummary() throws Exception {
		ApplicationContext appliationContext = new ClassPathXmlApplicationContext(
				"applicationContext.xml");
		OrderService os = (OrderService) appliationContext
				.getBean("orderservice");
		orderList = os.getAllOrders();

		FilmService fs = (FilmService) appliationContext
				.getBean("filmservice");
		filmList=fs.getAllFilm();
		
		
		for(Order1 o:orderList){
			if(o.getFilmname().equals(filmList.get(0).getName())){
				likeSum[0]+=o.getNum();
			}else if(o.getFilmname().equals(filmList.get(1).getName())){
				likeSum[1]+=o.getNum();
			}else if(o.getFilmname().equals(filmList.get(2).getName())){
				likeSum[2]+=o.getNum();
			}else if(o.getFilmname().equals(filmList.get(3).getName())){
				likeSum[3]+=o.getNum();
			}
		}
		
		
		
		

		return SUCCESS;
	}

	public String vipSummary() {
		try {
			ApplicationContext appliationContext = new ClassPathXmlApplicationContext(
					"applicationContext.xml");
			UserService us = (UserService) appliationContext
					.getBean("userservice");
			userList = us.getAllUsers();
			OrderService os = (OrderService) appliationContext
					.getBean("orderservice");
			orderList = os.getAllOrders();

			for (int i = 0; i < ageSum.length; i++) {
				ageSum[i] = 0;
			}
			for (int i = 0; i < genderSum.length; i++) {
				genderSum[i] = 0;
			}
			for (int i = 0; i < citySum.length; i++) {
				citySum[i] = 0;
			}
			for (int i = 0; i < costSum.length; i++) {
				costSum[i] = 0;
			}
			for (int i = 0; i < activateSum.length; i++) {
				activateSum[i] = 0;
			}
			for (User u : userList) {
				int age = u.getAge();
				if (age >= 0 && age < 20) {
					ageSum[0]++;
				} else if (age < 30) {
					ageSum[1]++;
				} else if (age < 40) {
					ageSum[2]++;
				} else if (age < 50) {
					ageSum[3]++;
				} else if (age >= 50) {
					ageSum[4]++;
				}

				String gender = u.getGender();
				if (gender != null) {
					if (gender.equals("男")) {
						genderSum[0]++;
					} else if (gender.equals("女")) {
						genderSum[1]++;
					}
				}
				String city = u.getCity();
				if (city != null) {
					if (city.equals("北京")) {
						citySum[0]++;
					} else if (city.equals("上海")) {
						citySum[1]++;
					} else if (city.equals("南京")) {
						citySum[2]++;
					}
				}
				if (u.getActivate() == 1) {
					activateSum[0]++;
				} else {
					activateSum[1]++;
				}

			}

			for (Order1 o : orderList) {
				String filmname = o.getFilmname();
				if (filmname.equals("超能陆战队")) {
					costSum[0]++;
				} else if (filmname.equals("指环王")) {
					costSum[1]++;
				} else if (filmname.equals("木星上行")) {
					costSum[2]++;
				} else if (filmname.equals("王牌特工")) {
					costSum[3]++;
				}
			}

			eventSum[0] = 3;
			eventSum[1] = 0;
			eventSum[2] = 0;
		} catch (Exception e) {
			e.printStackTrace();
		}

		return SUCCESS;
	}

	@Override
	public void setRequest(Map<String, Object> arg0) {
		// TODO Auto-generated method stub

	}

	public String changeratio(){
		ratio[0]=0.95;
		ratio[1]=0.92;
		ratio[2]=0.88;
		ratio[3]=0.85;
		return SUCCESS;
	}
	double ratio1;
	double ratio2;
	double ratio3;
	double ratio4;
	

	public double getRatio1() {
		return ratio1;
	}

	public void setRatio1(double ratio1) {
		this.ratio1 = ratio1;
	}

	public double getRatio2() {
		return ratio2;
	}

	public void setRatio2(double ratio2) {
		this.ratio2 = ratio2;
	}

	public double getRatio3() {
		return ratio3;
	}

	public void setRatio3(double ratio3) {
		this.ratio3 = ratio3;
	}

	public double getRatio4() {
		return ratio4;
	}

	public void setRatio4(double ratio4) {
		this.ratio4 = ratio4;
	}

	public String changeratio2(){
		ratio[0]=ratio1;
		ratio[1]=ratio2;
		ratio[2]=ratio3;
		ratio[3]=ratio4;
		return SUCCESS;
	}
	
	public String typestatistics(){
		ApplicationContext appliationContext=new ClassPathXmlApplicationContext("applicationContext.xml");
		FilmService fs=(FilmService) appliationContext.getBean("filmservice");
		List<Object[]> list=fs.getTypeSta();
		String[] s=new String[list.size()];
		int[] m=new int[list.size()];
		typeName="";
		for (int i = 0; i < m.length; i++) {
			s[i]=list.get(i)[0].toString();
			m[i]=((BigDecimal)(list.get(i)[1])).intValue();
			typeName+="['"+s[i]+"',"+m[i]+"],";
		}
		
		return SUCCESS;
	}
	String fileName;
	 public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public InputStream getDownloadFile() throws Exception  
	    {  
		try {

			String root = ServletActionContext.getRequest().getRealPath(
					"/upload");
			File ff=new File(root);
			ff.mkdirs();
			File f=new File(root,"b.txt");
			f.createNewFile();
			FileOutputStream o=new FileOutputStream(f);
			ApplicationContext appliationContext=new ClassPathXmlApplicationContext("applicationContext.xml");
			OpinionsService fs=(OpinionsService) appliationContext.getBean("opinionsService");
			List<Order1> list=fs.getOrders();
			String s="\t时间\t\t\t\t电影名\t单价\t数量\t总价\n";
			o.write(s.getBytes());
			for (Order1 order1 : list) {
				s=order1.getStarttime()+"\t"+order1.getFilmname()+"\t"+order1.getPrice()+"\t"+order1.getNum()+"\t"+(order1.getPrice()*order1.getNum())+"\n";
				o.write(s.getBytes());
			}
			o.flush();o.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	         
	            this.fileName = "output.txt" ;  
	            //解解乱码  
	            this.fileName = new String(this.fileName.getBytes("GBK"),"ISO-8859-1");
	            InputStream i=ServletActionContext.getServletContext().getResourceAsStream("/upload/b.txt");
	            return  i;  

	    }  

	String opinion;
	public String getOpinion() {
		return opinion;
	}

	public void setOpinion(String opinion) {
		this.opinion = opinion;
	}

	public String postopinion(){
		ApplicationContext appliationContext=new ClassPathXmlApplicationContext("applicationContext.xml");
		OpinionsService fs=(OpinionsService) appliationContext.getBean("opinionsService");
		fs.saveOp(opinion, "boss");
		return SUCCESS;
	}
	public int[] getLikeSum() {
		return likeSum;
	}

	public void setLikeSum(int[] likeSum) {
		this.likeSum = likeSum;
	}

	public int[] getPurchaseWaySum() {
		return purchaseWaySum;
	}

	public void setPurchaseWaySum(int[] purchaseWaySum) {
		this.purchaseWaySum = purchaseWaySum;
	}

	public List<Film> getFilmList() {
		return filmList;
	}

	

	public String getTypeSum() {
		return typeSum;
	}

	public void setTypeSum(String typeSum) {
		this.typeSum = typeSum;
	}

	public String getTypeName() {
		return typeName;
	}

	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}

	public double[] getRatio() {
		return ratio;
	}

	public void setRatio(double[] ratio) {
		this.ratio = ratio;
	}
	private String[] addQuotation(String[] string){
		for (int i = 0; i < string.length; i++) {
			string[i]="\""+string[i]+"\"";
		}
		return string;
	}
	
	public void setFilmList(List<Film> filmList) {
		this.filmList = filmList;
	}

	public double[][] getFilmSum() {
		return filmSum;
	}

	public void setFilmSum(double[][] filmSum) {
		this.filmSum = filmSum;
	}

	public List<Room> getRoomList() {
		return roomList;
	}

	public void setRoomList(List<Room> roomList) {
		this.roomList = roomList;
	}

	
	public double[][] getRoomSum() {
		return roomSum;
	}

	public void setRoomSum(double[][] roomSum) {
		this.roomSum = roomSum;
	}

	public int[] getMonthSum() {
		return monthSum;
	}

	public void setMonthSum(int[] monthSum) {
		this.monthSum = monthSum;
	}

	public ArrayList<String> getMonthList() {
		return monthList;
	}

	public void setMonthList(ArrayList<String> monthList) {
		this.monthList = monthList;
	}

	public ArrayList<String> getDayList() {
		return dayList;
	}

	public void setDayList(ArrayList<String> dayList) {
		this.dayList = dayList;
	}

	public int[] getDaySum() {
		return daySum;
	}

	public void setDaySum(int[] daySum) {
		this.daySum = daySum;
	}

	public int[] getActivateSum() {
		return activateSum;
	}

	public void setActivateSum(int[] activateSum) {
		this.activateSum = activateSum;
	}

	public int[] getEventSum() {
		return eventSum;
	}

	public void setEventSum(int[] eventSum) {
		this.eventSum = eventSum;
	}

	public int[] getCitySum() {
		return citySum;
	}

	public void setCitySum(int[] citySum) {
		this.citySum = citySum;
	}

	public List<User> getUserList() {
		return userList;
	}

	public void setUserList(List<User> userList) {
		this.userList = userList;
	}

	public int[] getAgeSum() {
		return ageSum;
	}

	public void setAgeSum(int[] ageSum) {
		this.ageSum = ageSum;
	}

	public int[] getGenderSum() {
		return genderSum;
	}

	public void setGenderSum(int[] genderSum) {
		this.genderSum = genderSum;
	}

	public List<Order1> getOrderList() {
		return orderList;
	}

	public void setOrderList(List<Order1> orderList) {
		this.orderList = orderList;
	}

	public int[] getCostSum() {
		return costSum;
	}

	public void setCostSum(int[] costSum) {
		this.costSum = costSum;
	}
	
	public String datadownload(){
		
		
		
		return SUCCESS;
	}

}
