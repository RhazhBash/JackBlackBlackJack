package com.revature;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.revature.models.Game;

class GameTest {

	Game testGame = new Game();
	
	@Test
	void testHitandGetTotals() {
		testGame.hitDealer("KING");
		testGame.hitDealer("7");
		testGame.hitPlayer("ACE");
		testGame.hitPlayer("8");
		assert(testGame.getPlayerTotal() == 19);
		assert(testGame.getDealerTotal() == 17);
	}
	
	@Test
	void testDealerStandsAt17() {
		testGame.hitDealer("KING");
		testGame.hitDealer("7");
		assert(testGame.getDealerTotal() == 17);
		assert(testGame.isDealerIsStanding());
	}
	
	@Test
	void testAcesWork() {
		testGame.hitDealer("KING");
		testGame.hitDealer("ACE");
		assert(testGame.isDealerIsStanding());
		assert(testGame.getDealerTotal() == 21);
		testGame.hitPlayer("ACE");
		testGame.hitPlayer("ACE");
		testGame.hitPlayer("ACE");
		assert(testGame.getPlayerTotal() == 13);
	}
	@Test
	void testDoubleDownFails() {
		testGame.hitPlayer("ACE");
		testGame.hitPlayer("ACE");
		testGame.setPlayerBet(50);
		testGame.setPlayerChips(40);
		assert(!testGame.canDoubleDown());
	}
	@Test
	void testDoubleDownSucceeds() {
		testGame.hitPlayer("ACE");
		testGame.hitPlayer("ACE");
		testGame.setPlayerBet(50);
		testGame.setPlayerChips(50);
		assert(testGame.canDoubleDown());
		testGame.doubleDown("KING");
		assert(testGame.getPlayerBet() == 100);
		assert(testGame.getPlayerTotal() == 12);
	}
	
	@Test
	void testDoubleDownOnce() {
		testGame.hitPlayer("1");
		testGame.hitPlayer("1");
		testGame.setPlayerBet(50);
		testGame.setPlayerChips(50);
		assert(testGame.canDoubleDown());
		testGame.doubleDown("ACE");
		assert(testGame.getPlayerBet() == 100);
		assert(testGame.getPlayerTotal() == 13);
		assert(!testGame.canDoubleDown());
	}
	@Test
	void testDoubleDownOnceAndLose() {
		testGame.hitPlayer("1");
		testGame.hitPlayer("1");
		testGame.setPlayerBet(50);
		testGame.setPlayerChips(50);
		assert(testGame.canDoubleDown());
		testGame.doubleDown("ACE");
		assert(testGame.getPlayerBet() == 100);
		assert(testGame.getPlayerTotal() == 13);
		assert(!testGame.canDoubleDown());
		testGame.hitDealer("ACE");
		testGame.hitDealer("KING");
		assert(!testGame.isPlayerWinner());
	}
	
	@Test
	void testDoubleDownOnceAndWin() {
		testGame.hitPlayer("1");
		testGame.hitPlayer("1");
		testGame.setPlayerBet(50);
		testGame.setPlayerChips(50);
		assert(testGame.canDoubleDown());
		testGame.doubleDown("ACE");
		assert(testGame.getPlayerBet() == 100);
		assert(testGame.getPlayerTotal() == 13);
		assert(!testGame.canDoubleDown());
		testGame.hitDealer("ACE");
		testGame.hitDealer("ACE");
		assert(testGame.isPlayerWinner());
	}
	@Test
	void testPush() {
		testGame.hitPlayer("1");
		testGame.hitPlayer("1");
		testGame.hitDealer("ACE");
		testGame.hitDealer("ACE");
		assert(!testGame.isPlayerIsBust());
		assert(!testGame.isPlayerWinner());
	}
	
	

	
	
	

}
