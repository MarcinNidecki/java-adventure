package com.kodilla.pacmanv2;

public class Constant {

    private final int WIDTH = 1520;
    private final int HEIGHT = 960;
    private final int TILE_SIZE = 40;
    private final int speed = 4;
    private final String TITLE = "PacMan v.1.0.0";
    private final double targetTick = 45;

    public double getTargetTick() {
        return targetTick;
    }

    int getWIDTH() {
        return WIDTH;
    }

    int getHEIGHT() {
        return HEIGHT;
    }

    public int getTILE_SIZE() {
        return TILE_SIZE;
    }

    public  int getSpeed() {
        return speed;
    }

    String getTITLE() {
        return TITLE;
    }


}
