package com.pkrammekwa.controller;

import java.security.SecureRandom;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import com.pkrammekwa.model.*;

public class AirtimeController implements ISales{
	User user;
	Airtime airtime = null;
	NetworkServiceProvider nsp = NetworkServiceProvider.getInstance();
	
	public AirtimeController(User user) {
		this.user = user;
	}
	

	/**
	 * Uses secure random to generate sensitive and cryptography security purposes
	 * @param amount
	 * @return voucher
	 */
	public String GenerateAirtime(double amount, User user, double value) {
		
		//check if user has enough money to buy
		if(user.getMoney() > amount) {
			long voucher = 0;
			SecureRandom sr = new SecureRandom();
			//generate random 10 digit number
			voucher = sr.nextLong(1000000000)*9;
			
			//store airtime details
			airtime = new Airtime(voucher, amount, user.getName(), "R "+amount+" airtime", value);
			nsp.addAirtimes(String.valueOf(voucher), airtime);
			
			//deduct money from user
			user.setMoney(user.getMoney() - amount);
			
			//return voucher as string
			return "Success! Voucher: "+String.valueOf(voucher);			
		}
		
		//else return error message
		return "Error: Not enough money!";
		
	}
	
	/**
	 * Checks if airtime is used of expired
	 * [expired] compare the expiry date with todays date
	 * @param nsp
	 * @param id
	 * @return outcome
	 */
	public String ValidAirtime(String id) {
		Airtime airtime = nsp.getAirtime(id);
		
		if(airtime != null) {
			//SimpleDateFormat sdf = new SimpleDateFormat();
			
			//check if airtime is used
			if(airtime.isUsed() == true) {
				return "Error: Voucher is used!";
			}
			
			//Check if airtime expired 
			/*try {
			Date date = sdf.parse(airtime.getExpiryDate());
			if(date.after(sdf.parse(new Date().toString()))) {
				return false;
			}
		} catch (ParseException e) {
			e.printStackTrace();
		}*/
			
			return "Success. Voucher is valid!";			
		}
		
		return "Error: Voucher is invalid!";
	}
	
	/**
	 * Check if voucher is valid then recharge user's account
	 * @param nsp
	 * @param user
	 * @param voucher
	 */
	public String RechargeAirtime(User user, String voucher) {
		//get airtime by id:voucher
		Airtime a = nsp.getAirtime(voucher);
		if(ValidAirtime(voucher) == "Success. Voucher is valid!") {
			//recharge user account
			user.setAirtime(user.getAirtime()+a.getCost());
			//update existing airtime voucher[used: true]
			a.setUsed(true);
			return "Success! New Airtime Balance: R "+user.getAirtime();
		}
		
		return "Error: Airtime voucher not valid!";
	}

	
	
	@Override
	public String Buy(User user, String selectedItem) {
		//get airtime from sales
		Airtime airtime = nsp.getAirtimeSales().get(selectedItem);
		
		//check if airtime exists in sales
		if(airtime == null) {
			return "Error: Selected airtime no longer on sale!";
		}
		
		//check if user has enough money
		if(user.getMoney() >= airtime.getCost()) {
			//buy
			user.setAirtime(user.getAirtime() + airtime.getValue());
			
			//deduct money
			user.setMoney(user.getMoney() - airtime.getCost());
			
			return "Success: Airtime successfully bought!";
		}
		
		//return results
		return "Error: You do not have enough money";
	}

	@Override
	public void AvailableSales() {
		//create default airtime sales, no voucher needed
		Airtime airtime = new Airtime(0, 8.0, user.getName(), "Tiger", 10.0);
		Airtime airtime2 = new Airtime(1, 17.0, user.getName(), "x2 Supreme", 25.0);
		
		//add them
		nsp.getAirtimeSales().put("Tiger", airtime);
		nsp.getAirtimeSales().put("x2 Supreme", airtime2);
	}

	@Override
	public String AddSale(Object object) {
		//cast object to Airtime model
		Airtime data = (Airtime) object;
		
		//check if sale already exists
		if(nsp.getAirtimeSales().containsKey(airtime.getName())) {
			return "Error: Bundle already exists";
		}
		
		//add it
		nsp.getAirtimeSales().put(airtime.getName(),data);
		
		//return results
		return "Success: Bundle added!";
	}
	

}
