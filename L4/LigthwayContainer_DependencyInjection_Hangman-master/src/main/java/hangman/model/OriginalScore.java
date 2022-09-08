package hangman.model;

import java.util.HashMap;

public class OriginalScore implements GameScore{

	@Override
	/**
	 * Resta 10 puntos por cada letra incorrecta
	 * @pre El juego empieza en 100 puntos
	 * @param entries La llave es la posición de la letra, y el value corresponde a si acertó (1), falló (2) o si
	 * no ha intentado (0).
	 * @throws GameException Si el puntaje es menor a cero

	 */
	public int calculateScore(HashMap<Integer, Integer> entries) throws GameException{
		int points = 100;
		for (Integer position : entries.keySet()) {
			if(entries.get(position) == 2) points -= 10;
			
		}
		
		if(points < 0) throw new GameException(GameException.INVALIDLESSSCORE);
		return points;
	}

}
