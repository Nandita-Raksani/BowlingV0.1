package com.kata.practise;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BowlingGameTest {
    @Test
    public void shouldStartGameWithScore0OnFirstRoll() {
        BowlingGame game = new BowlingGame();
        game.roll(0);
        assertEquals(0, game.getScore());
    }

    @Test
    public void scoreShouldBe1When1PinKnockedOnFirstRoll() {
        BowlingGame game = new BowlingGame();
        game.roll(1);
        assertEquals(1, game.getScore());
    }
}
