package com.kata.practise;

import java.util.ArrayList;
import java.util.List;

public class BowlingGame {

    private List<Frame> gameBoard = new ArrayList<Frame>();

    public void roll(Frame currentFrame) {
        gameBoard.add(currentFrame);
    }

    public int getScore() {
        int score = 0;
        for (Frame frame : gameBoard) {
            score += frame.getFirstRoll() + frame.getSecondRoll();
        }
        return score;
    }
}
