package com.kata.practise;

import java.util.ArrayList;
import java.util.List;

public class BowlingGame {

    private static final int MAXIMUM_PINS_PER_FRAME = 10;
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
                score = calculateScoreForGame(frame, score);
            }
        }
        return score;
    }

    private int calculateScoreForGame(Frame frame, int score) {
        if(isStrike(frame)){
            score += calculateScoreForStrike(frame);
        } else if(isSpare(frame)){
            score += calculateScoreForSpare(frame);
        } else {
            score += calculateScoreForOneFrame(frame);
        }
        return score;
    }

    private boolean isNotBonus() {
        return currentPositionOfFrame <= 10;
    }

    private int calculateScoreForStrike(Frame frame) {
        int score = MAXIMUM_PINS_PER_FRAME + getFirstRollOfNextFrame(frame);
        if (isStrike(frame.getNextFrame())) {
            score += getFirstRollOfNextFrame(frame.getNextFrame());
        } else {
            score += getSecondRollOfNextFrame(frame);
        }
        return score;
    }

    private int getSecondRollOfNextFrame(Frame frame) {
        return frame.getNextFrame().getSecondRoll();
    }

    private int getFirstRollOfNextFrame(Frame frame) {
        return frame.getNextFrame().getFirstRoll();
    }

    private boolean isStrike(Frame frame) {
        return frame.getFirstRoll() == MAXIMUM_PINS_PER_FRAME;
    }

    private int calculateScoreForSpare(Frame frame) {
        return MAXIMUM_PINS_PER_FRAME + getFirstRollOfNextFrame(frame);
    }

    private boolean isSpare(Frame frame) {
        return calculateScoreForOneFrame(frame) == MAXIMUM_PINS_PER_FRAME;
    }

    private int calculateScoreForOneFrame(Frame frame) {
        return frame.getFirstRoll() + frame.getSecondRoll();
    }
}
