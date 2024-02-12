package com.pkrammekwa.view;

import java.util.Scanner;

import com.pkrammekwa.controller.AirtimeController;
import com.pkrammekwa.model.User;

public class AirtimeView {

	
	public void AirtimeMenu(User user, Scanner sc, AirtimeController ac) {
		boolean back = false;
		
		while(!back) {
			System.out.print("\n*************\n"+
					user.getName()+" Account"+
					"\n=============================================\n"+
					"Airtime: R "+user.getAirtime()+", Data: "+user.getData()+", Money: R "+user.getMoney()+
					"\n============================================="+
					"\n1. Buy Airtime"+
					"\n2. Verify Airtime"+
					"\n3. Recharge Airtime"+
					"\n4. Back"+
					"\n\nEnter Option (number): "
			);
			String airtimeInput = sc.nextLine();
			
			switch(airtimeInput){
			case "1":
				System.out.println("=====Buy Airtime=====\nEnter amount (number): ");
				String amountInput = sc.nextLine();
				String voucher = ac.GenerateAirtime(Double.valueOf(amountInput), user);
				System.out.print(voucher+"\n");
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
			case "4":
				back = true;
				break;
			default:
				System.out.println("Incorrect Input!");
			}
		}
	}

}
