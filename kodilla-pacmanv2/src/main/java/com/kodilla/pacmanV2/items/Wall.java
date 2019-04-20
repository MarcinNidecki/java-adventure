package com.kodilla.pacmanV2.items;

import java.awt.*;

public class Wall extends Rectangle implements Items  {



    public Wall(int x, int y) {
        setBounds(x,y,40,40);
    }

    public void render(Graphics g) {
        g.drawOval(x,x,40,40);
        //g.drawImage(Animation.map[0][1],x,y,40,40,null);
    }

    @Override
    public String toString() {
        return "" + x + y;
    }
}
