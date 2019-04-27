package com.kodilla.pacman.pacmanBoard;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import java.io.File;
import java.util.Objects;

public class Music {


    public void playWelocmeSound() {
        try {
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File(Objects.requireNonNull(getClass().getClassLoader().getResource("assets/sounds/pacman_beginning.wav")).getFile()));
            Clip clip = AudioSystem.getClip();
            clip.open(audioInputStream);
            clip.start();
        } catch (Exception ex) {
            System.out.println("Error with playing sound.");
            ex.printStackTrace();
        }

    }

    public void playBackgroundSound() {
        try {
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File(Objects.requireNonNull(getClass().getClassLoader().getResource("assets/sounds/pacman_chomp.wav")).getFile()));
            Clip clip = AudioSystem.getClip();
            clip.open(audioInputStream);
            clip.start();
        } catch (Exception ex) {
            System.out.println("Error with playing sound.");
            ex.printStackTrace();
        }

    }
}
