package com.pkrammekwa.commons;

public class Commons {

	/**
	 * Checks if input is a number
	 * @param number
	 * @return input
	 */
	public boolean isNaN(String num) {
		try {
			 Integer.valueOf(num);
			 return true;
		}catch(Exception e) {
			System.out.println("Error: Input not a number!");
			return false;
		}
	}
}
