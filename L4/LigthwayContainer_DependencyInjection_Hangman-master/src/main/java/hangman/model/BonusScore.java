package hangman.model;

import java.util.HashMap;

public class BonusScore implements GameScore {

	
	@Override
	/**
	 * Suma 10 puntos por cada letra correcta.
	 * Resta 5 puntos por cada letra incorrecta.
	 * @pre El juego empieza en 0 puntos
	 */
	public int calculateScore(HashMap<Integer, Integer> entries) throws GameException{
		int points = 0;
		for (Integer position : entries.keySet()) {
			if(entries.get(position) == 1) points += 10;
			else if(entries.get(position) == 2) points -= 5;
		}
		if(points < 0) throw new GameException(GameException.INVALIDLESSSCORE);
		return points;
	}
}
