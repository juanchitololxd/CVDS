package hangman.model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;


public class GameScoreTest {

	@Test
	void shouldGenExceptionPowerScore() {
		try {
			PowerScore powerTest = new PowerScore();
			powerTest.calculateScore(0, 0);
		}catch(Exception e) {
			assertTrue(GameException.INVALIDHIGHSCORE == e.getMessage());		
		}	
	}

	@Test
	void shoulGenExceptionBonusScore() {
		
	}
	
	@Test
	void shoulGenExceptionOriginalScore() {
		
	}
	
	@Test
	void shouldPassCalcBonusScore() {
		
	}
	
	@Test
	void shouldPassCalcOriginalScore() {
		
	}
	
	@Test
	void shouldPassCalcPowerScore() {

	}
}