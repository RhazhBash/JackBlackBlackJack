package com.revature.daos;

import java.util.List;
import java.util.Random;

import org.hibernate.Session;

import com.revature.utils.HibernateUtil;

public class QuoteDAO implements QuoteDAOInterface {
	
	@SuppressWarnings("unchecked")
	@Override
	public String getQuote(int type) {
		
		Session ses = HibernateUtil.getSession();
		List<String> quoteList = ses.createQuery("FROM Ticket WHERE type=" + type).list();
		
		Random rand = new Random();
		int randomInt = rand.nextInt(quoteList.size()-1);
		
		String quote = quoteList.get(randomInt);
		HibernateUtil.closeSession();
		
		return quote;
	}
}
