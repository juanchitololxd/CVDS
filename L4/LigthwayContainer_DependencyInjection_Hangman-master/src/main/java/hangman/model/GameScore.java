package hangman.model;

public interface GameScore {
	/**
	 * Calcula el score del juego
	 * @param correctCount numero de opciones correctas	
	 * @param incorrectCount numero de opciones incorrectas 
	 * @throws GameException cuando el puntaje no es valido 
	 */
	int calculateScore(int correctCount, int incorrectCount) throws GameException;
}
