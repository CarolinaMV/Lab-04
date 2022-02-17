package hangman.model;

public class PowerScore implements GameScore{

    public int calculateScore(int correctCount, int incorrectCount){
        /**
         * @pre el juego inicia con 100 puntos
         * @param correctCount, int representa los intentos correctos del jugador
         * @param incorrectCount, int representa los intentos incorrectos del jugador
         * @return int, representa el marcador del partido
         * @throws ScoreException, si algun conteo es negativo
         */
        int score = getInitialScore();
        for (int i = 0; i < correctCount; i++){
            score = score + (5 ^ i);
        }
        score = score - (incorrectCount * 8);
        if (score < 0){
            score = 0;
        }
        if (score > 500){
            score = 500;
        }
        return score;
    }

    public int getInitialScore() {
        return 0;
    }
}
