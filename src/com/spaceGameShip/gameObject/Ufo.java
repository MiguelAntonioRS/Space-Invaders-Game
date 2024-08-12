package com.spaceGameShip.gameObject;

import com.spaceGameShip.Graphics.Assets;
import com.spaceGameShip.Graphics.Sound;
import com.spaceGameShip.State.GameStates;
import com.spaceGameShip.math.Vector2D;

import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class Ufo extends MovingObject{

    private ArrayList<Vector2D> path;
    private Vector2D currentNode;
    private int index;
    private boolean following;
    private Chronometer fireRate;
    private Sound shoot;
    public Ufo(Vector2D position, Vector2D velocity, double maxVel, BufferedImage texture, ArrayList<Vector2D> path, GameStates gameStates) {

        super(position, velocity, maxVel, texture, gameStates);
        this.path = path;
        index = 0;
        following = true;
        fireRate = new Chronometer();
        fireRate.run(Constants.UFOFIRERATE);
        shoot = new Sound(Assets.ufoShoot);
    }

    private Vector2D pathFollowing() {

        currentNode = path.get(index);
        double distanceToNode = currentNode.rest(getCenter()).getMagntidude();

        if (distanceToNode < Constants.NODERADIUS) {
            index++;
            if (index >= path.size()) {
                following = false;
            }
        }
        return seekForce(currentNode);
    }

    private Vector2D seekForce(Vector2D target) {

        Vector2D desiredVelocity = target.rest(getCenter());
        desiredVelocity = desiredVelocity.normal().scale(maxVel);

        return desiredVelocity.rest(velocity);
    }

    @Override
    public void update() {

        Vector2D pathFollowing;

        if (following)
            pathFollowing = pathFollowing();
         else
            pathFollowing = new Vector2D();
            pathFollowing = pathFollowing.scale(1/Constants.UFOMASS);

            velocity = velocity.add(pathFollowing);
            velocity = velocity.limit(maxVel);

            position = position.add(velocity);

            if (position.getX() > Constants.WIDTH || position.getY() > Constants.HEIGHT ||
            position.getX() < -width || position.getY() < -height)
            destroy();

            if (!fireRate.isRunning()) {

                Vector2D toPlayer = gameStates.getPlayer().getCenter().rest(getCenter());
                toPlayer = toPlayer.normal();

                double currentAngle = toPlayer.getAngle();
                currentAngle += Math.random()*Constants.UFOANGLERANGE - Constants.UFOANGLERANGE / 2;

                if (toPlayer.getX() < 0)
                    currentAngle = -currentAngle + Math.PI;

                toPlayer = toPlayer.setDirection(currentAngle);

                Laser laser = new Laser(getCenter().add(toPlayer.scale(width)),
                        toPlayer,
                        Constants.LASERVEL,
                        currentAngle + Math.PI/2,
                        Assets.redLaser,
                        gameStates);

                gameStates.getMovingObjects().add(0, laser);
                fireRate.run(Constants.UFOFIRERATE);
                shoot.startMusic();
            }

            if (shoot.getFramePosition() > 8500) {
                shoot.stopMusic();
            }

            angle += 0.05;
            collidesWith();
            fireRate.update();
    }

    @Override
    public void destroy() {
        gameStates.addScore(Constants.UFOSCORE, position);
        super.destroy();
    }

    @Override
    public void draw(Graphics g) {

        Graphics2D g2d = (Graphics2D)g;

        at = AffineTransform.getTranslateInstance(position.getX(), position.getY());
        at.rotate(angle, width/2, height/2);

        g2d.drawImage(texture, at, null);
    }
}
