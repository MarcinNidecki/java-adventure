package com.kodilla.pacmanV2;

import java.awt.*;

import static com.kodilla.pacmanV2.Level.mapTextureX;
import static com.kodilla.pacmanV2.Level.mapTextureY;

public class Tile extends Rectangle {



    public Tile(int x, int y) {
        setBounds(x,y,40,40);
    }

    public void render(Graphics g) {
        g.drawImage(TextureGrid.map[mapTextureX][mapTextureY],x,y,40,40,null);
    }
}
