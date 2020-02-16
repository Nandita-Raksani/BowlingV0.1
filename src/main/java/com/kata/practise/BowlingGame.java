package com.kata.practise;

import java.util.ArrayList;
import java.util.List;

public class BowlingGame {

    private List<Frame> gameBoard = new ArrayList<Frame>();
    private Frame prevFrame;

    public void roll(Frame currentFrame) {
        if (prevFrame != null) {
            prevFrame.setNextFrame(currentFrame);
        }
        gameBoard.add(currentFrame);
        prevFrame = currentFrame;
    }

    public int getScore() {
        int score = 0;
        for (Frame frame : gameBoard) {
            if(frame.getFirstRoll() + frame.getSecondRoll() == 10){
                score += 10 + frame.getNextFrame().getFirstRoll();
            } else {
                score += frame.getFirstRoll() + frame.getSecondRoll();
            }
        }
        return score;
    }
}
