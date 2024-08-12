package com.spaceGameShip.State;

import com.spaceGameShip.Graphics.Animation;
import com.spaceGameShip.Graphics.Assets;
import com.spaceGameShip.Graphics.Sound;
import com.spaceGameShip.Graphics.Text;
import com.spaceGameShip.gameObject.*;
import com.spaceGameShip.io.DataScore;
import com.spaceGameShip.io.ParserJSON;
import com.spaceGameShip.math.Vector2D;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

public class GameStates extends States{

    private Player player;
    private ArrayList<MovingObject> movingObjects = new ArrayList<MovingObject>();
    private ArrayList<Animation> animations = new ArrayList<Animation>();
    private ArrayList<Message> messages = new ArrayList<Message>();
    private int meteors;
    private int waves = 1;
    private int score = 0;
    private int lives = 3;
    private Sound backgroundMusic;
    private Chronometer gameOverTimer;
    private boolean gameOver;
    private Chronometer ufoSpawn;
    public static final Vector2D PLAYER_START_POSITION = new Vector2D(Constants.WIDTH/2 - Assets.player.getWidth()/2,
            Constants.HEIGHT/2 - Assets.player.getHeight()/2);

    public GameStates() {

        player = new Player(PLAYER_START_POSITION, new Vector2D(),
                Constants.PLAYER_MAX_VEL, Assets.player, this);

        gameOverTimer = new Chronometer();
        gameOver = false;
        movingObjects.add(player);
        meteors = 1;
        startWave();
        backgroundMusic = new Sound(Assets.backgroundMusic);
        backgroundMusic.loop();
        backgroundMusic.changeVolume(-10.0f);

        ufoSpawn = new Chronometer();
        ufoSpawn.run(Constants.UFO_SPAWN_RATE);
    }

    public void addScore(int value, Vector2D position) {
        score += value;
        messages.add(new Message(position, true, "+"+value+" score", Color.WHITE, false, Assets.fontMed, this));
    }

    public void divideAsteroid(Asteroids asteroids) {

        Size size = asteroids.getSize();

        BufferedImage[] textures = size.textures;
        Size newSize = null;

        switch (size) {
            case BIG:
                newSize = Size.MED;
                break;
            case MED:
                newSize = Size.SMALL;
                break;
            case SMALL:
                newSize = Size.TINY;
                break;
            default:
                return;
        }

        for (int i = 0; i < size.quantity; i++) {

            movingObjects.add(new Asteroids(asteroids.getPosition(),
                    new Vector2D(0,1).
                    setDirection(Math.random()*Math.PI),
                    Constants.METEOR_VEL*Math.random() + 1,
                    textures[(int) (Math.random() * textures.length)], this, newSize));
        }
    }

    public void startWave() {

        messages.add(new Message(new Vector2D(Constants.WIDTH/2,Constants.HEIGHT/2),false,
                "Wave "+waves, Color.WHITE, false, Assets.fontMed, this));

        double x;
        double y;

        for (int i = 0; i < meteors; i++) {
            x = i % 2 == 0 ? Math.random() * Constants.WIDTH : 0;
            y = i % 2 == 0 ? 0 : Math.random() * Constants.HEIGHT;

            BufferedImage texture = Assets.bigs[(int) (Math.random()*Assets.bigs.length)];
            movingObjects.add(new Asteroids(new Vector2D(x,y),
                    new Vector2D(0,1).setDirection(Math.random()*Math.PI),
                    Constants.METEOR_VEL*Math.random() + 1,
                    texture, this, Size.BIG));
        }
        meteors++;
    }

    public void explosion(Vector2D position) {
        animations.add(new Animation(
                Assets.exp,
                50,
                position.rest(new Vector2D(Assets.exp[0].getWidth()/2, Assets.exp[0].getHeight()/2))
        ));
    }

    private void spawnUfo() {

        int rand = (int) (Math.random() * 2);

        double x = rand == 0 ? (Math.random() * Constants.WIDTH): 0;
        double y = rand == 0 ? 0 : (Math.random() * Constants.WIDTH);

        ArrayList<Vector2D> path = new ArrayList<Vector2D>();

        double posX;
        double posY;

        posX = Math.random() * Constants.WIDTH/2;
        posY = Math.random() * Constants.HEIGHT/2;
        path.add(new Vector2D(posX, posY));

        posX = Math.random() * (Constants.WIDTH/2) + Constants.WIDTH/2;
        posY = Math.random() * Constants.HEIGHT/2;
        path.add(new Vector2D(posX, posY));

        posX = Math.random() * Constants.WIDTH/2;
        posY = Math.random() * (Constants.HEIGHT/2) + Constants.HEIGHT/2;
        path.add(new Vector2D(posX, posY));

        posX = Math.random() * (Constants.WIDTH/2) + Constants.WIDTH/2;
        posY = Math.random() * (Constants.HEIGHT/2) + Constants.HEIGHT/2;
        path.add(new Vector2D(posX, posY));

        movingObjects.add(new Ufo(
                new Vector2D(x, y),
                new Vector2D(),
                Constants.UFOMAXVEL,
                Assets.ufo,
                path,
                this
        ));
    }

    public void update() {

        for(int i = 0; i < movingObjects.size(); i++) {

            MovingObject movingObject = movingObjects.get(i);

            movingObject.update();
            if(movingObject.isDead()) {
                movingObjects.remove(i);
                i--;
            }

        }

        /*for (int i = 0; i < movingObjects.size(); i++)
                movingObjects.get(i).update();*/

        for (int i = 0; i < animations.size(); i++){
            Animation animation = animations.get(i);
            animation.update();
            if (!animation.isRunning()) {
                animations.remove(i);
            }
        }

        if (gameOver && !gameOverTimer.isRunning()) {

            try {

                ArrayList<DataScore> listData = ParserJSON.dataScores();
                listData.add(new DataScore(score));
                ParserJSON.fileWrite(listData);

            } catch (IOException e) {
                e.printStackTrace();
            }

            States.changeState(new MenuState());
        }

        if (!ufoSpawn.isRunning()) {
            ufoSpawn.run(Constants.UFO_SPAWN_RATE);
            spawnUfo();
        }

        gameOverTimer.update();
        ufoSpawn.update();

        for (int i = 0; i < movingObjects.size(); i++){
            if (movingObjects.get(i) instanceof Asteroids){
                return;
            }
        }
        startWave();
    }

    public void draw(Graphics g) {

        Graphics2D g2d = (Graphics2D)g;
        g2d.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);

        for (int i = 0; i < messages.size(); i++) {
            messages.get(i).draw(g2d);
            if (messages.get(i).isDead())
                messages.remove(i);
        }

        for (int i = 0; i < movingObjects.size(); i++)
            movingObjects.get(i).draw(g);


        for (int i = 0; i < animations.size(); i++){
            Animation animation = animations.get(i);
            g2d.drawImage(animation.getCurrentFrame(), (int)animation.getPosition().getX(), (int)animation.getPosition().getY(), null);
        }
        drawScore(g);
        drawLives(g);
    }

    private void drawScore(Graphics g) {

        Vector2D position = new Vector2D(850,25);
        String scoreToString = Integer.toString(score);

        for (int i = 0; i < scoreToString.length(); i++) {

            g.drawImage(Assets.numbers[Integer.parseInt(scoreToString.substring(i, i + 1))],
                    (int)position.getX(), (int)position.getY(), null);

            position.setX(position.getX() + 20);
        }
    }

    private void drawLives(Graphics g) {

        if (lives < 1) {
            return;
        }

        Vector2D livePosition = new Vector2D(25, 25);

        g.drawImage(Assets.life, (int)livePosition.getX(), (int)livePosition.getY(), null);
        g.drawImage(Assets.numbers[10], (int)livePosition.getX() + 40,
                (int)livePosition.getY() + 5, null);

        String livesToString = Integer.toString(lives);
        Vector2D position = new Vector2D(livePosition.getX(), livePosition.getY());

        for (int i = 0; i < livesToString.length(); i++) {

            int number = Integer.parseInt(livesToString.substring(i, i + 1));

            if (number <= 0)
                break;
            g.drawImage(Assets.numbers[number], (int)position.getX() + 60,
                    (int)position.getY() + 5, null);
            position.setX(position.getX() + 20);
        }
    }

    public ArrayList<MovingObject> getMovingObjects() {
        return movingObjects;
    }

    public ArrayList<Message> getMessages() {
        return messages;
    }

    public Player getPlayer() {
        return player;
    }

    public boolean restLive() {

        lives--;
        return lives > 0;
    }

    public void gameOver() {
        Message gameOverMsg = new Message(
                PLAYER_START_POSITION,
                true,
                "GAME OVER",
                Color.WHITE,
                false,
                Assets.fontMed, this);

        this.messages.add(gameOverMsg);
        gameOverTimer.run(Constants.GAME_OVER_TIME);
        gameOver = true;
    }
}
