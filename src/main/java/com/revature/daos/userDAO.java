package com.revature.daos;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.revature.models.User;
import com.revature.utils.HibernateUtil;

public class userDAO{
	
	public User getUserByID(int id) { 
		
		Session ses = HibernateUtil.getSession();
		
		User user = ses.get(User.class, id); //gets user by ID

		HibernateUtil.closeSession();
		
		return user;
	}	

	public void addUser(User user) {
		
		Session ses = HibernateUtil.getSession();
		ses.save(user);
		HibernateUtil.closeSession();
		
	}
	

	public void updateChipCount(int id, int chips) {
		Session ses = HibernateUtil.getSession();
		Transaction tran = ses.beginTransaction();
		
		User user = ses.get(User.class, 2); //change PK to username //get user obj from db
		
		ses.evict(user); //detach user
		user.setChipCount(chips); //set detached users chipcount
		
		ses.merge(user); //merge detached user to db
		
		tran.commit();
		HibernateUtil.closeSession();
	}
	
	public void updateUserInfo(User user) {
		Session ses = HibernateUtil.getSession();
		Transaction tran = ses.beginTransaction();
		
		ses.merge(user);
		
		tran.commit();
		HibernateUtil.closeSession();
	}
}
