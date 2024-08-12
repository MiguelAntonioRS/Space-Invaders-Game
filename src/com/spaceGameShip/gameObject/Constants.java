package com.spaceGameShip.gameObject;

import javax.swing.filechooser.FileSystemView;

public class Constants {

    public static final int WIDTH = 1000;
    public static final int HEIGHT = 600;
    public static final int FPS = 60;
    public static final double TARGETTIME = 1000000000/FPS;
    public static int AVERAGEFPS = FPS;
    public static final double ACC = 0.09;
    public static final double ANGLEDELTA = 0.1;
    public static final double PLAYER_MAX_VEL = 7;
    public static final long FLICKER_TIME = 200;
    public static final long SPAWNING_TIME = 3000;
    public static final double FIRERATE = 200;
    public static final double LASERVEL = 15.0;
    public static final long GAME_OVER_TIME = 3000;

    // Asteroid
    public static final double METEOR_VEL = 2.0;

    // UFO
    public static final int NODERADIUS = 160;
    public static final double UFOMASS = 60;
    public static final int UFOMAXVEL = 3;
    public static long UFOFIRERATE = 1000;
    public static double UFOANGLERANGE = Math.PI / 2;
    // Puntaje
    public static int UFOSCORE = 40;
    public static int ASTEROIDSCORE = 20;
    public static final long UFO_SPAWN_RATE = 10000;
    public static final String PLAY = "PLAY";
    public static final String EXIT = "EXIT";
    public static final int LOADING_BAR_WIDTH = 500;
    public static final int LOADING_BAR_HEIGHT = 50;
    public static final String RETURN = "RETURN";
    public static final String HIGH_SCORES = "HIGH SCORES";
    public static final String SCORE = "SCORE";
    public static final String DATE = "DATE";
    public static final String SCORE_PATH = FileSystemView.getFileSystemView().getDefaultDirectory().getPath() +
            "\\spaceGameShip\\data.json";
}
