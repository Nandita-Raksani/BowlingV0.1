package com.kata.practise;

import java.util.ArrayList;
import java.util.List;

public class BowlingGame {

    public static final int MAXIMUM_PINS_PER_FRAME = 10;
    private List<Frame> gameBoard = new ArrayList<Frame>();
    private Frame prevFrame;
    private static int currentPositionOfFrame;
    public BowlingGame() {
        currentPositionOfFrame = 0;
    }

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
            ++currentPositionOfFrame;
            if(isNotBonus()) {
                if(isStrike(frame)){
                    score += calculateScoreForStrike(frame);
                } else if(isSpare(frame)){
                    score += calculateScoreForSpare(frame);
                } else {
                    score += frame.getFirstRoll() + frame.getSecondRoll();
                }
            }
        }
        return score;
    }

    private boolean isNotBonus() {
        return currentPositionOfFrame <= 10;
    }

    private int calculateScoreForStrike(Frame frame) {
        int score = MAXIMUM_PINS_PER_FRAME + frame.getNextFrame().getFirstRoll();
        if (isStrike(frame.getNextFrame())) {
            score += frame.getNextFrame().getNextFrame().getFirstRoll();
        } else {
            score += frame.getNextFrame().getSecondRoll();
        }
        return score;
    }

    private boolean isStrike(Frame frame) {
        return frame.getFirstRoll() == MAXIMUM_PINS_PER_FRAME;
    }

    private int calculateScoreForSpare(Frame frame) {
        return MAXIMUM_PINS_PER_FRAME + frame.getNextFrame().getFirstRoll();
    }

    private boolean isSpare(Frame frame) {
        return frame.getFirstRoll() + frame.getSecondRoll() == MAXIMUM_PINS_PER_FRAME;
    }
}
