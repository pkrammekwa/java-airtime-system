package com.pkrammekwa.controller;
import java.util.HashMap;
import java.util.Map;

import com.pkrammekwa.model.Data;
import com.pkrammekwa.model.User;

public class DataController implements ISales{
	private Map<String, Data> DataSales = new HashMap<>();
	
	@Override
	public void AvailableSales() {
		//Default sales
		Data data = new Data(40, "50GB", 50, 7);
		Data data1 = new Data(120, "150GB", 150, 30);
		
		//add them to "database"
		DataSales.put("50GB", data);
		DataSales.put("150GB", data1);
	}
	
	@Override
	public String Buy(User user, String selectedItem) {
		//cast object to Data model
		Data data = DataSales.get(selectedItem);
		
		//check if data exists in sales
		if(data == null) {
			return "Error: Selected data no longer on sale!";
		}
		
		//check if money is enough, if so, buy.
		if(user.getMoney() >= data.getCost()) {
			//buy
			user.setData(user.getData()+data.getCost());
			//deduct money
			user.setMoney(user.getMoney() - data.getCost());
			
			return "Success: Data bundles bought.";
		}
		
		//return results
		return "Error: You do not have enough money";
	}

	@Override
	public String AddSale(Object object) {
		//cast object to Data model
		Data data = (Data) object;
		
		//check if sale already exists
		if(DataSales.containsKey(data.getName())) {
			return "Error: Bundle already exists";
		}
		
		//add it
		DataSales.put(data.getName(),data);
		
		//return results
		return "Success: Bundle added!";
		
	}
	


}
