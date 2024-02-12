package com.pkrammekwa.model;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Airtime{
	
	private long voucher;
	private String date = "";
	private SimpleDateFormat sdf = new SimpleDateFormat("DD/MM/YYYY h:mm:ss a");
	private double amount;
	private boolean used;
	private String user;
	private String expiryDate;
	Calendar calendar = Calendar.getInstance();
	
	
	public Airtime(long voucher, double amount, String user) {
		calendar.add(calendar.DAY_OF_MONTH, 1);  //add one day 
		this.voucher = voucher;
		this.amount = amount;
		this.user = user;
		date = sdf.format(new Date().getTime());
		used = false;
		expiryDate = sdf.format(calendar.getTime());
	}
	

	public long getVoucher() {
		return voucher;
	}

	public void setVoucher(long voucher) {
		this.voucher = voucher;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}
	
	public boolean isUsed() {
		return used;
	}

	public void setUsed(boolean used) {
		this.used = used;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getExpiryDate() {
		return expiryDate;
	}

	public void setExpiryDate(String expiryDate) {
		this.expiryDate = expiryDate;
	}

	public String toString() {
		return 	
				 "\nVoucher: "+voucher
				+"\nAmount: "+amount
				+"\nUsed: "+used
				+"\nUser: "+user
				+"\nExpiry Date: "+expiryDate
				+"\nDate: "+date;
	}

}
