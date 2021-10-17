package com.revature;

import org.junit.Before;
import org.junit.Test;

import com.revature.daos.userDAO;

import static org.junit.jupiter.api.Assertions.assertEquals;  
import org.junit.jupiter.api.BeforeEach; 
import org.junit.jupiter.api.DisplayName; 
import org.junit.jupiter.api.RepeatedTest; 

public class userDAOTest {

	userDAO ud;
	int id = 2;
	
	@Before
	public void setup() {
		ud = new userDAO();
	}
	
	@Test
	@DisplayName("display chipcount")
	public void testChipCount() {
		assertEquals(69, ud.chipCount(id));
	}
}
