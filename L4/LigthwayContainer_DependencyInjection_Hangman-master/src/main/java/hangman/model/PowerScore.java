package hangman.model;

import java.util.HashMap;

public class PowerScore implements GameScore{
	
	@Override
	/**
	 * Las letras se bonifican con 5^i, donde i es la posición de la letra.
	 * Resta 8 puntos por cada letra incorrecta.
	 * @pre El juego empieza en 0 puntos
	 */
	public int calculateScore(HashMap<Integer, Integer> entries) throws GameException{
		int points = 0;
		for (Integer position : entries.keySet()) {
			if(entries.get(position) == 1) points += Math.pow(5, position);
			else if(entries.get(position) == 2) points -= 8;
			
		}
		
		if(points < 0) throw new GameException(GameException.INVALIDLESSSCORE);
		
		return points;
	}
}
