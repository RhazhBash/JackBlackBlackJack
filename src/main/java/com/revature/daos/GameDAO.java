package com.revature.daos;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.revature.models.Game;
import com.revature.utils.HibernateUtil;

public class GameDAO {

	public boolean newGame(Game game) {
		//Take the game passed from the service layer and store it in the games table
		//Return a boolean to confirm it was successfully stored
		boolean isSuccessful;
		Session ses = HibernateUtil.getSession();
		//if (ses!=null) {
		Transaction tran = ses.beginTransaction();

			ses.saveOrUpdate(game);
			isSuccessful=true;
			tran.commit();

			HibernateUtil.closeSession();
		//}
		//else
		//	isSuccessful=false;
		
		return isSuccessful;
	}
	
	
	public Game getGame(String id) {
		//Pass in a game ID and return the game object
		Session ses = HibernateUtil.getSession();
		Transaction tran = ses.beginTransaction();
		//List<Game> gameList = ses.createQuery("FROM com.revature.models.Game").list();
		Game game = ses.get(Game.class, id);
		tran.commit();
		HibernateUtil.closeSession();
		
		return game;
	}
	
	public boolean deleteGame(String id) {
		//Delete a game with the specified ID, then return a boolean telling you if it was successful
		Session ses = HibernateUtil.getSession();
		
		if (ses!=null) {
			Transaction tran = ses.beginTransaction();
			Game game = ses.get(Game.class, id);
			ses.delete(game);
			tran.commit();
			HibernateUtil.closeSession();
			return true;
		}
		else {
			System.out.println("Error");
			return false;
		}
		
	}
	
}
