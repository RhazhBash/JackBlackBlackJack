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
		
		Game game=GS.startGame(GDTO);
		
		String JSONGame = gson.toJson(game);
		
		ctx.status(200);
		ctx.result(JSONGame);
	};
	
	public Handler doubleDownHandler = (ctx) -> {
		
		GameDTO GDTO = gson.fromJson(ctx.body(), GameDTO.class);
		
		Game game = GS.doubleDown(GDTO);
		
		String JSONGame = gson.toJson(game);
		
		ctx.status(200);
		ctx.result(JSONGame);
	};
	
	public Handler standHandler = (ctx) -> {
		
		GameDTO GDTO = gson.fromJson(ctx.body(), GameDTO.class);
		
		Game game = GS.stand(GDTO);
		
		String JSONGame = gson.toJson(game);
		
		ctx.status(200);
		ctx.result(JSONGame);
		
	};
	
	public Handler playerHitHandler = (ctx) -> {
		
		GameDTO GDTO = gson.fromJson(ctx.body(), GameDTO.class);
		
		Game game = GS.hit(GDTO);
		
		String JSONGame = gson.toJson(game);
		
		ctx.status(200);
		ctx.result(JSONGame);
		
	};
	
	public Handler dealerHitHandler = (ctx) -> {
		
		GameDTO GDTO = gson.fromJson(ctx.body(), GameDTO.class);
		
		Game game = GS.dealerHit(GDTO);
		
		String JSONGame = gson.toJson(game);
		
		ctx.status(200);
		ctx.result(JSONGame);
	};
}