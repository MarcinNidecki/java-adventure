package com.kodilla.pacmanV2;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Animation {

    public static BufferedImage[][] player;
    public static BufferedImage[] enemyGreen, enemyRed, dot, bitDot;




    private BufferedImage TextureGrid;

    public Animation() {
        try {


            File filePlayer = new File("kodilla-pacmanv2\\src\\main\\resources\\assets\\textures\\grid.png");


            TextureGrid = ImageIO.read(filePlayer);


        } catch (IOException e) {
            System.out.print("ERORO");
            e.printStackTrace();
        }

        player = new BufferedImage[4][4];


        //right position animation
        player[0][0] = getPartOfImage(0,0);
        player[0][1] = getPartOfImage(32,0);
        player[0][2] = getPartOfImage(64,0);
        player[0][3] = getPartOfImage(96,0);
        // left position animation
        player[1][0] = getPartOfImage(0,32);
        player[1][1] = getPartOfImage(32,32);
        player[1][2] = getPartOfImage(64,32);
        player[1][3] = getPartOfImage(96,32);
        // up position animation
        player[2][0] = getPartOfImage(0,64);
        player[2][1] = getPartOfImage(32,64);
        player[2][2] = getPartOfImage(64,64);
        player[2][3] = getPartOfImage(96,64);
        // down position animation
        player[3][0] = getPartOfImage(0,96);
        player[3][1] = getPartOfImage(32,96);
        player[3][2] = getPartOfImage(64,96);
        player[3][3] = getPartOfImage(96,96);


        enemyGreen = new BufferedImage[4];

        // down position animation
        enemyGreen[0] = getPartOfImage(0,128);
        // left position animation
        enemyGreen[1] = getPartOfImage(32,128);
        // up position animation
        enemyGreen[2] = getPartOfImage(64,128);
        // right position animation
        enemyGreen[3] = getPartOfImage(96,128);

        enemyRed = new BufferedImage[4];

        enemyRed[0] = getPartOfImage(0,160);
        // left position animation
        enemyRed[1] = getPartOfImage(32,160);
        // up position animation
        enemyRed[2] = getPartOfImage(64,160);
        // right position animation
        enemyRed[3] = getPartOfImage(96,160);

        dot = new BufferedImage[1];
        dot[0] = getPartOfImage(0,256);

        bitDot = new BufferedImage[1];
        bitDot[0] = getPartOfImage(32,256);

    }

    public BufferedImage getPartOfImage(int xx, int yy) {
        return TextureGrid.getSubimage(xx,yy,32,32);
    }



}
