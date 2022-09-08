package hangman.model;

import java.util.HashMap;

public interface GameScore {
	/**
	 * Calcula el score del juego
	 * @param entries La llave es la posición de la letra, y el value corresponde a si acertó (1), falló (2) o si
	 * no ha intentado (0).
	 */
	int calculateScore(HashMap<Integer, Integer> entries) throws GameException;
}
