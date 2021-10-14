package com.revature.daos;

import org.hibernate.Session;

import com.revature.models.Game;
import com.revature.utils.HibernateUtil;

public class GameDAO {

	public boolean newGame(Game game) {
		//Take the game passed from the service layer and store it in the games table
		//Create and delete methods return a boolean to signify that it was stored successfully
		Session ses = HibernateUtil.getSession();
		ses.save(game);
		
		return isSuccessful;
	}
	
	public Game getGame(int id) {
		//Pass in a game ID and return the game object
	}
	
	public boolean deleteGame(int id) {
		//Delete a game with the specified ID, then return a boolean telling you if it was successful
	}
	
}
