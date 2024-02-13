package com.pkrammekwa.model;


/**
 * This is not interaction sake, not user controller
 */
public class User {
	private String name = "";
	private double airtime = 0.0;
	private double data = 0.0;
	private double money = 1500.0;
	
	public User(String name, double airtime, double data, double money) {
		super();
		this.name = name;
		this.airtime = airtime;
		this.data = data;
		this.money = money;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getAirtime() {
		return airtime;
	}
	public void setAirtime(double airtime) {
		this.airtime = airtime;
	}
	public double getData() {
		return data;
	}
	public void setData(double data) {
		this.data = data;
	}
	public double getMoney() {
		return money;
	}
	public void setMoney(double money) {
		this.money = money;
	}
	
	
}
