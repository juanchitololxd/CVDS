package hangman.model;

public class PowerScore implements GameScore{
	
	
	public PowerScore() {
		
	}
	
	@Override
	/**
	 * Las letras se bonifican con 5^i, donde i es la posición de la letra.
	 * Resta 8 puntos por cada letra incorrecta.
	 * @pre El juego empieza en 0 puntos
	 * @throws Si el puntaje es menor a cero
	 */
	public int calculateScore(int correctCount, int incorrectCount)  throws GameException{
		// TODO Auto-generated method stub
		return 0;
	}
}
