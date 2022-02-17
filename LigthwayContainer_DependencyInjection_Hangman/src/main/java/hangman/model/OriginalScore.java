package hangman.model;

public class OriginalScore implements GameScore{

    /*
    Es un tipo de puntaje que puede usar el juego
     */
    private final score = 100;

    public int calculateScore(int correctCount, int incorrectCount) {
        /**
         * @pre inicia con 100 puntos
         * @pos puntaje minimo 0
         * @param correctCount, int representa los intentos correctos del jugador
         * @param incorrectCount, int representa los intentos incorrectos del jugador
         * @return int, representa el marcador del partido
         * @throws ScoreException, si algun conteo es negativo
         */
        int score = getInitialScore();
        score = score - (incorrectCount * 10);
        if (score < 0){
            score = 0;
        }
        return score;
    }

    public int getInitialScore() {
        return score;
    }
}
