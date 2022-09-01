package hangman.model;

public class GameException extends Exception{
	public static String INVALIDLESSSCORE = "No es posible obtener menos de cero puntos.";
	public static String INVALIDHIGHSCORE = "No es posible obtener mas puntos.";
    public GameException(String errorMessage) {
        super(errorMessage);
    }
}
