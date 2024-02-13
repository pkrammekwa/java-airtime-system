package com.pkrammekwa.controller;

import java.util.Map;

import com.pkrammekwa.model.Airtime;
import com.pkrammekwa.model.NetworkServiceProvider;

public class NetworkServiceProviderController {
	NetworkServiceProvider nsp = NetworkServiceProvider.getInstance();

	/**
	 * Sum of number of airtimes sold
	 * @return Sum
	 */
	public int getAirtimeSold() {
		return nsp.getAirtimes().size() + nsp.getAirtimeSales().size();
	}
	
	/**
	 * Money made from airtimes sold
	 * @return sum
	 */
	public double getAirtimeRevenue() {
		double total = 0.0;
		//loop though airtimes and add cost to total
		for(Map.Entry<String, Airtime> airtimes : nsp.getAirtimes().entrySet()) {
			total += airtimes.getValue().getCost();
		}
		
		//loop though airtimes and add cost to total
		for(Map.Entry<String, Airtime> airtimeSales : nsp.getAirtimeSales().entrySet()) {
			total += airtimeSales.getValue().getCost();
		}
		
		return total;
	}

}
