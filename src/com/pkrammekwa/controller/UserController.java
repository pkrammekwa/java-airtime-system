package com.pkrammekwa.controller;

import java.util.HashMap;
import java.util.Map;

import com.pkrammekwa.model.User;

public class UserController {
	private Map<String, User> users = new HashMap<>();
	
	public UserController() {}
	
	//get user
	public User getUser(String name) {
			
		User user = users.get(name);
		
		if(user != null) {
			return user;
		}
		
		return null;
		
	}
	
	//get all users
	public Map<String, User> getUsers (){
		
		return users;
	}
	
	//add user
	public String addUser(User user) {
		if(!user.getName().isBlank()) {
			users.put(user.getName(), user);
			return "Success: User added!";
		}
		return "Error: User not added.";
	}
	
	//update user
	public void updateUser(String name, String newName, double money) {
		User user = users.get(name);

		if(user != null) {
			user.setName(newName);
			user.setMoney(money);
		}
	}
	
	//removeUser
	public String removeUser(String name) {
		User user = users.get(name);

		if(user != null) {
			users.remove(name);
			return "Success: User removed!";
		}
		return "Error: User does not exist";
	}
}
