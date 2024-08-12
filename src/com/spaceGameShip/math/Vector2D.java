package com.spaceGameShip.math;

public class Vector2D {
    private double x;
    private double y;

    public Vector2D(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public Vector2D() {
        x = 0;
        y = 0;
    }

    public Vector2D add(Vector2D v) {

        return new Vector2D(x + v.getX(), y + v.getY());
    }

    public Vector2D rest(Vector2D v) {

        return new Vector2D(x - v.getX(), y - v.getY());
    }

    public Vector2D scale(double value) {
        return new Vector2D(x*value, y*value);
    }

    public Vector2D limit(double value) {
        /*if (x > value) {
            x = value;
        }
        if (x < value) {
            x = -value;
        }
        if (y > value) {
            y = value;
        }
        if (y < value) {
            y = -value;
        }*/

        if (getMagntidude() > value) {
            return this.normal().scale(value);
        }
        return this;
    }

    public Vector2D normal() {

        double magnitude = getMagntidude();

        return new Vector2D(x / magnitude, y / magnitude);
    }

    public double getMagntidude() {

        return Math.sqrt(x*x + y*y);
    }

    public Vector2D setDirection(double angle) {

        double magnitude = getMagntidude();

        return new Vector2D(Math.cos(angle) * magnitude, Math.sin(angle) * magnitude);
    }

    public double getAngle() {
        return Math.asin(y/getMagntidude());
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }
}
