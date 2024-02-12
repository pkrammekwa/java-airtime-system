package com.pkrammekwa.model;

import java.util.HashMap;
import java.util.Map;

public class NetworkServiceProvider {
	private String name;
	private String headquaters;
	private Map<String, Airtime> airtimes = new HashMap<>();
	
	public static NetworkServiceProvider nsp_instance = null;
	
	private NetworkServiceProvider() {}
	
	public static synchronized NetworkServiceProvider getInstance() {
		if(nsp_instance == null) {
			nsp_instance = new NetworkServiceProvider();
		}
		return nsp_instance;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getHeadquaters() {
		return headquaters;
	}

	public void setHeadquaters(String headquaters) {
		this.headquaters = headquaters;
	}

	public Map<String, Airtime> getAirtimes() {
		return airtimes;
	}
	
	public Airtime getAirtime(String id) {
		return airtimes.get(id);
	}

	public void addAirtimes(String id, Airtime airtime) {
		airtimes.put(id, airtime);
	}
	

}
