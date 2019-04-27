package com.kodilla.pacmanV2.items;

import java.awt.*;

import static com.kodilla.pacmanV2.GameInit.TILE_SIZE;

public class BigDot extends Rectangle implements Items {


    public BigDot(int x, int y) {
        setBounds(x, y, TILE_SIZE, TILE_SIZE);
    }

    public void render(Graphics g) {
        g.drawImage(ItemPictures.bigDot, x, y, 32, 32, null);

    }

    @Override
    public String toString() {
        return "" + x + y;
    }
}
