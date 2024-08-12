package com.spaceGameShip.ui;

import com.spaceGameShip.Graphics.Assets;
import com.spaceGameShip.Graphics.Text;
import com.spaceGameShip.input.MouseInput;
import com.spaceGameShip.math.Vector2D;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Button {

    private BufferedImage mouseOut;
    private BufferedImage mouseIn;
    private boolean mouseCheck;
    private Rectangle boundingBox;
    private String text;
    private Action action;

    public Button(BufferedImage mouseOut, BufferedImage mouseIn, int x, int y, String text, Action action) {
        this.mouseOut = mouseOut;
        this.mouseIn = mouseIn;
        this.text = text;
        boundingBox = new Rectangle(x, y, mouseIn.getWidth(), mouseIn.getHeight());
        this.action = action;
    }

    public void update() {

        if (boundingBox.contains(MouseInput.x,MouseInput.y)) {
            mouseCheck = true;
        } else {
            mouseCheck = false;
        }

        if (mouseCheck && MouseInput.MIB) {
            action.doAction();
        }
    }

    public void draw(Graphics g) {

        if (mouseCheck) {
            g.drawImage(mouseIn, boundingBox.x, boundingBox.y, null);
        } else {
            g.drawImage(mouseOut, boundingBox.x, boundingBox.y, null);
        }
        FontMetrics fm = g.getFontMetrics();


        Text.drawText(g, text, new Vector2D(
                boundingBox.getCenterX() - fm.stringWidth(text)/2,
                boundingBox.getCenterY() + 5),
                true, Color.BLACK, Assets.fontMed
        );
    }
}
