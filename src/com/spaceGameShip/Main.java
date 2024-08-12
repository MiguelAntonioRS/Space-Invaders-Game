package com.spaceGameShip;

import com.spaceGameShip.Graphics.Assets;
import com.spaceGameShip.State.LoadingState;
import com.spaceGameShip.State.States;
import com.spaceGameShip.gameObject.Constants;
import com.spaceGameShip.input.KeyBoard;
import com.spaceGameShip.input.MouseInput;
import javax.swing.JFrame;
import java.awt.Canvas;
import java.awt.Graphics;
import java.awt.Dimension;
import java.awt.Color;
import java.awt.image.BufferStrategy;

public class Main extends JFrame implements Runnable {

    private Canvas canvas;
    private Thread thread;
    private boolean running = false;
    private BufferStrategy bs;
    private Graphics g;
    private double delta = 0;
    private KeyBoard keyBoard;
    private MouseInput mouseInput;

    public Main() {
        setTitle("Space Ship");
        setSize(Constants.WIDTH, Constants.HEIGHT);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setLocationRelativeTo(null);

        canvas = new Canvas();
        keyBoard = new KeyBoard();
        mouseInput = new MouseInput();

        canvas.setPreferredSize(new Dimension(Constants.WIDTH, Constants.HEIGHT));
        canvas.setMaximumSize(new Dimension(Constants.WIDTH, Constants.HEIGHT));
        canvas.setMinimumSize(new Dimension(Constants.WIDTH, Constants.HEIGHT));
        canvas.setFocusable(true);

        add(canvas);
        canvas.addKeyListener(keyBoard);
        canvas.addMouseListener(mouseInput);
        canvas.addMouseMotionListener(mouseInput);
        setVisible(true);
    }

    public static void main(String[] args) {
        new Main().start();
    }

    private void update() {

        keyBoard.update();
        States.getCurrentState().update();
    }

    private void draw() {
        bs = canvas.getBufferStrategy();

        if (bs == null) {
            canvas.createBufferStrategy(3);
            return;
        }
        g = bs.getDrawGraphics();

        g.setColor(Color.BLACK);
        g.fillRect(0, 0, Constants.WIDTH, Constants.HEIGHT);

        States.getCurrentState().draw(g);

        g.setColor(Color.WHITE);
        g.drawString(""+Constants.AVERAGEFPS,10,10);

        g.dispose();
        bs.show();
    }

    private void init() {

        Thread loadingThread = new Thread(new Runnable() {
            @Override
            public void run() {
                Assets.init();
            }
        });

        States.changeState(new LoadingState(loadingThread));
    }

    @Override
    public void run() {

        long now;
        long lastTime = System.nanoTime();
        int frames = 0;
        long time = 0;
        init();

        while (running) {
            now = System.nanoTime();
            delta += (now - lastTime) / Constants.TARGETTIME;
            time += (now - lastTime);
            lastTime = now;

            if (delta >= 1) {

                update();
                draw();
                delta --;
                frames ++;
            }

            if (time >= 1000000000) {

                Constants.AVERAGEFPS = frames;
                frames = 0;
                time = 0;
            }
        }

        stop();
    }

    private void start() {

        thread = new Thread(this);
        thread.start();
        running = true;
    }

    private void stop() {

        try {
            thread.join();
            running = false;
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}