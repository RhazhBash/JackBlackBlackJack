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
		return state;
		//If user is banned 
	}
}
