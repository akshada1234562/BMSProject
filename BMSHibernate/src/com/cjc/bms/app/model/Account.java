package com.cjc.bms.app.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="account")
public class Account {
@Override
	public String toString() {
		return "Account [accNo=" + accNo + ", name=" + name + ", mobNo=" + mobNo + ", adharNo=" + adharNo + ", gender="
				+ gender + ", age=" + age + ", balance=" + balance + "]";
	}

@Id
	private long accNo;
	private String name;
	private long mobNo;
	private long adharNo;
	private String gender;
	private int age;
	private double balance;
	
	public long getAccNo() {
		return accNo;
	}
	
	public void setAccNo(long accNo) {
		this.accNo = accNo;
	}

	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public long getMobNo() {
		return mobNo;
	}
	
	public void setMobNo(long mobNo) {
		this.mobNo = mobNo;
	}
	
	public long getAdharNo() {
		return adharNo;
	}
	
	public void setAdharNo(long adharNo) {
		this.adharNo = adharNo;
	}
	
	public String getGender() {
		return gender;
	}
	
	public void setGender(String gender) {
		this.gender = gender;
	}
	
	public int getAge() {
		return age;
	}
	
	public void setAge(int age) {
		this.age = age;
	}
	
	public double getBalance() {
		return balance;
	}
	
	public void setBalance(double balance) {
		this.balance = balance;
	}
	
	
	
}
	
	
	
