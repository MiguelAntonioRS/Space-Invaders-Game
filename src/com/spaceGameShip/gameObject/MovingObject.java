package com.spaceGameShip.gameObject;

import com.spaceGameShip.Graphics.Assets;
import com.spaceGameShip.Graphics.Sound;
import com.spaceGameShip.State.GameStates;
import com.spaceGameShip.math.Vector2D;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Date;

public abstract class MovingObject extends GameObjects{

    protected Vector2D velocity;
    protected AffineTransform at;
    protected double angle;
    protected double maxVel;
    protected int width;
    protected int height;
    protected GameStates gameStates;
    private Sound explosion;
    private boolean Dead;

    public MovingObject(Vector2D position, Vector2D velocity, double maxVel, BufferedImage texture, GameStates gameStates) {
        super(position, texture);
        this.velocity = velocity;
        this.maxVel = maxVel;
        this.gameStates = gameStates;
        width = texture.getWidth();
        height = texture.getHeight();
        angle = 0;
        explosion = new Sound(Assets.explosion);
        this.Dead = Dead;
    }

    protected void collidesWith() {

        ArrayList<MovingObject> movingObjects = gameStates.getMovingObjects();

        for (int i = 0; i < movingObjects.size(); i++) {
            MovingObject movingObject = movingObjects.get(i);

            if (movingObject.equals(this))
                continue;

                double distance = movingObject.getCenter().rest(getCenter()).getMagntidude();

            if (distance < movingObject.width/2 + width/2 && movingObjects.contains(this)) {
                objectCol(movingObject, this);
            }
        }
    }

    private void objectCol(MovingObject a, MovingObject b) { // Colision

        if (a instanceof Player && ((Player)a).isSpawing()) {
            return;
        }

        if (b instanceof Player && ((Player)b).isSpawing()) {
            return;
        }

        if (!(a instanceof Asteroids && b instanceof Asteroids)) {
            gameStates.explosion(getCenter());
            a.destroy();
            b.destroy();
        }
    }

    protected void destroy() {
        gameStates.getMovingObjects().remove(this);
        if (!(this instanceof Laser))
            explosion.startMusic();
    }

    protected Vector2D getCenter() {

        return new Vector2D(position.getX() + width/2, position.getY() + height/2);
    }

    public boolean isDead() {
        return Dead;
    }
}
