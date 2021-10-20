package com.revature.controllers;

import com.google.gson.Gson;
import com.revature.models.LoginDTO;
import com.revature.services.LoginService;
import com.revature.utils.JWTUtil;

import io.javalin.http.Handler;

public class LoginController {
	
	LoginService ls = new LoginService();

	public Handler loginHandler = (ctx) -> {
		
		//String body = ctx.body(); //turn the body (data) of the POST request into a Java String
		
		Gson gson = new Gson();
		
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

	/*
	public Handler getTitleHandler = (ctx) -> {
		Gson gson = new Gson();
		LoginDTO LDTO = gson.fromJson(ctx.body(), LoginDTO.class); 
		ctx.result(gson.toJson(ls.getTitle(LDTO.getUsername(), LDTO.getPassword())));
	};
	*/
}
