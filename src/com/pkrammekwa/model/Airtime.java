package com.pkrammekwa.model;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Airtime extends Bundle{
	
	private long voucher;
	private String date = "";
	private SimpleDateFormat sdf = new SimpleDateFormat("DD/MM/YYYY h:mm:ss a");
	private boolean used;
	private String user;
	private String expiryDate;
	Calendar calendar = Calendar.getInstance();
	
	/**
	 * Instantiate airtime
	 * @param voucher
	 * @param amount
	 * @param user
	 * @param airtimeName
	 * @param value
	 */
	public Airtime(long voucher, double amount, String user, String airtimeName, double value) {
		super(amount, airtimeName, value);
		calendar.add(calendar.DAY_OF_MONTH, 1);  //add one day 
		this.voucher = voucher;
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
				+"\nAmount: "+super.getCost()
				+"\nUsed: "+used
				+"\nUser: "+user
				+"\nExpiry Date: "+expiryDate
				+"\nDate: "+date;
	}

}
