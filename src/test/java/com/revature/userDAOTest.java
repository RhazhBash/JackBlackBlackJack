package com.revature;

import org.junit.Before;
import org.junit.Test;

import com.revature.daos.userDAO;
import com.revature.models.User;
import com.revature.services.UserService;

import static org.junit.jupiter.api.Assertions.assertEquals;  
import org.junit.jupiter.api.BeforeEach; 
import org.junit.jupiter.api.DisplayName; 
import org.junit.jupiter.api.RepeatedTest; 

public class userDAOTest {

	UserService us;
	int id = 2;
	
	@Before
	public void setup() {
		us = new UserService();
	}
	
	@Test
	@DisplayName("display chipcount")
	public void testChipCount() {
		assertEquals(69, us.getChipCount(id));
	}
	
	@Test
	@DisplayName("creating user")
	public void testAddUser() {
		User courage = new User();
		courage.setUsername("courage");
		courage.setChipCount(420);
		courage.setPassword("murial");
		
		us.addUser(courage);
	}
}
