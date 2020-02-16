package com.kata.practise;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BowlingGameTest {
    BowlingGame game;

    @Before
    public void shouldInitializeBowlingGame(){
        game = new BowlingGame();
    }

    @Test
    public void shouldStartGameWithScore0OnFirstRoll() {
        rollCurrentFrame(0,0);
        assertEquals(0, game.getScore());
    }

    @Test
    public void scoreShouldBe1When1PinKnockedOnFirstRoll() {
        rollCurrentFrame(1,0);
        assertEquals(1, game.getScore());
    }

    @Test
    public void scoreShouldBe40When2PinsKnockedOn20Rolls(){
        for (int numberOfFrame = 0; numberOfFrame < 10 ; numberOfFrame++) {
            rollCurrentFrame(2, 2);
        }
        assertEquals(40,game.getScore());
    }

    @Test
    public void scoreShouldAddWith1ImmediateRollForSpare(){
        rollCurrentFrame(5,5);
        rollCurrentFrame(3,0);
        assertEquals(16, game.getScore());
    }

    @Test
    public void scoreShouldAddWith2ImmediateRollForStrike(){
        rollCurrentFrame(10,0);
        rollCurrentFrame(4,5);
        assertEquals(28, game.getScore());
    }

    @Test
    public void shouldHaveScoreOf300OnPerfectGame(){
        for (int numberOfFrame = 0; numberOfFrame < 12 ; numberOfFrame++) {
            rollCurrentFrame(10, 0);
        }
        assertEquals(300, game.getScore());
    }

    @Test
    public void shouldHaveScoreOf150IfAllRollsAreSpare() {
        for (int numberOfFrame = 0; numberOfFrame < 11 ; numberOfFrame++) {
            rollCurrentFrame(5, 5);
        }
        assertEquals(150, game.getScore());
    }

    private void rollCurrentFrame(int firstRoll, int secondRoll){
        Frame currentFrame = new Frame();
        currentFrame.setFirstRoll(firstRoll);
        currentFrame.setSecondRoll(secondRoll);
        game.roll(currentFrame);
    }
}
