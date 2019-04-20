package com.kodilla.pacmanV2.pacmanBoard.music;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import java.io.File;

public class Music {

    public boolean isWasPlayed() {
        return wasPlayed;
    }

    boolean wasPlayed = false;

    public void playWelocmeSound() {
        try {
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File("kodilla-pacmanv2\\src\\main\\resources\\assets\\sounds\\pacman_beginning.wav").getAbsoluteFile());
            Clip clip = AudioSystem.getClip();
            clip.open(audioInputStream);
            clip.start();
        } catch(Exception ex) {
            System.out.println("Error with playing sound.");
            ex.printStackTrace();
        }
        wasPlayed = true;
    }
    public void playBackgroundSound() {
        try {
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File("kodilla-pacmanv2\\src\\main\\resources\\assets\\sounds\\pacman_chomp.wav").getAbsoluteFile());
            Clip clip = AudioSystem.getClip();
            clip.open(audioInputStream);
            clip.start();
        } catch(Exception ex) {
            System.out.println("Error with playing sound.");
            ex.printStackTrace();
        }
        wasPlayed = true;
    }
}
