package com.spaceGameShip.gameObject;

import com.spaceGameShip.State.GameStates;
import com.spaceGameShip.math.Vector2D;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;

public class Asteroids extends MovingObject{

    private Size size;

    public Asteroids(Vector2D position, Vector2D velocity, double maxVel, BufferedImage texture, GameStates gameStates, Size size) {
        super(position, velocity, maxVel, texture, gameStates);
        this.size = size;
        this.velocity = velocity.scale(maxVel);
    }

    @Override
    public void update() {

        position = position.add(velocity);

        if (position.getX() > Constants.WIDTH) {
            position.setX(-width);
        }
        if (position.getY() > Constants.HEIGHT) {
            position.setY(-height);
        }

        if (position.getX() < -width) {
            position.setX(Constants.WIDTH);
        }
        if (position.getY() < -height) {
            position.setY(Constants.HEIGHT);
        }
        angle += Constants.ANGLEDELTA/2;
    }

    @Override
    public void destroy() {
        gameStates.divideAsteroid(this);
        gameStates.addScore(Constants.ASTEROIDSCORE, position);
        super.destroy();
    }

    @Override
    public void draw(Graphics g) {
        Graphics2D g2d = (Graphics2D)g;

        at = AffineTransform.getTranslateInstance(position.getX(), position.getY());
        at.rotate(angle, width/2, height/2);

        g2d.drawImage(texture, at, null);
    }

    public Size getSize() {
        return size;
    }
}
