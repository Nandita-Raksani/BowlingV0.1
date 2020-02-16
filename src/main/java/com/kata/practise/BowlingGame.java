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
            if(frame.getFirstRoll() == 10){
                score += 10 + frame.getNextFrame().getFirstRoll() + frame.getNextFrame().getSecondRoll();
            } else if(isSpare(frame)){
                score += calculateScoreForSpare(frame);
            } else {
                score += frame.getFirstRoll() + frame.getSecondRoll();
            }
        }
        return score;
    }

    private int calculateScoreForSpare(Frame frame) {
        return 10 + frame.getNextFrame().getFirstRoll();
    }

    private boolean isSpare(Frame frame) {
        return frame.getFirstRoll() + frame.getSecondRoll() == 10;
    }
}
