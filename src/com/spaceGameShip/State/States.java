package com.spaceGameShip.State;

import java.awt.*;

public abstract class States {

    private static States currentState = null;
    public static States getCurrentState() {return currentState;}
    public static void changeState(States newState) {
        currentState = newState;
    }
    public abstract void update();
    public abstract void draw(Graphics g);
}
