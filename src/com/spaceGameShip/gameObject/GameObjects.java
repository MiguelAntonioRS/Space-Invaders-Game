package com.spaceGameShip.gameObject;

import com.spaceGameShip.math.Vector2D;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

public abstract class GameObjects {
    protected BufferedImage texture;
    protected Vector2D position;

    public GameObjects(Vector2D position, BufferedImage texture) {
        this.position = position;
        this.texture = texture;
    }

    public abstract void update();
    public abstract void draw(Graphics g);

    public Vector2D getPosition() {
        return position;
    }

    public void setPosition(Vector2D position) {
        this.position = position;
    }
}
