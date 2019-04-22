package com.kodilla.pacmanV2.items;

import com.kodilla.pacmanV2.Animation;
import com.kodilla.pacmanV2.PacmanAppRunner;

import java.awt.*;

public class BigDot extends Rectangle implements Items {


    public BigDot(int x, int y) {
        setBounds(x, y, PacmanAppRunner.TILE_SIZE, PacmanAppRunner.TILE_SIZE);
    }

    public void render(Graphics g) {
        g.drawImage(Animation.bitDot[0], x, y, 32, 32, null);

    }

    @Override
    public String toString() {
        return "" + x + y;
    }
}
