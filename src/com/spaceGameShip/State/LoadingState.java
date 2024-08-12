package com.spaceGameShip.State;

import com.spaceGameShip.Graphics.Assets;
import com.spaceGameShip.Graphics.Loader;
import com.spaceGameShip.Graphics.Text;
import com.spaceGameShip.gameObject.Constants;
import com.spaceGameShip.math.Vector2D;

import java.awt.*;

public class LoadingState extends States{

    private Thread loadingThread;
    private Font font;

    public LoadingState(Thread loadingThread) {
        this.loadingThread = loadingThread;
        this.loadingThread.start();
        font = Loader.loadFont("/fonts/future.ttf", 38);
    }

    @Override
    public void update() {

        if (Assets.loaded) {
            States.changeState(new MenuState());
            try {
                loadingThread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void draw(Graphics g) {
        GradientPaint gradientPaint = new GradientPaint(
                Constants.WIDTH / 2 - Constants.LOADING_BAR_WIDTH / 2,
                Constants.HEIGHT / 2 - Constants.LOADING_BAR_HEIGHT / 2,
                Color.WHITE,
                Constants.WIDTH / 2 + Constants.LOADING_BAR_WIDTH / 2,
                Constants.HEIGHT / 2 + Constants.LOADING_BAR_HEIGHT / 2,
                Color.BLUE
        );

        Graphics2D graphics2D = (Graphics2D)g;
        graphics2D.setPaint(gradientPaint);

        float porcetange = (Assets.count / Assets.MAX_COUNT);

        graphics2D.fillRect(Constants.WIDTH / 2 - Constants.LOADING_BAR_WIDTH / 2,
                Constants.HEIGHT / 2 - Constants.LOADING_BAR_HEIGHT / 2,
                (int) (Constants.LOADING_BAR_WIDTH * porcetange),
                Constants.LOADING_BAR_HEIGHT);

        graphics2D.drawRect(Constants.WIDTH / 2 - Constants.LOADING_BAR_WIDTH / 2,
                Constants.HEIGHT / 2 - Constants.LOADING_BAR_HEIGHT / 2,
                Constants.LOADING_BAR_WIDTH,
                Constants.LOADING_BAR_HEIGHT);

        Text.drawText(graphics2D, "Space Invaders Game", new Vector2D(Constants.WIDTH / 2 - 265, Constants.HEIGHT / 2 - 80),
                true, Color.WHITE, font);

        Text.drawText(graphics2D, "LOADING...", new Vector2D(Constants.WIDTH / 2 - 100, Constants.HEIGHT / 2 + 20),
                true, Color.WHITE, font);
    }
}
