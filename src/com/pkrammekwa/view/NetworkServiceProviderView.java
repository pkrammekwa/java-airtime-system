package com.pkrammekwa.view;

import java.util.Scanner;

import com.pkrammekwa.controller.AirtimeController;
import com.pkrammekwa.controller.NetworkServiceProviderController;
import com.pkrammekwa.model.NetworkServiceProvider;
import com.pkrammekwa.model.User;

public class NetworkServiceProviderView {
	NetworkServiceProviderController nspc = new NetworkServiceProviderController();
	Scanner sc = new Scanner(System.in);

	
	public void viewMenu(User user, AirtimeController ac) {
		boolean terminate = false;
		AirtimeView av = new AirtimeView();
		
		while(!terminate) {
			System.out.flush();
			System.out.print(
					"========================\n"+
					"network services dashboard\n"+
					"========================\n"+
					"\n1. Airtimes Stats"+
					"\n2. Data Stats"+
					"\n3. Back"+
					"\n\nEnter Option (number): "
			);
			String input = sc.nextLine();
			

			switch(input) {
				case "1":
					System.out.print(
							"========================\n"+
							"Airtime Statistics\n"+
							"========================\n"+
							"\nNumber of Airtimes Sold: "+nspc.getAirtimeSold()+
							"\nAirtime revenue: R "+nspc.getAirtimeRevenue()+
							"\n\n"
					);
					break;
				case "2":
					System.out.println("\nNot yet implemented!");
					break;
				case "3":
					terminate = true;
					continue;
				default:
					System.out.println("You entered invalid number");
			
			}
		}
	}
}
