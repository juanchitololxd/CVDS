package hangman.model;

public class BonusScore implements GameScore {

	@Override
	/**
	 * Suma 10 puntos por cada letra correcta.
	 * Resta 5 puntos por cada letra incorrecta.
	 * @pre El juego empieza en 0 puntos
	 * @throws Si el puntaje es menor a cero
	 */
	public int calculateScore(int correctCount, int incorrectCount)  throws GameException{
		// TODO Auto-generated method stub
		return 0;
	}
}
