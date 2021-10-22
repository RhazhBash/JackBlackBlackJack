package com.revature.controllers;

import java.sql.Timestamp;

import java.util.Date;

import com.google.gson.Gson;
import com.revature.models.FriendsDTO;
import com.revature.models.LoginDTO;
import com.revature.models.User;
import com.revature.services.LoginService;
import com.revature.utils.JWTUtil;

import io.javalin.http.Handler;

public class LoginController {
	
	LoginService ls = new LoginService();
	Gson gson = new Gson();

	public Handler loginHandler = (ctx) -> {
		
		//String body = ctx.body(); //turn the body (data) of the POST request into a Java String
		
		LoginDTO LDTO = gson.fromJson(ctx.body(), LoginDTO.class); //turn that JSON String into a LoginDTO object
		
		//control flow to determine what happens in the event of a successful/unsuccessful login
		
		//invoke the login() method of LoginService using the username and password in the newly created LoginDTO
		
		if(ls.login(LDTO.getUsername(), LDTO.getPassword())) { //if login is successful...
			
			//generate a JSON Web Token to uniquely identify the user
			String jwt = JWTUtil.generate(LDTO.getUsername(), LDTO.getPassword());
			
			//create a user session
			ctx.req.getSession(); //req is a "Request Object", we establish sessions through it
			
			ctx.status(200);
			ctx.result(jwt);
			
			
		} else { //login fails...
			ctx.status(401); //"unauthorized" status code
			ctx.result("Login Failed! :(");
		}
		
		
	};
	
	//Example registration request body
	//{"name":"Jacob Lawson", "username":"RhazhBash", "password":"password", "address":"Test address", "city":"Atlanta", "state":"Georgia", "zipcode":"30144", "cardnumber":"4624 7563 4578 7654", "expirationdate":"August 1999", "securitycode":"538", "DOB":"June, 5 1996"}
	//Yes I know that request is long and disgusting
	//That's what it should look like after the json.stringify, not before
	public Handler registrationHandler = (ctx) -> {
		
		User user = gson.fromJson(ctx.body(), User.class);
		
		user.setChipCount(10000);
		
		Date newDate = new Date();
		
		long date=newDate.getTime();
		Timestamp tstmp=new Timestamp(date);
		
		user.setRegistered(tstmp);
		
		boolean usernameAvailable=ls.register(user);
		
		
		if (usernameAvailable) {
			ctx.result("Successfully registered");
			ctx.status(200);
		}
		else
			ctx.result("Name already in use");
		
	};
	
	//Request should have the jwt for the logged in user and an input from a text field representing the person they want to add
	public Handler friendsHandler = (ctx) -> {
		
		FriendsDTO FDTO = gson.fromJson(ctx.body(), FriendsDTO.class);
		
		String username = JWTUtil.decode(FDTO.getJwt());
		
		if (ls.addFriend(username, FDTO.getAdding())) {
			ctx.result(FDTO.getAdding()+"successfully added");
			ctx.status(200);
		}
		else
			ctx.result("User not found");
		
	};

	/*
	public Handler getTitleHandler = (ctx) -> {
		Gson gson = new Gson();
		LoginDTO LDTO = gson.fromJson(ctx.body(), LoginDTO.class); 
		ctx.result(gson.toJson(ls.getTitle(LDTO.getUsername(), LDTO.getPassword())));
	};
	*/
}
