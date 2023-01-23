package at.cornersoft.katas.bowlinggame;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BowlingGameTest {
    @Test
    public void givenEmptyScoreCard_thenReturn0() {
        ScoreCalculator calculator = new ScoreCalculator();
        int score = calculator.calculate("--------------------");
        assertEquals(score, 0);
    }

    @Test
    public void givenScoreCardOnlyOnes_thenReturn10() {
        ScoreCalculator calculator = new ScoreCalculator();
        int score = calculator.calculate("11111111111111111111");
        assertEquals(score, 20);
    }

    @Test
    public void givenNoSparesNoStrikes_thenReturnPinSum() {
        ScoreCalculator calculator = new ScoreCalculator();
        int score = calculator.calculate("12345123451234512345");
        assertEquals(score, 60);
    }

    @Test
    public void givenSpare_whenNotAtEnd_thenReturnValidSpareResult() {
        ScoreCalculator calculator = new ScoreCalculator();
        int score = calculator.calculate("/9111111111111111111");
        assertEquals(score, 46);
    }

    @Test
    public void givenSpare_whenAtEnd_thenReturnValidResult() {
        ScoreCalculator calculator = new ScoreCalculator();
        int score = calculator.calculate("1111111111111111111/");
        assertEquals(score, 29);
    }

    @Test
    public void givenStrike_whenNotAtEnd_thenReturnValidResult() {
        ScoreCalculator calculator = new ScoreCalculator();
        int score = calculator.calculate("X981111111111111111");
        assertEquals(60, score);
    }

    @Test
    public void givenStrike_whenAtEnd_thenReturnValidResult() {
        ScoreCalculator calculator = new ScoreCalculator();
        int score = calculator.calculate("1111111111111111111X");
        assertEquals(score, 29);
    }

    @Test
    public void givenStrike_whenAtOneBeforeEnd_thenReturnValidResult() {
        ScoreCalculator calculator = new ScoreCalculator();
        int score = calculator.calculate("111111111111111111X11");
        assertEquals(30, score);
    }

    @Test
    public void givenAllStrikes_thenReturnMaxResult() {
        ScoreCalculator calculator = new ScoreCalculator();
        int score = calculator.calculate("XXXXXXXXXXXX");
        assertEquals(300, score);
    }

}
