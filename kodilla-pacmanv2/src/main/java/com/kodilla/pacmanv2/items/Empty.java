package com.kodilla.pacmanv2.items;

import com.kodilla.pacmanv2.GameInit;

import java.awt.*;

public class Empty extends Rectangle implements Items {


    public Empty(int x, int y) {
        setBounds(x, y, GameInit.TILE_SIZE, GameInit.TILE_SIZE);
    }


    @Override
    public String toString() {
        return "" + x + y;
    }
}