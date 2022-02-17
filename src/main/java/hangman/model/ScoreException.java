package hangman.model;

public class ScoreException extends Exception {

        public static final String INCORRECT_PARAMETERS = "Valores negativos";
        public ScoreException(String mensaje){
            super(mensaje);
        }
}
