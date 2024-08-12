package com.spaceGameShip.Graphics;

import javax.imageio.ImageIO;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.JOptionPane;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class Loader {

    public static BufferedImage imageLoader(String path) {

        try {
            return ImageIO.read(Loader.class.getResource(path));
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, e.toString());
        }
        return null;
    }

    public static Font loadFont(String path, int size) {
        try {
            return Font.createFont(Font.TRUETYPE_FONT, Loader.class.getResourceAsStream(path)).deriveFont(Font.PLAIN, size);
        } catch (IOException | FontFormatException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static Clip loadSound(String path) {

        try {
            Clip clip = AudioSystem.getClip();
            clip.open(AudioSystem.getAudioInputStream(Loader.class.getResource(path)));
            return clip;
        } catch (LineUnavailableException | IOException | UnsupportedAudioFileException e) {
            e.printStackTrace();
        }
        return null;
    }
}
