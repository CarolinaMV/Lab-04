package hangman.model;

/**
 * @pre el juego inicia con 0 puntos
 * @pos La $i-ésima$ letra correcta se bonifica con $5^i$ y  Se penaliza con 8 puntos cada letra incorrecta.
 * @paramcorrectCount, int representa los intentos correctos del jugador
 * @paramincorrectCount, int representa los intentos incorrectos del jugador
 * @return int, representa el marcador del partido
 * @throwsScoreException, si algun conteo es negativo
 */

public class PowerScore implements GameScore{
    private int puntajeInicial = 0;
    @Override
    public int calculateScore(int correctCount, int incorrectCount) throws ScoreException {
        int finalScore = 0;
        if(correctCount < 0 || incorrectCount < 0) {
            throw new ScoreException(ScoreException.INCORRECT_PARAMETERS);}
        if(correctCount > 0){
            for(int i = 1; i < correctCount; i++){
                finalScore = (int)(finalScore + Math.pow(5,i));
            }
        }
        if(incorrectCount > 0 ){
            finalScore = finalScore - 8 * incorrectCount;
        }
        if (finalScore >= 500){
            finalScore = 500;}
        if (finalScore < 0){
            finalScore = 0;}

        return finalScore;
    }

    public int getInitialScore() {

        return puntajeInicial;
    }
}
