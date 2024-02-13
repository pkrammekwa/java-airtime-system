package com.pkrammekwa.model;

public class Data extends Bundle{
	private int duration = 0;

	public Data(double cost, String name, double value, int duration) {
		super(cost, name, value);
		this.duration = duration;
	}

	public int getDuration() {
		return duration;
	}

	public void setDuration(int duration) {
		this.duration = duration;
	}
	
	

}
