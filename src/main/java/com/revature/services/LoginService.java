package com.revature.services;

import com.revature.daos.userDAO;

public class LoginService {
	userDAO udao = new userDAO();
	public boolean login(String username, String password) {
		//This method will be edited when the userDAO is ready
		//Validate method could potentially be in the service layer instead of the dao layer
		//If username/password are valid log in
		//If user is banned 
	}
}
