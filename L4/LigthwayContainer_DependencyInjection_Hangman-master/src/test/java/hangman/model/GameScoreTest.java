package hangman.model;

import static org.junit.jupiter.api.Assertions.*;

import java.util.HashMap;

import org.junit.jupiter.api.Test;


public class GameScoreTest {

	@Test
	void shouldGenExceptionPowerScore() {
		try {
			PowerScore powerTest = new PowerScore();
			HashMap<Integer, Integer> items = new HashMap<Integer, Integer>();
			items.put(0, 2);
			powerTest.calculateScore(items);
		}catch(Exception e) {
			assertTrue(GameException.INVALIDLESSSCORE == e.getMessage());		
		}	
	}

	@Test
	void shoulGenExceptionBonusScore() {
		try {
			BonusScore scoreTest = new BonusScore();
			HashMap<Integer, Integer> items = new HashMap<Integer, Integer>();
			items.put(0, 2);
			scoreTest.calculateScore(items);
		}catch(Exception e) {
			assertTrue(GameException.INVALIDLESSSCORE == e.getMessage());		
		}	
		
	}
	
	@Test
	void shoulGenExceptionOriginalScore() {
		try {
			OriginalScore scoreTest = new OriginalScore();
			HashMap<Integer, Integer> items = new HashMap<Integer, Integer>();
			items.put(0, 2);
			scoreTest.calculateScore(items);
		}catch(Exception e) {
			assertTrue(GameException.INVALIDLESSSCORE == e.getMessage());		
		}	
		
	}
	
	@Test
	void shouldPassCalcOriginalScore() {
		try {
			OriginalScore scoreTest = new OriginalScore();
			HashMap<Integer, Integer> items = new HashMap<Integer, Integer>();
			items.put(0, 1);
			items.put(1, 0);
			items.put(2, 2); items.put(3, 2); items.put(4, 2); items.put(5, 2);
			
			assertTrue(scoreTest.calculateScore(items) == 60);
			items.put(6, 2); items.put(7, 2); items.put(8, 2); items.put(9, 2); items.put(10, 2); items.put(11, 2);
			
			assertTrue(scoreTest.calculateScore(items) == 0);			
		}catch(Exception e) {}

	}
	
	@Test
	void shouldPassCalcBonusScore() {
		try {
			BonusScore scoreTest = new BonusScore();
			HashMap<Integer, Integer> items = new HashMap<Integer, Integer>();
			items.put(0, 1); items.put(2, 1);
			items.put(1, 0); items.put(3, 2);
			
			assertTrue(scoreTest.calculateScore(items) == 15);
			
			items.put(4, 2); items.put(5, 2); items.put(6, 2); 
			assertTrue(scoreTest.calculateScore(items) == 0);
		}catch(Exception e) {}
	}
	
	@Test
	void shouldPassCalcPowerScore() {
		try {
			PowerScore scoreTest = new PowerScore();
			HashMap<Integer, Integer> items = new HashMap<Integer, Integer>();
			items.put(0, 1); items.put(2, 1);
			items.put(1, 0); items.put(3, 2);
			assertTrue(scoreTest.calculateScore(items) == 18);
		}catch(Exception e) {}
	}
}