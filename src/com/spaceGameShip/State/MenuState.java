package com.spaceGameShip.State;

import com.spaceGameShip.Graphics.Assets;
import com.spaceGameShip.gameObject.Constants;
import com.spaceGameShip.ui.Action;
import com.spaceGameShip.ui.Button;
import java.awt.Graphics;
import java.util.ArrayList;

public class MenuState extends States{

    private ArrayList<Button> buttons;

    public MenuState() {
        buttons = new ArrayList<Button>();

        buttons.add(new Button(
                Assets.greyButton,
                Assets.blueButton,
                Constants.WIDTH / 2 - Assets.greyButton.getWidth() / 2,
                Constants.HEIGHT / 3 - Assets.greyButton.getHeight(),
                Constants.PLAY,
                new Action() {
                    @Override
                    public void doAction() {
                        States.changeState(new GameStates());
                    }
                }
                ));

        buttons.add(new Button(
                Assets.greyButton,
                Assets.blueButton,
                Constants.WIDTH / 2 - Assets.greyButton.getWidth() / 2,
                Constants.HEIGHT / 2 + Assets.greyButton.getHeight() / 2,
                Constants.EXIT,
                new Action() {
                    @Override
                    public void doAction() {
                        System.exit(0);
                    }
                }
        ));

        buttons.add(new Button(
                Assets.greyButton,
                Assets.blueButton,
                Constants.WIDTH / 2 - Assets.greyButton.getWidth() / 2,
                Constants.HEIGHT / 3 + 40,
                Constants.HIGH_SCORES,
                new Action() {
                    @Override
                    public void doAction() {
                        States.changeState(new StateScore());
                    }
                }
        ));
    }

    @Override
    public void update() {
        for (Button btn: buttons) {
            btn.update();
        }
    }

    @Override
    public void draw(Graphics g) {
        for (Button btn: buttons) {
            btn.draw(g);
        }
    }
}
