package com.kodilla.pacmanV2;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class TextureGrid {

    public static BufferedImage[][] player;
    public static BufferedImage[][] map;

    private BufferedImage playerGrid, mapGrid;

    public TextureGrid(String path) {
        try {
            File filePlayer = new File("kodilla-pacmanv2\\src\\main\\resources\\assets\\textures\\grid.png");
            File fileMapGrid = new File("kodilla-pacmanv2\\src\\main\\resources\\assets\\textures\\mapGrid.png");
            playerGrid = ImageIO.read(filePlayer);
            mapGrid = ImageIO.read(fileMapGrid);
        } catch (IOException e) {
            System.out.print("ERORO");
            e.printStackTrace();
        }

        map = new BufferedImage[12][12];
        map[0][0] = getPartOfImageMap(0,0);
        map[0][1] = getPartOfImageMap(40,0);
        map[0][2] = getPartOfImageMap(80,0);
        map[0][3] = getPartOfImageMap(120,0);
        map[0][4] = getPartOfImageMap(160,0);
        map[0][5] = getPartOfImageMap(200,0);

        map[1][1] = getPartOfImageMap(40,40);
        map[1][2] = getPartOfImageMap(80,40);
        map[1][3] = getPartOfImageMap(120,40);
        map[1][5] = getPartOfImageMap(200,40);
        map[1][6] = getPartOfImageMap(240,40);
        map[1][7] = getPartOfImageMap(280,40);


        map[2][2] = getPartOfImageMap(80,80);
        map[2][5] = getPartOfImageMap(200,80);
        map[2][6] = getPartOfImageMap(240,80);
        map[2][7] = getPartOfImageMap(280,80);

        map[3][1] = getPartOfImageMap(40,120);
        map[3][2] = getPartOfImageMap(80,120);
        map[3][3] = getPartOfImageMap(120,120);
        map[3][5] = getPartOfImageMap(200,120);
        map[3][6] = getPartOfImageMap(240,120);
        map[3][7] = getPartOfImageMap(280,120);

        map[4][0] = getPartOfImageMap(0,160);
        map[4][1] = getPartOfImageMap(40,160);
        map[4][2] = getPartOfImageMap(80,160);
        map[4][3] = getPartOfImageMap(120,160);
        map[4][4] = getPartOfImageMap(160,160);
        map[4][5] = getPartOfImageMap(200,160);
        map[4][6] = getPartOfImageMap(240,160);
        map[4][7] = getPartOfImageMap(280,160);


        map[5][1] = getPartOfImageMap(40,200);
        map[5][2] = getPartOfImageMap(80,200);
        map[5][3] = getPartOfImageMap(120,200);

        map[6][2] = getPartOfImageMap(80,240);


        player = new BufferedImage[4][4];

        //right position
        player[0][0] = getPartOfImagePlayer(0,0);
        player[0][1] = getPartOfImagePlayer(32,0);
        player[0][2] = getPartOfImagePlayer(64,0);
        player[0][3] = getPartOfImagePlayer(96,0);
        // left position
        player[1][0] = getPartOfImagePlayer(0,32);
        player[1][1] = getPartOfImagePlayer(32,32);
        player[1][2] = getPartOfImagePlayer(64,32);
        player[1][3] = getPartOfImagePlayer(96,32);
        // up position
        player[2][0] = getPartOfImagePlayer(0,64);
        player[2][1] = getPartOfImagePlayer(32,64);
        player[2][2] = getPartOfImagePlayer(64,64);
        player[2][3] = getPartOfImagePlayer(96,64);
        // down position
        player[3][0] = getPartOfImagePlayer(0,96);
        player[3][1] = getPartOfImagePlayer(32,96);
        player[3][2] = getPartOfImagePlayer(64,96);
        player[3][3] = getPartOfImagePlayer(96,96);

    }

    public BufferedImage getPartOfImagePlayer(int xx, int yy) {
        return playerGrid.getSubimage(xx,yy,32,32);
    }
    public BufferedImage getPartOfImageMap(int xx, int yy) {
        return mapGrid.getSubimage(xx,yy,40,40);
    }
}
