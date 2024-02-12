package com.pkrammekwa.controller;

import java.util.Map;

import com.pkrammekwa.model.Airtime;
import com.pkrammekwa.model.NetworkServiceProvider;

public class NetworkServiceProviderController {
	NetworkServiceProvider nsp = NetworkServiceProvider.getInstance();

	
	public int getAirtimeSold() {
		return nsp.getAirtimes().size();
	}
	
	public double getAirtimeRevenue() {
		double total = 0.0;
		
		for(Map.Entry<String, Airtime> arr : nsp.getAirtimes().entrySet()) {
			total += arr.getValue().getAmount();
		}
		
		return total;
	}

}
