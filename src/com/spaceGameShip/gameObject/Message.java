package com.spaceGameShip.gameObject;

import com.spaceGameShip.Graphics.Text;
import com.spaceGameShip.State.GameStates;
import com.spaceGameShip.math.Vector2D;

import java.awt.*;

public class Message {

    private GameStates gameStates;
    private float alpha;
    private String text;
    private Vector2D position;
    private Color color;
    private boolean center;
    private boolean fade;
    private Font font;
    private final float deltaAlpha = 0.01f;
    private boolean dead;

    public Message(Vector2D position, boolean fade, String text,
                   Color color, boolean center, Font font, GameStates gameStates) {

        this.gameStates = gameStates;
        this.text = text;
        this.position = position;
        this.color = color;
        this.center = center;
        this.fade = fade;
        this.font = font;

        if (fade)
            alpha = 1;
         else
            alpha = 0;

    }

    public void draw(Graphics2D g2d) {

        g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, alpha));
        Text.drawText(g2d, text, position, center, color, font);

        g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 1));

        position.setY(position.getY() - 1);

        if (fade)
            alpha -= deltaAlpha;
          else
            alpha += deltaAlpha;

        if(fade && alpha < 0) {
            dead = true;
        }

        if(!fade && alpha > 1) {
            fade = true;
            alpha = 1;
        }
    }

    public boolean isDead() {
        return dead;
    }
}
