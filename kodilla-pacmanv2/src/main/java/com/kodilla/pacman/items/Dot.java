package com.kodilla.pacman.items;

import com.kodilla.pacman.GameInit;

import java.awt.*;

public class Dot extends Rectangle implements Items {


    public Dot(int x, int y) {
        setBounds(x, y, GameInit.TILE_SIZE, GameInit.TILE_SIZE);
    }

    public void render(Graphics g) {
        g.drawImage(ItemPictures.dot, x, y, 32, 32, null);

    }

    @Override
    public String toString() {
        return "" + x + y;
    }
}
