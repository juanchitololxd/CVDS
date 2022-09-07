package hangman.model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;


public class GameScoreTest {

	@Test
	void shouldGenExceptionPowerScore() {
		try {
			PowerScore powerTest = new PowerScore();
			powerTest.calculateScore(0, 1);
		}catch(Exception e) {
			assertTrue(GameException.INVALIDHIGHSCORE == e.getMessage());		
		}	
	}

	@Test
	void shoulGenExceptionBonusScore() {
		try {
			BonusScore scoreTest = new BonusScore();
			scoreTest.calculateScore(0, 1);
		}catch(Exception e) {
			assertTrue(GameException.INVALIDHIGHSCORE == e.getMessage());		
		}	
		
	}
	
	@Test
	void shoulGenExceptionOriginalScore() {
		try {
			OriginalScore scoreTest = new OriginalScore();
			scoreTest.calculateScore(0, 11);
		}catch(Exception e) {
			assertTrue(GameException.INVALIDHIGHSCORE == e.getMessage());		
		}	
		
	}
	
	@Test
	void shouldPassCalcOriginalScore() {
		try {
			OriginalScore scoreTest = new OriginalScore();
			assertTrue(scoreTest.calculateScore(200, 3) == 70);
			assertTrue(scoreTest.calculateScore(0, 10) == 0);			
		}catch(Exception e) {}

	}
	
	@Test
	void shouldPassCalcBonusScore() {
		try {
			BonusScore scoreTest = new BonusScore();
			assertTrue(scoreTest.calculateScore(2, 1) == 15);
			assertTrue(scoreTest.calculateScore(4, 8) == 0);
		}catch(Exception e) {}
	}
	
	@Test
	void shouldPassCalcPowerScore() {
		try {
			PowerScore scoreTest = new PowerScore();
			//La verdad no sabemos como la funcion puede saber en que
			//posicion estaba la correcta
		}catch(Exception e) {}
	}
}