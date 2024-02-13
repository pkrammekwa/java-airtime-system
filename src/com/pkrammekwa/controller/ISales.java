package com.pkrammekwa.controller;

import com.pkrammekwa.model.User;

public interface ISales {

	/**
	 * These are airtime bundles sold by NSP
	 * @param user
	 * @param selectedItem
	 * @return
	 */
	public String Buy(User user, String selectedItem);
	
	/**
	 * Sets current available bundles that are on sale
	 */
	public void AvailableSales();
	
	/**
	 * Adds sale to "database"
	 * Due to have different models airtime and data, I used object as parameter
	 * @param object
	 * @return
	 */
	public String AddSale(Object object);
}
