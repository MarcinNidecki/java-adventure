package com.kodilla.pacmanV2.items;

import java.awt.*;

public class Wall extends Rectangle implements Items {


    public Wall(int x, int y) {
        setBounds(x, y, 40, 40);
    }

    @Override
    public String toString() {
        return "" + x + y;
    }
}
