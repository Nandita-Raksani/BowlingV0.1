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
        game.roll(0);
        assertEquals(0, game.getScore());
    }

    @Test
    public void scoreShouldBe1When1PinKnockedOnFirstRoll() {
        game.roll(1);
        assertEquals(1, game.getScore());
    }
}
