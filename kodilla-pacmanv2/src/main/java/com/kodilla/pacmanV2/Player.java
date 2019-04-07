package com.kodilla.pacmanV2;

import java.awt.*;

public class Player extends Rectangle {

    public boolean right,left,up,down;
    int xx,yy,animationY,animationX,TimeAnimationEnd=0;
    private int speed =4;


    public  Player(int x, int y){
        setBounds(x,y,PacmanAppRunner.TILE_SIZE,PacmanAppRunner.TILE_SIZE);
    }


    public  void tick() {





        if(right&&!isColission(x+speed,y)) {
           x+=speed;
          animationX =0;
        }

        if(left && !isColission(x-speed,y)) {
             x-=speed;
            animationX =1;
        }
        if(up  && !isColission(x,y-speed)) {
            y-=speed;
            animationX =2;
        }
        if(down  && !isColission(x,y+speed)){
            y+=speed;
            animationX =3;
        }

        if (TimeAnimationEnd == 0) {
            animationY =0;
        } else if (TimeAnimationEnd == 10){
            animationY =1;
        }else if (TimeAnimationEnd == 20){
            animationY =2;
        }else if (TimeAnimationEnd == 30){
            animationY =3;
        }
        if (TimeAnimationEnd == 40) {
            TimeAnimationEnd =0;
        }
       TimeAnimationEnd ++;
    }

    public boolean isColission (int  x, int y){
        Rectangle rectangle = new Rectangle(x,y,PacmanAppRunner.TILE_SIZE-1,PacmanAppRunner.TILE_SIZE-1);
        Level level = PacmanAppRunner.level;

        for (int i=0; i < level.tiles.length; i++) {
            for (int j=0; j < level.tiles[0].length; j++) {
                if (level.tiles[i][j] !=null) {
                    if (rectangle.intersects(level.tiles[i][j])) {
                        return true;
                    }

                }
            }
        }
        return false;
    }


    public void paintComponent(Graphics g ) {
       g.drawImage(TextureGrid.player[animationX][animationY],x,y,32,32,null);


    }
}
