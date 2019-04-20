package com.kodilla.pacmanV2.items;

import com.kodilla.pacmanV2.Animation;
import com.kodilla.pacmanV2.PacmanAppRunner;
import com.kodilla.pacmanV2.pacmanBoard.BonusMode;
import com.kodilla.pacmanV2.pacmanBoard.LevelFactory;
import com.kodilla.pacmanV2.pacmanBoard.RowOfBoard;

import java.awt.*;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

import static com.kodilla.pacmanV2.pacmanBoard.LevelFactory.board;
    public class Player extends Rectangle {

    public static boolean right,left,up,down, isAlive;
    int animationY,animationX,TimeAnimationEnd=0;
    BonusMode bonusMode = new BonusMode();

        public static void setXx(int xx) {
            Player.xx = xx;
        }

        public static void setYy(int yy) {
            Player.yy = yy;
        }

        static int xx, yy;


    private int speed =4;


    public  Player(int x, int y){
        setBounds(x,y, PacmanAppRunner.TILE_SIZE,PacmanAppRunner.TILE_SIZE);
    }

        public static void setX(int playerStartingX) {
        }


        public  void tick() {
        xx =x;
        yy =y;
        bonusMode.checkIfBonusIsOn();
        if(right&&!isColission(x+speed,y)) {
            ifIntersectWithDotThenRemoveDotAndAddPoints(x+speed,y);

            // teleportation
            if(x==1480 && y==400)
                x=0;

            x+=speed;
            animationX =0;

        }

        if(left && !isColission(x-speed,y)) {
            ifIntersectWithDotThenRemoveDotAndAddPoints(x-speed,y);
            // teleportation
            if(x==0 && y==400)
                x=1480;

             x-=speed;

            animationX =1;
        }
        if(up  && !isColission(x,y-speed)) {
            ifIntersectWithDotThenRemoveDotAndAddPoints(x,y-speed);
            y-=speed;

            animationX =2;
        }
        if(down  && !isColission(x,y+speed)){
            ifIntersectWithDotThenRemoveDotAndAddPoints(x,y+speed);
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

    private boolean isColission (int  x, int y){
        Rectangle rectangle = new Rectangle(x,y,PacmanAppRunner.TILE_SIZE,PacmanAppRunner.TILE_SIZE);
        LevelFactory level = PacmanAppRunner.level;
        List<Items> listOfCollisingTile = board.getBoardOfRows().stream()
                .flatMap(row -> row.getItemList().stream())
                .filter(t -> (t instanceof Wall &&(rectangle.intersects((Wall)t))))
                .collect(Collectors.toList());

        int numberOfCollision = listOfCollisingTile.size();
        if (numberOfCollision >0) {
            return true;
        } else {
            return false;
        }
    }
    public void ifIntersectWithDotThenRemoveDotAndAddPoints(int  x, int y) {
        Rectangle rectangle = new Rectangle(x, y, PacmanAppRunner.TILE_SIZE, PacmanAppRunner.TILE_SIZE);
        LevelFactory level = PacmanAppRunner.level;
        LinkedList<RowOfBoard> boardRows = board.getBoardOfRows();


        for (int i = 0; i < boardRows.size(); i++) {
            for (int j = 0; j < board.getBoardOfRows().get(i).getItemList().size(); j++) {
                if (board.getBoardOfRows().get(i).getItemList().get(j) instanceof Dot) {
                    if (rectangle.intersects((Dot) board.getBoardOfRows().get(i).getItemList().get(j))) {
                        board.getBoardOfRows().get(i).getItemList().set(j, null);
                        PacmanAppRunner.score.addPointForSmallDot();




                    }
                }
                if (board.getBoardOfRows().get(i).getItemList().get(j) instanceof BigDot) {
                    if (rectangle.intersects((BigDot) board.getBoardOfRows().get(i).getItemList().get(j))) {
                        board.getBoardOfRows().get(i).getItemList().set(j, null);
                        PacmanAppRunner.score.addPointForBigDot();
                        bonusMode.startBonus();



                    }
                }
            }
        }
    }


    public void paintComponent(Graphics g ) {
       g.drawImage(Animation.player[animationX][animationY],x,y,32,32,null);


    }
}
