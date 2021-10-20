package com.revature;

import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.revature.controllers.LoginController;
import com.revature.models.Card;
import com.revature.models.Deck;

import io.javalin.Javalin;


public class Launcher {

	public static void main(String[] args) {
LoginController lc = new LoginController(); 
		
		Javalin app = Javalin.create(
				config -> {
					config.enableCorsForAllOrigins(); //allows the server to process JS requests from anywhere
				}
				).start(8090);
		app.post("/login", lc.loginHandler);
		
		
		
		
	}

}
