package com.revature.controllers;

import com.google.gson.Gson;
import com.revature.models.Game;
import com.revature.models.GameDTO;
import com.revature.services.GameService;

import io.javalin.http.Handler;

public class GameController {
	
	GameService GS = new GameService();
	Gson gson = new Gson();
	
	public Handler startGameHandler = (ctx) -> {
		
		GameDTO GDTO = gson.fromJson(ctx.body(), GameDTO.class);
		
		System.out.println(GDTO);
		
		Game game=GS.startGame(GDTO);
		
		String JSONGame = gson.toJson(game);
		
		ctx.status(200);
		ctx.result(JSONGame);
	};
	
	public Handler doubleDownHandler = (ctx) -> {
		
	};
	
	public Handler standHandler = (ctx) -> {
		
	};
	
	public Handler playerHitHandler = (ctx) -> {
		
		
		
	};
	
	public Handler dealerHitHandler = (ctx) -> {
		
	};
}
