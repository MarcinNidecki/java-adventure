package com.kodilla.pacmanv2.items;

import com.kodilla.pacmanv2.Constant;

import java.awt.*;

public class Empty extends Rectangle implements Items {


    public Empty(int x, int y) {
        Constant constant = new Constant();
        setBounds(x, y, constant.getTILE_SIZE(), constant.getTILE_SIZE());
    }


    @Override
    public String toString() {
        return "" + x + y;
    }
}
