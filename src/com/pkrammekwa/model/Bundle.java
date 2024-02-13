package com.pkrammekwa.model;

public class Bundle {
	private double cost = 0.0;
	private String name = "";
	private double value = 0.0;
	
	public Bundle(double cost, String name, double value) {
		super();
		this.cost = cost;
		this.name = name;
		this.value = value;
	}
	
	public double getCost() {
		return cost;
	}
	public void setCost(double cost) {
		this.cost = cost;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public double getValue() {
		return value;
	}

	public void setValue(double value) {
		this.value = value;
	}
	
	

}
