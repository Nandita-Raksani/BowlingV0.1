package com.kata.practise;

public class BowlingGame {

    private int score;

    public void roll(int pinsDown) {
        score += pinsDown;
    }

    public int getScore() {
        return score;
    }
}
