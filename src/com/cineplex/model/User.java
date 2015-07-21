package com.cineplex.model;

import java.io.Serializable;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "user")
public class User implements Serializable {
	@Id
	String id;
	String username;
	String password;
	String email;
	String phone;
	String bankid;
	Timestamp activatetime;

	int activate;
	int balance;
	int sum;
	int credit;
	String grade;
	Date birthdate;
	String gender;
	String city;

	public Timestamp getActivatetime() {
		return activatetime;
	}

	public void setActivatetime(Timestamp activatetime) {
		this.activatetime = activatetime;
	}

	public Date getBirthdate() {
		return birthdate;
	}

	public void setBirthdate(Date birthdate) {
		this.birthdate = birthdate;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public int getSum() {
		return sum;
	}

	public void setSum(int sum) {
		this.sum = sum;
	}

	public int getCredit() {
		return credit;
	}

	public void setCredit(int credit) {
		this.credit = credit;
	}

	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}

	public int getBalance() {
		return balance;
	}

	public void setBalance(int balance) {
		this.balance = balance;
	}

	public int getActivate() {
		return activate;
	}

	public void setActivate(int activate) {
		this.activate = activate;
	}

	public String getBankid() {
		return bankid;
	}

	public void setBankid(String bankid) {
		this.bankid = bankid;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getBirthdateStr() {
		if (birthdate != null) {
			DateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");

			return sdf.format(birthdate);
		} else
			return "";

	}

	public String getBirthYear() {
		if (birthdate != null) {
			DateFormat sdf = new SimpleDateFormat("yyyy");
			return sdf.format(birthdate);
		} else
			return null;
	}

	public int getAge() {

		if (birthdate != null) {
			Date date = new Date();
			DateFormat sdf = new SimpleDateFormat("yyyy");
			String thisYearStr = sdf.format(date);
			int thisYear = Integer.valueOf(thisYearStr).intValue();
			int birthYear = Integer.valueOf(getBirthYear()).intValue();
			int age = thisYear - birthYear;
			return age;
		} else
			return -1;
	}

}
