package com.pkrammekwa.controller;

import java.util.Map;

import com.pkrammekwa.model.Airtime;
import com.pkrammekwa.model.NetworkServiceProvider;

public class NetworkServiceProviderController {
	NetworkServiceProvider nsp = NetworkServiceProvider.getInstance();

	
	public int getAirtimeSold() {
		return nsp.getAirtimes().size() + nsp.getAirtimeSales().size();
	}
	
	public double getAirtimeRevenue() {
		double total = 0.0;
		
		for(Map.Entry<String, Airtime> airtimes : nsp.getAirtimes().entrySet()) {
			total += airtimes.getValue().getCost();
		}
		
		for(Map.Entry<String, Airtime> airtimeSales : nsp.getAirtimeSales().entrySet()) {
			total += airtimeSales.getValue().getCost();
		}
		
		return total;
	}

}
