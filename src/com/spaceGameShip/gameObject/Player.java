package com.spaceGameShip.gameObject;

import com.spaceGameShip.Graphics.Assets;
import com.spaceGameShip.Graphics.Sound;
import com.spaceGameShip.State.GameStates;
import com.spaceGameShip.input.KeyBoard;
import com.spaceGameShip.math.Vector2D;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;

public class Player extends MovingObject{

    private Vector2D heading;
    private Vector2D aceleration;
    private boolean accelerating = false;
    private Chronometer fireRate;
    private boolean spawing;
    private boolean visible;
    private Chronometer spawnTime;
    private Chronometer flickerTime;
    private Sound shoot;
    private Sound lose;

    public Player(Vector2D position, Vector2D velocity, double maxVel, BufferedImage texture, GameStates gameStates) {

        super(position, velocity, maxVel, texture, gameStates);
        heading = new Vector2D(0, 1);
        aceleration = new Vector2D();
        fireRate = new Chronometer();
        spawnTime = new Chronometer();
        flickerTime = new Chronometer();
        shoot = new Sound(Assets.playerShoot);
        lose = new Sound(Assets.playerLose);
    }

    @Override
    public void update() {

        if (!spawnTime.isRunning()) {
            spawing = false;
            visible = true;
        }

        if (spawing) {

            if (!flickerTime.isRunning()) {
                flickerTime.run(Constants.FLICKER_TIME);
                visible = !visible;
            }
        }

        if (KeyBoard.SHOOT && !fireRate.isRunning() && !spawing) {

            gameStates.getMovingObjects().add(0, new Laser(
               getCenter().add(heading.scale(width)), heading,
                    Constants.LASERVEL, angle, Assets.blueLaser, gameStates
            ));
            fireRate.run((long) Constants.FIRERATE);
            shoot.startMusic();
        }

        if (shoot.getFramePosition() > 8500) {
            shoot.stopMusic();
        }

        if (KeyBoard.RIGHT) {

            angle += Constants.ANGLEDELTA;
        }
        if (KeyBoard.LEFT) {

            angle -= Constants.ANGLEDELTA;
        }
        if (KeyBoard.UP) {

            aceleration = heading.scale(Constants.ACC);
            accelerating = true;
        }else {

            if (velocity.getMagntidude() != 0){
                aceleration = velocity.scale(-1).normal().scale(Constants.ACC/2);
                accelerating = false;
            }
        }

        velocity = velocity.add(aceleration);
        velocity = velocity.limit(maxVel);
        heading = heading.setDirection(angle - Math.PI/2);
        position = position.add(velocity);

        if (position.getX() > Constants.WIDTH) {
            position.setX(0);
        }
        if (position.getY() > Constants.HEIGHT) {
            position.setY(0);
        }

        if (position.getX() < -width) {
            position.setX(Constants.WIDTH);
        }
        if (position.getY() < -height) {
            position.setY(Constants.HEIGHT);
        }

        fireRate.update();
        spawnTime.update();
        flickerTime.update();
        collidesWith();
    }

    public void destroy() {
        spawing = true;
        spawnTime.run(Constants.SPAWNING_TIME);
        lose.startMusic();
        if (!gameStates.restLive()) {
            gameStates.gameOver();
            super.destroy();
        }
        reset();
    }

    public void reset() {

        angle = 0;
        velocity = new Vector2D();
        position = GameStates.PLAYER_START_POSITION;
    }

    @Override
    public void draw(Graphics g) {

        if (!visible) {
            return;
        }

        Graphics2D g2d = (Graphics2D)g;

        AffineTransform at1 = AffineTransform.getTranslateInstance(position.getX() + width/2 + 5, position.getY() + height/2 + 10);
        AffineTransform at2 = AffineTransform.getTranslateInstance(position.getX() + 5, position.getY() + height/2 + 10);
        at1.rotate(angle, -5, -10);
        at2.rotate(angle, width/2 -5, -10);

        if (accelerating){

            g2d.drawImage(Assets.speed, at1, null);
            g2d.drawImage(Assets.speed, at2, null);
        }


        at = AffineTransform.getTranslateInstance(position.getX(), position.getY());
        at.rotate(angle, width/2, height/2);

        g2d.drawImage(Assets.player, at, null);
    }

    public boolean isSpawing() {
        return spawing;
    }
}
