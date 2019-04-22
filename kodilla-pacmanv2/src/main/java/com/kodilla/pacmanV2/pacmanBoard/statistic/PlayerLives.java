package com.kodilla.pacmanV2.pacmanBoard.statistic;

import com.kodilla.pacmanV2.Animation;
import com.kodilla.pacmanV2.PacmanAppRunner;

import java.awt.*;

public class PlayerLives {

    public int lives = 3;


    public void removeLive() {
        lives -= 1;
    }


    public void paintComponent(Graphics g) {
        int position = PacmanAppRunner.TILE_SIZE * 3;
        for (int i = 0; i < lives; i++) {
            g.drawImage(Animation.player[0][2], position, 900, 32, 32, null);
            position += PacmanAppRunner.TILE_SIZE;
        }


    }
}
