package com.kata.practise;

public class Frame {
    private int firstRoll;

    private int secondRoll;

    private Frame nextFrame;

    public int getFirstRoll() {
        return firstRoll;
    }

    public void setFirstRoll(int firstRoll) {
        this.firstRoll = firstRoll;
    }

    public int getSecondRoll() {
        return secondRoll;
    }

    public void setSecondRoll(int secondRoll) {
        this.secondRoll = secondRoll;
    }

    public Frame getNextFrame() {
        return nextFrame;
    }

    public void setNextFrame(Frame nextFrame) {
        this.nextFrame = nextFrame;
    }

}
