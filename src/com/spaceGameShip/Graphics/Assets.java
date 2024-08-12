package com.spaceGameShip.Graphics;

import javax.sound.sampled.Clip;
import java.awt.*;
import java.awt.image.BufferedImage;

public class Assets {

    public static boolean loaded = false;
    public static float count = 0;
    public static float MAX_COUNT = 460;

    // Jugador
    public static BufferedImage player;
    // propulsion
    public static BufferedImage speed;
    // Lasers properties
    public static BufferedImage redLaser;
    public static BufferedImage greenLaser;
    public static BufferedImage blueLaser;
    // Asteroids properties
    public static BufferedImage[] bigs = new BufferedImage[4];
    public static BufferedImage[] med = new BufferedImage[2];
    public static BufferedImage[] small = new BufferedImage[2];
    public static BufferedImage[] tinies = new BufferedImage[2];
    public static BufferedImage[] exp = new BufferedImage[9];
    // UFO
    public static BufferedImage ufo;
    // Numeros
    public static BufferedImage[] numbers = new BufferedImage[11];
    public static BufferedImage life;
    // Fuentes
    public static Font fontBig;
    public static Font fontMed;
    public static Clip backgroundMusic;
    public static Clip explosion;
    public static Clip playerLose;
    public static Clip playerShoot;
    public static Clip ufoShoot;
    public static BufferedImage greyButton;
    public static BufferedImage blueButton;

    public static void init() {

        player = loadImage("/ships/playerShip1_blue.png");

        speed = loadImage("/effects/fire08.png");

        redLaser = loadImage("/lasers/laserRed01.png");
        greenLaser = loadImage("/lasers/laserGreen11.png");
        blueLaser = loadImage("/lasers/laserBlue01.png");

        life = loadImage("/others/life.png");

        fontBig = loadFont("/fonts/future.ttf", 42);
        fontMed = loadFont("/fonts/future.ttf", 20);

        for (int i = 0; i < bigs.length; i++) {

            bigs[i] = loadImage("/meteors/big"+(i+1)+".png");
        }
        for (int i = 0; i < med.length; i++) {

            med[i] = loadImage("/meteors/med"+(i+1)+".png");
        }
        for (int i = 0; i < small.length; i++) {

            small[i] = loadImage("/meteors/small"+(i+1)+".png");
        }
        for (int i = 0; i < tinies.length; i++) {

            tinies[i] = loadImage("/meteors/tiny" + (i+1) +".png");
        }
        for (int i = 0; i < exp.length; i++) {
            exp[i] = loadImage("/collisions/"+i+".png");
        }

        ufo = loadImage("/ships/ufo.png");

        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = loadImage("/numbers/"+i+".png");
        }

        backgroundMusic = loadSound("/sounds/backgroundMusic.wav");
        explosion = loadSound("/sounds/explosion.wav");
        playerLose = loadSound("/sounds/playerLoose.wav");
        playerShoot = loadSound("/sounds/playerShoot.wav");
        ufoShoot = loadSound("/sounds/ufoShoot.wav");

        greyButton = loadImage("/ui/grey_button.png");
        blueButton = loadImage("/ui/blue_button.png");
//========================================================================
        player = loadImage("/ships/playerShip1_blue.png");

        speed = loadImage("/effects/fire08.png");

        redLaser = loadImage("/lasers/laserRed01.png");
        greenLaser = loadImage("/lasers/laserGreen11.png");
        blueLaser = loadImage("/lasers/laserBlue01.png");

        life = loadImage("/others/life.png");

        fontBig = loadFont("/fonts/future.ttf", 42);
        fontMed = loadFont("/fonts/future.ttf", 20);

        for (int i = 0; i < bigs.length; i++) {

            bigs[i] = loadImage("/meteors/big"+(i+1)+".png");
        }
        for (int i = 0; i < med.length; i++) {

            med[i] = loadImage("/meteors/med"+(i+1)+".png");
        }
        for (int i = 0; i < small.length; i++) {

            small[i] = loadImage("/meteors/small"+(i+1)+".png");
        }
        for (int i = 0; i < tinies.length; i++) {

            tinies[i] = loadImage("/meteors/tiny" + (i+1) +".png");
        }
        for (int i = 0; i < exp.length; i++) {
            exp[i] = loadImage("/collisions/"+i+".png");
        }

        ufo = loadImage("/ships/ufo.png");

        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = loadImage("/numbers/"+i+".png");
        }

        backgroundMusic = loadSound("/sounds/backgroundMusic.wav");
        explosion = loadSound("/sounds/explosion.wav");
        playerLose = loadSound("/sounds/playerLoose.wav");
        playerShoot = loadSound("/sounds/playerShoot.wav");
        ufoShoot = loadSound("/sounds/ufoShoot.wav");

        greyButton = loadImage("/ui/grey_button.png");
        blueButton = loadImage("/ui/blue_button.png");
//========================================================================
        player = loadImage("/ships/playerShip1_blue.png");

        speed = loadImage("/effects/fire08.png");

        redLaser = loadImage("/lasers/laserRed01.png");
        greenLaser = loadImage("/lasers/laserGreen11.png");
        blueLaser = loadImage("/lasers/laserBlue01.png");

        life = loadImage("/others/life.png");

        fontBig = loadFont("/fonts/future.ttf", 42);
        fontMed = loadFont("/fonts/future.ttf", 20);

        for (int i = 0; i < bigs.length; i++) {

            bigs[i] = loadImage("/meteors/big"+(i+1)+".png");
        }
        for (int i = 0; i < med.length; i++) {

            med[i] = loadImage("/meteors/med"+(i+1)+".png");
        }
        for (int i = 0; i < small.length; i++) {

            small[i] = loadImage("/meteors/small"+(i+1)+".png");
        }
        for (int i = 0; i < tinies.length; i++) {

            tinies[i] = loadImage("/meteors/tiny" + (i+1) +".png");
        }
        for (int i = 0; i < exp.length; i++) {
            exp[i] = loadImage("/collisions/"+i+".png");
        }

        ufo = loadImage("/ships/ufo.png");

        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = loadImage("/numbers/"+i+".png");
        }

        backgroundMusic = loadSound("/sounds/backgroundMusic.wav");
        explosion = loadSound("/sounds/explosion.wav");
        playerLose = loadSound("/sounds/playerLoose.wav");
        playerShoot = loadSound("/sounds/playerShoot.wav");
        ufoShoot = loadSound("/sounds/ufoShoot.wav");

        greyButton = loadImage("/ui/grey_button.png");
        blueButton = loadImage("/ui/blue_button.png");
//========================================================================
        player = loadImage("/ships/playerShip1_blue.png");

        speed = loadImage("/effects/fire08.png");

        redLaser = loadImage("/lasers/laserRed01.png");
        greenLaser = loadImage("/lasers/laserGreen11.png");
        blueLaser = loadImage("/lasers/laserBlue01.png");

        life = loadImage("/others/life.png");

        fontBig = loadFont("/fonts/future.ttf", 42);
        fontMed = loadFont("/fonts/future.ttf", 20);

        for (int i = 0; i < bigs.length; i++) {

            bigs[i] = loadImage("/meteors/big"+(i+1)+".png");
        }
        for (int i = 0; i < med.length; i++) {

            med[i] = loadImage("/meteors/med"+(i+1)+".png");
        }
        for (int i = 0; i < small.length; i++) {

            small[i] = loadImage("/meteors/small"+(i+1)+".png");
        }
        for (int i = 0; i < tinies.length; i++) {

            tinies[i] = loadImage("/meteors/tiny" + (i+1) +".png");
        }
        for (int i = 0; i < exp.length; i++) {
            exp[i] = loadImage("/collisions/"+i+".png");
        }

        ufo = loadImage("/ships/ufo.png");

        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = loadImage("/numbers/"+i+".png");
        }

        backgroundMusic = loadSound("/sounds/backgroundMusic.wav");
        explosion = loadSound("/sounds/explosion.wav");
        playerLose = loadSound("/sounds/playerLoose.wav");
        playerShoot = loadSound("/sounds/playerShoot.wav");
        ufoShoot = loadSound("/sounds/ufoShoot.wav");

        greyButton = loadImage("/ui/grey_button.png");
        blueButton = loadImage("/ui/blue_button.png");
//========================================================================
        player = loadImage("/ships/playerShip1_blue.png");

        speed = loadImage("/effects/fire08.png");

        redLaser = loadImage("/lasers/laserRed01.png");
        greenLaser = loadImage("/lasers/laserGreen11.png");
        blueLaser = loadImage("/lasers/laserBlue01.png");

        life = loadImage("/others/life.png");

        fontBig = loadFont("/fonts/future.ttf", 42);
        fontMed = loadFont("/fonts/future.ttf", 20);

        for (int i = 0; i < bigs.length; i++) {

            bigs[i] = loadImage("/meteors/big"+(i+1)+".png");
        }
        for (int i = 0; i < med.length; i++) {

            med[i] = loadImage("/meteors/med"+(i+1)+".png");
        }
        for (int i = 0; i < small.length; i++) {

            small[i] = loadImage("/meteors/small"+(i+1)+".png");
        }
        for (int i = 0; i < tinies.length; i++) {

            tinies[i] = loadImage("/meteors/tiny" + (i+1) +".png");
        }
        for (int i = 0; i < exp.length; i++) {
            exp[i] = loadImage("/collisions/"+i+".png");
        }

        ufo = loadImage("/ships/ufo.png");

        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = loadImage("/numbers/"+i+".png");
        }

        backgroundMusic = loadSound("/sounds/backgroundMusic.wav");
        explosion = loadSound("/sounds/explosion.wav");
        playerLose = loadSound("/sounds/playerLoose.wav");
        playerShoot = loadSound("/sounds/playerShoot.wav");
        ufoShoot = loadSound("/sounds/ufoShoot.wav");

        greyButton = loadImage("/ui/grey_button.png");
        blueButton = loadImage("/ui/blue_button.png");
//========================================================================
        player = loadImage("/ships/playerShip1_blue.png");

        speed = loadImage("/effects/fire08.png");

        redLaser = loadImage("/lasers/laserRed01.png");
        greenLaser = loadImage("/lasers/laserGreen11.png");
        blueLaser = loadImage("/lasers/laserBlue01.png");

        life = loadImage("/others/life.png");

        fontBig = loadFont("/fonts/future.ttf", 42);
        fontMed = loadFont("/fonts/future.ttf", 20);

        for (int i = 0; i < bigs.length; i++) {

            bigs[i] = loadImage("/meteors/big"+(i+1)+".png");
        }
        for (int i = 0; i < med.length; i++) {

            med[i] = loadImage("/meteors/med"+(i+1)+".png");
        }
        for (int i = 0; i < small.length; i++) {

            small[i] = loadImage("/meteors/small"+(i+1)+".png");
        }
        for (int i = 0; i < tinies.length; i++) {

            tinies[i] = loadImage("/meteors/tiny" + (i+1) +".png");
        }
        for (int i = 0; i < exp.length; i++) {
            exp[i] = loadImage("/collisions/"+i+".png");
        }

        ufo = loadImage("/ships/ufo.png");

        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = loadImage("/numbers/"+i+".png");
        }

        backgroundMusic = loadSound("/sounds/backgroundMusic.wav");
        explosion = loadSound("/sounds/explosion.wav");
        playerLose = loadSound("/sounds/playerLoose.wav");
        playerShoot = loadSound("/sounds/playerShoot.wav");
        ufoShoot = loadSound("/sounds/ufoShoot.wav");

        greyButton = loadImage("/ui/grey_button.png");
        blueButton = loadImage("/ui/blue_button.png");
//========================================================================
        player = loadImage("/ships/playerShip1_blue.png");

        speed = loadImage("/effects/fire08.png");

        redLaser = loadImage("/lasers/laserRed01.png");
        greenLaser = loadImage("/lasers/laserGreen11.png");
        blueLaser = loadImage("/lasers/laserBlue01.png");

        life = loadImage("/others/life.png");

        fontBig = loadFont("/fonts/future.ttf", 42);
        fontMed = loadFont("/fonts/future.ttf", 20);

        for (int i = 0; i < bigs.length; i++) {

            bigs[i] = loadImage("/meteors/big"+(i+1)+".png");
        }
        for (int i = 0; i < med.length; i++) {

            med[i] = loadImage("/meteors/med"+(i+1)+".png");
        }
        for (int i = 0; i < small.length; i++) {

            small[i] = loadImage("/meteors/small"+(i+1)+".png");
        }
        for (int i = 0; i < tinies.length; i++) {

            tinies[i] = loadImage("/meteors/tiny" + (i+1) +".png");
        }
        for (int i = 0; i < exp.length; i++) {
            exp[i] = loadImage("/collisions/"+i+".png");
        }

        ufo = loadImage("/ships/ufo.png");

        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = loadImage("/numbers/"+i+".png");
        }

        backgroundMusic = loadSound("/sounds/backgroundMusic.wav");
        explosion = loadSound("/sounds/explosion.wav");
        playerLose = loadSound("/sounds/playerLoose.wav");
        playerShoot = loadSound("/sounds/playerShoot.wav");
        ufoShoot = loadSound("/sounds/ufoShoot.wav");

        greyButton = loadImage("/ui/grey_button.png");
        blueButton = loadImage("/ui/blue_button.png");
//========================================================================
        player = loadImage("/ships/playerShip1_blue.png");

        speed = loadImage("/effects/fire08.png");

        redLaser = loadImage("/lasers/laserRed01.png");
        greenLaser = loadImage("/lasers/laserGreen11.png");
        blueLaser = loadImage("/lasers/laserBlue01.png");

        life = loadImage("/others/life.png");

        fontBig = loadFont("/fonts/future.ttf", 42);
        fontMed = loadFont("/fonts/future.ttf", 20);

        for (int i = 0; i < bigs.length; i++) {

            bigs[i] = loadImage("/meteors/big"+(i+1)+".png");
        }
        for (int i = 0; i < med.length; i++) {

            med[i] = loadImage("/meteors/med"+(i+1)+".png");
        }
        for (int i = 0; i < small.length; i++) {

            small[i] = loadImage("/meteors/small"+(i+1)+".png");
        }
        for (int i = 0; i < tinies.length; i++) {

            tinies[i] = loadImage("/meteors/tiny" + (i+1) +".png");
        }
        for (int i = 0; i < exp.length; i++) {
            exp[i] = loadImage("/collisions/"+i+".png");
        }

        ufo = loadImage("/ships/ufo.png");

        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = loadImage("/numbers/"+i+".png");
        }

        backgroundMusic = loadSound("/sounds/backgroundMusic.wav");
        explosion = loadSound("/sounds/explosion.wav");
        playerLose = loadSound("/sounds/playerLoose.wav");
        playerShoot = loadSound("/sounds/playerShoot.wav");
        ufoShoot = loadSound("/sounds/ufoShoot.wav");

        greyButton = loadImage("/ui/grey_button.png");
        blueButton = loadImage("/ui/blue_button.png");
//========================================================================
        player = loadImage("/ships/playerShip1_blue.png");

        speed = loadImage("/effects/fire08.png");

        redLaser = loadImage("/lasers/laserRed01.png");
        greenLaser = loadImage("/lasers/laserGreen11.png");
        blueLaser = loadImage("/lasers/laserBlue01.png");

        life = loadImage("/others/life.png");

        fontBig = loadFont("/fonts/future.ttf", 42);
        fontMed = loadFont("/fonts/future.ttf", 20);

        for (int i = 0; i < bigs.length; i++) {

            bigs[i] = loadImage("/meteors/big"+(i+1)+".png");
        }
        for (int i = 0; i < med.length; i++) {

            med[i] = loadImage("/meteors/med"+(i+1)+".png");
        }
        for (int i = 0; i < small.length; i++) {

            small[i] = loadImage("/meteors/small"+(i+1)+".png");
        }
        for (int i = 0; i < tinies.length; i++) {

            tinies[i] = loadImage("/meteors/tiny" + (i+1) +".png");
        }
        for (int i = 0; i < exp.length; i++) {
            exp[i] = loadImage("/collisions/"+i+".png");
        }

        ufo = loadImage("/ships/ufo.png");

        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = loadImage("/numbers/"+i+".png");
        }

        backgroundMusic = loadSound("/sounds/backgroundMusic.wav");
        explosion = loadSound("/sounds/explosion.wav");
        playerLose = loadSound("/sounds/playerLoose.wav");
        playerShoot = loadSound("/sounds/playerShoot.wav");
        ufoShoot = loadSound("/sounds/ufoShoot.wav");

        greyButton = loadImage("/ui/grey_button.png");
        blueButton = loadImage("/ui/blue_button.png");
//========================================================================
        player = loadImage("/ships/playerShip1_blue.png");

        speed = loadImage("/effects/fire08.png");

        redLaser = loadImage("/lasers/laserRed01.png");
        greenLaser = loadImage("/lasers/laserGreen11.png");
        blueLaser = loadImage("/lasers/laserBlue01.png");

        life = loadImage("/others/life.png");

        fontBig = loadFont("/fonts/future.ttf", 42);
        fontMed = loadFont("/fonts/future.ttf", 20);

        for (int i = 0; i < bigs.length; i++) {

            bigs[i] = loadImage("/meteors/big"+(i+1)+".png");
        }
        for (int i = 0; i < med.length; i++) {

            med[i] = loadImage("/meteors/med"+(i+1)+".png");
        }
        for (int i = 0; i < small.length; i++) {

            small[i] = loadImage("/meteors/small"+(i+1)+".png");
        }
        for (int i = 0; i < tinies.length; i++) {

            tinies[i] = loadImage("/meteors/tiny" + (i+1) +".png");
        }
        for (int i = 0; i < exp.length; i++) {
            exp[i] = loadImage("/collisions/"+i+".png");
        }

        ufo = loadImage("/ships/ufo.png");

        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = loadImage("/numbers/"+i+".png");
        }

        backgroundMusic = loadSound("/sounds/backgroundMusic.wav");
        explosion = loadSound("/sounds/explosion.wav");
        playerLose = loadSound("/sounds/playerLoose.wav");
        playerShoot = loadSound("/sounds/playerShoot.wav");
        ufoShoot = loadSound("/sounds/ufoShoot.wav");

        greyButton = loadImage("/ui/grey_button.png");
        blueButton = loadImage("/ui/blue_button.png");
//========================================================================
        loaded = true;
    }


    public static BufferedImage loadImage(String path) {
        count ++;
        return Loader.imageLoader(path);
    }

    public static Font loadFont(String path, int size) {
        count ++;
        return Loader.loadFont(path, size);
    }

    public static Clip loadSound(String path) {
        count ++;
        return Loader.loadSound(path);
    }
}
