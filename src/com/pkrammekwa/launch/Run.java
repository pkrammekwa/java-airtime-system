package com.pkrammekwa.launch;

import java.util.Scanner;

import com.pkrammekwa.controller.AirtimeController;
import com.pkrammekwa.model.User;
import com.pkrammekwa.view.AirtimeView;
import com.pkrammekwa.view.NetworkServiceProviderView;

public class Run {

	public static void main(String[] args) {
		boolean option = false;
		User user = new User("pkrammekwa",0.0,0.0,150.0);
		AirtimeController ac = new AirtimeController(user);
		NetworkServiceProviderView nspv = new NetworkServiceProviderView();
		Scanner sc = new Scanner(System.in);
		AirtimeView av = new AirtimeView();
		
		while(!option) {
			System.out.print(
					"=====================\n"+
					"Main Menu"+
					"\n====================="+
					"\n1. Service Provider"+
					"\n2. Shop "+
					"\n3. Exit "+
					"\n\nEnter Option (number): "
			);
			String airtimeInput = sc.nextLine();
			
			switch(airtimeInput){
			case "1":
				nspv.viewMenu(user, ac);
				break;
			case "2":
				av.AirtimeMenu(user, sc, ac);
				break;
			case "3":
				System.out.println("Thank you. Goodbye!");
				option = true;
				break;
			default:
				System.out.println("Incorrect Input!");
			}
		}
	}


}
