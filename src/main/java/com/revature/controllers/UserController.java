package com.revature.controllers;

import com.google.gson.Gson;
import com.revature.models.User;
import com.revature.services.UserService;

import io.javalin.http.Handler;

public class UserController {
	
	UserService us = new UserService();
	public Handler addUserHandler = (ctx) -> {
		
		Gson gson = new Gson();//instantate to convert		
		User JSONRequests = gson.fromJson(ctx.body(), User.class); //http body --> java obj
	
		us.addUser(JSONRequests);//run the new request object through our service and dao	
		ctx.status(200); //return 200 = OK (success)
		
	};
	
}
