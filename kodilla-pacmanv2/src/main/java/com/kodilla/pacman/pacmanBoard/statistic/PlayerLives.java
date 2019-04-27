package com.kodilla.pacman.pacmanBoard.statistic;

import com.kodilla.pacman.GameInit;
import com.kodilla.pacman.items.ItemPictures;

import java.awt.*;

public class PlayerLives {

    private int lives = 3;

    public int getLives() {
        return lives;
    }

    public void setLives(int lives) {
        this.lives = lives;
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
