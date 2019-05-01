package com.kodilla.pacmanv2.pacmanBoard.statistic;

import com.kodilla.pacmanv2.GameInit;
import com.kodilla.pacmanv2.items.ItemPictures;

import java.awt.*;

public class PlayerLives {

    private static int lives = 3;

    public static int getLives() {
        return lives;
    }

    public void setLives(int lives) {
        PlayerLives.lives = lives;
    }

    public void removeLive() {
        lives -= 1;
    }


    public void paintComponent(Graphics g) {
        int position = GameInit.TILE_SIZE * 3;
        for (int i = 0; i < lives; i++) {
            g.drawImage(ItemPictures.player[0][2], position, 900, 32, 32, null);
            position += GameInit.TILE_SIZE;

        }


    }
}
