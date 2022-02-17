package hangman.model;


import org.junit.Assert;
import org.junit.Test;

public class GameScoreTest {

    OriginalScore originalScore = new OriginalScore();
    BonusScore bonusScore = new BonusScore();
    PowerScore powerScore = new PowerScore();

    /**
     * OriginalScore
     *      Es el esquema actual, se inicia con 100 puntos.
     *      No se bonifican las letras correctas.
     *      Se penaliza con 10 puntos con cada letra incorrecta.
     *      El puntaje minimo es 0.
     */

    // validar OriginalScore
    @Test
    public void originalScoreTest() throws ScoreException {
        Assert.assertEquals(70, originalScore.calculateScore(5,3));
    }

    // validar que el puntaje inicial es 100
    @Test
    public void validarPuntajeInicialOriginalScore(){

        Assert.assertEquals(100,originalScore.getPuntajeInicial());
    }

    //validar que las letras correctas no bonifican
    @Test
    public void validarLetrasCorrectasOriginalScore() throws ScoreException {
        Assert.assertEquals(100, originalScore.calculateScore(5,0));
    }

    // validar la penalizacion
    @Test
    public void validarPenalizacionOriginalScore() throws ScoreException {
        Assert.assertEquals(80, originalScore.calculateScore(0,2));
    }
    /**
     * BonusScore
     *      El juego inicia en 0 puntos.
     *      Se bonifica con 10 puntos cada letra correcta.
     *      Se penaliza con 5 puntos cada letra incorrecta.
     *      El puntaje mínimo es 0
     */

    // validar bonusScore
    @Test
    public void bonusScoreTest() throws ScoreException {

        Assert.assertEquals(35,bonusScore.calculateScore(5,3));
    }

    // validar puntaje inicial
    @Test
    public void validarPuntajeInicialBonusScore(){

        Assert.assertEquals(0,bonusScore.getInitialScore());
    }

    // validar bonificacion por letra correcta por 10 ptos
    @Test
    public void validarBonifiacionBonusScore() throws ScoreException {

        Assert.assertEquals(10,bonusScore.calculateScore(1,0));
    }

    // validar penalizacion 5 ptos por letra incorrecta


    /**
     * PowerScore
     *      El juego inicia en 0 puntos.
     *      La $i-ésima$ letra correcta se bonifica con $5^i$.
     *      Se penaliza con 8 puntos cada letra incorrecta.
     *      El puntaje mínimo es 0
     *      Si con las reglas anteriores sobrepasa 500 puntos, el puntaje es 500.
     */

    // validar limite de puntaje a 500
    @Test
    public void validarPuntajeMaxPowerScoreTest() throws ScoreException {

        Assert.assertEquals(500,powerScore.calculateScore(4,0));
    }

    //validar puntaje inicial
    @Test
    public void validarPuntajeInicialPowerBonusScore(){

        Assert.assertEquals(0,powerScore.getInitialScore());
    }

    // Validar bonificacion correcta 5^i
    @Test
    public void validarBonificacionPowerBonusScore() throws ScoreException {

        Assert.assertEquals(25,powerScore.calculateScore(2,0));
    }

    // Validar penalizacion de 8 punto
    @Test
    public void validarPenalizacionPowerBonusScore() throws ScoreException {
        Assert.assertEquals(17,powerScore.calculateScore(2,1));
    }
}
