package com.revature.daos;

import java.util.List;

import org.hibernate.Session;

import com.revature.models.Employee;
import com.revature.models.Game;
import com.revature.utils.HibernateUtil;

public class GameDAO {

	public boolean newGame(Game game) {
		//Take the game passed from the service layer and store it in the games table
		//Return a boolean to confirm it was successfully stored
		boolean isSuccessful;
		Session ses = HibernateUtil.getSession();
		if (ses!=null) {
			ses.save(game);
			isSuccessful=true;
		}
		else
			isSuccessful=false;
		
		return isSuccessful;
	}
	
	public Game getGame(String id) {
		//Pass in a game ID and return the game object
		Session ses = HibernateUtil.getSession();
		List<Game> gameList = ses.createQuery("FROM gamesession").list();
		
		for (int i=0; i<gameList.size(); i++) {
			Game temp = gameList.get(i);
			if (temp.getId().equals(id))
				return temp;
		}
		System.out.println("Error");
		return null;
	}
	
	public boolean deleteGame(String id) {
		//Delete a game with the specified ID, then return a boolean telling you if it was successful
		Session ses = HibernateUtil.getSession();
		if (ses!=null) {
			Game game = (Game)ses.load(Game.class,id);
			ses.delete(game);
			ses.flush();
			return true;
		}
		else {
			System.out.println("Error");
			return false;
		}
		
	}
	
}
