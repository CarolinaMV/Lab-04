package hangman.model;
/**
 * @pre el juego inicia con 0 puntos
 * @pos Se bonifica con 10 puntos cada letra correcta y Se penaliza con 5 puntos cada letra incorrecta.
 * @paramcorrectCount, int representa los intentos correctos del jugador
 * @paramincorrectCount, int representa los intentos incorrectos del jugador
 * @return int, representa el marcador del partido
 * @throwsScoreException, si algun conteo es negativo
 */
public class BonusScore implements GameScore{

    private int puntajeInicial = 0;
    @Override
    public int calculateScore(int correctCount, int incorrectCount) throws ScoreException {
        int finalScore = 0;
        if(correctCount < 0 || incorrectCount < 0) {
            throw new ScoreException(ScoreException.INCORRECT_PARAMETERS);}
        if(correctCount > 0){
            finalScore =finalScore + 10 * correctCount;
        }
        if(incorrectCount > 0){
            finalScore =  finalScore - 5 * incorrectCount;
        }
        if(finalScore < 0){
            finalScore = 0;
        }
        return finalScore;
    }

    public int getInitialScore() {

        return puntajeInicial;
    }
}
