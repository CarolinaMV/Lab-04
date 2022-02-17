package hangman.model;

/**
 * @pre inicia con 100 puntos
 * @pos puntaje minimo 0
 * @paramcorrectCount, int representa los intentos correctos del jugador
 * @paramincorrectCount, int representa los intentos incorrectos del jugador
 * @return int, representa el marcador del partido
 * @throwsScoreException, si algun conteo es negativo
 */

public class OriginalScore implements GameScore{
    private int puntajeInicial = 100;
    @Override
    public int calculateScore(int correctCount,int incorrectCount) throws ScoreException{
        int puntajeInicial=100;
        if(correctCount < 0 || incorrectCount < 0){
            throw new ScoreException(ScoreException.INCORRECT_PARAMETERS);
        }
        if(incorrectCount>0){
            puntajeInicial = puntajeInicial-incorrectCount*10;
        }
        if(correctCount == 0 ){
            puntajeInicial = 0;
        }
        return puntajeInicial;
    }
    public int getPuntajeInicial(){
        return puntajeInicial;
    }
}
