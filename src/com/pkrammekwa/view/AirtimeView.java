package com.pkrammekwa.view;

import java.util.ArrayList;
import java.util.Map;
import java.util.Scanner;

import com.pkrammekwa.commons.Commons;
import com.pkrammekwa.controller.AirtimeController;
import com.pkrammekwa.model.Airtime;
import com.pkrammekwa.model.NetworkServiceProvider;
import com.pkrammekwa.model.User;

public class AirtimeView {
	NetworkServiceProvider nsp = NetworkServiceProvider.getInstance();
	Commons commons = new Commons();
	
	public void AirtimeMenu(User user, Scanner sc, AirtimeController ac) {
		boolean back = false;
		ac.AvailableSales();
		
		while(!back) {
			
			System.out.print("\n*************\n"+
					user.getName()+" Account"+
					"\n=============================================\n"+
					"Airtime: R "+user.getAirtime()+", Data: "+user.getData()+", Money: R "+user.getMoney()+
					"\n============================================="+
					"\n0. Airtime Sales"+
					"\n1. Buy Airtime"+
					"\n2. Verify Airtime"+
					"\n3. Recharge Airtime"+
					"\n99. Back"+
					"\n\nEnter Option (number): "
			);
			String airtimeInput = sc.nextLine();
			
			switch(airtimeInput){
			case "0":
				boolean backSales = false;
				
				// This is where the problem is, because it is convenient for users to have inputs as numbers, hashmap wont do us justice here.
				// Changing to ArrayList is not ideal because of performance and memory issues.
				// Using GUI is more ideal than console.
				ArrayList<Airtime> arr = new ArrayList<Airtime>(nsp.getAirtimeSales().size());
				arr.addAll(nsp.getAirtimeSales().values());
				
				while(!backSales) {
					int i = 0;
					System.out.print(
							"\n*************\n"+
									"Airtime Sales"+
									"\n=============================================\n"+
									"Airtime: R "+user.getAirtime()+", Data: "+user.getData()+", Money: R "+user.getMoney()+
							"\n=============================================\n");
					
					for(Map.Entry<String, Airtime> airtime : nsp.getAirtimeSales().entrySet()) {
						i++;
						System.out.println(i+". (R "+airtime.getValue().getValue()+") "+airtime.getValue().getName()+" for only R "+airtime.getValue().getCost());
					}
					
					System.out.println("\n99. Back\n\nEnter option (number): ");
					
					String salesInput = sc.nextLine();
					
					
					try {
						int input = Integer.valueOf(salesInput);						
						if(input == 99) {
							backSales = true;
							
						}else if( input > i || input < 1 ) {
							System.out.println("Error: Wrong input");
						}else {
							// Using the number (input) we got from user, we have to convert it to integer
							// Subtract 1 from it because Arrays count from 0 and if you check the i above, it starts at 1 since hashmaps do not have indexes
							// If there are more nested options to choose from, using console as UI is not ideal
							System.out.print(ac.Buy(user, String.valueOf(arr.get(Integer.valueOf(salesInput) - 1).getName())));						
						}
					}catch(Exception e) {
						System.out.println("Error: Input must be a number.");
					}
					
					
				}

				break;
			case "1":
				System.out.println("=====Buy Airtime=====\nEnter amount (number): ");
				String amountInput = sc.nextLine();
				if(commons.isNaN(amountInput)) {
					String voucher = ac.GenerateAirtime(Double.valueOf(amountInput), user, Double.valueOf(amountInput));					
					System.out.print(voucher+"\n");
				}
				break;
			case "2":
				System.out.println("=====Verify Airtime=====\nEnter voucher number: ");
				String verifyInput = sc.nextLine();
				String isValid = ac.ValidAirtime(verifyInput);
				System.out.println(isValid);					
				break;
			case "3":
				System.out.println("=====Recharge Airtime=====\nEnter voucher number: ");
				String rechargeInput = sc.nextLine();
				String output = ac.RechargeAirtime(user, rechargeInput);;
				System.out.println(output);					
				break;
			case "99":
				back = true;
				break;
			default:
				System.out.println("Incorrect Input!");
			}
		}
	}

}
