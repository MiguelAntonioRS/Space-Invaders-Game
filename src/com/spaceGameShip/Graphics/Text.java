package com.spaceGameShip.Graphics;

import com.spaceGameShip.math.Vector2D;

import java.awt.*;

public class Text {

    public static void drawText(Graphics g, String text, Vector2D position, boolean center, Color color, Font font) {

        g.setColor(color);
        g.setFont(font);
        Vector2D positio = new Vector2D(position.getX(), position.getY());

        if (center) {

            FontMetrics fm = g.getFontMetrics();
            position.setX(position.getX() - fm.stringWidth(text)/2);
            position.setY(position.getY() - fm.getHeight()/2);
        }

        g.drawString(text, (int)positio.getX(), (int)positio.getY());
    }
}
