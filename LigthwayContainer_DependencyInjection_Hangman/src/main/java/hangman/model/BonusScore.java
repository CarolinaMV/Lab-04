package hangman.model;

public class BonusScore implements GameScore{
    private final score = 0;
    public int calculateScore(int correctCount, int incorrectCount) {
        /**
         * @pre el juego inicia con 0 puntos
         * @param correctCount, int representa los intentos correctos del jugador
         * @param incorrectCount, int representa los intentos incorrectos del jugador
         * @return int, representa el marcador del partido
         * @throws ScoreException, si algun conteo es negativo
         */
        int score = getInitialScore();
        score = score + (correctCount * 10);
        score = score - (incorrectCount * 5);
        if (score < 0){
            score = 0;
        }
        return score;
    }

    public int getInitialScore() {
        return score;
    }
}
