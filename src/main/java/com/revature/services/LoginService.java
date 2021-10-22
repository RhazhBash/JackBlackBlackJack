package com.revature.services;

import com.revature.daos.userDAO;
import com.revature.models.User;

public class LoginService {
	
	userDAO udao = new userDAO();
	
	public boolean login(String username, String password) {
		
		boolean state;																		
		User user = udao.getUserByCredentials(username);									//get user
		if(user.getUsername().equals(username)  && user.getPassword().equals(password)) {	//compare credentials
			state = true; //success			
			} else { 
			state = false;//failed
			}
		System.out.println("Succesful Log in!!");
		return state;
		//If user is banned 
	}
	
	public boolean register(User user) {
		if (udao.getUserByCredentials(user.getUsername())==null) {
			udao.addUser(user);
			return true;
		}
		else 
			return false;
	}
	
	public boolean addFriend(String adder, String reciever) {
		
		User user = udao.getUserByCredentials(adder);
		
		if (udao.getUserByCredentials(reciever)!=null) {
			user.getFriends().add(reciever);
			udao.addUser(user);
			return true;
		}
		else
			return false;
	}
}
