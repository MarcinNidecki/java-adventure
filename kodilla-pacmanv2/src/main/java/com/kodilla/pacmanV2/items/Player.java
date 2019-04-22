package com.kodilla.pacmanV2.items;

import com.kodilla.pacmanV2.Animation;
import com.kodilla.pacmanV2.PacmanAppRunner;
import com.kodilla.pacmanV2.pacmanBoard.BonusMode;
import com.kodilla.pacmanV2.pacmanBoard.levelFactory.LineOfMaze;

import java.awt.*;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

import static com.kodilla.pacmanV2.pacmanBoard.levelFactory.LevelFactory.maze;

public class Player extends Rectangle {

    public static boolean right, left, up, down, isAlive, hitTheGhost;
    static int xx, yy, numberOfGhostSendedToHome=0;
    private int animationPicture, animationX, TimeAnimation = 0;
    private BonusMode bonusMode = new BonusMode();
    private int speed = 4;

    public Player(int x, int y) {
        setBounds(x, y, PacmanAppRunner.TILE_SIZE, PacmanAppRunner.TILE_SIZE);
    }


    void backToStart() {
        x = 40;
        y = 40;
    }


    public void tick() {
        xx = x;
        yy = y;
        bonusMode.checkIfBonusIsOn();
        if (right && isColission(x + speed, y)) {
            ifIntersectWithDotThenRemoveDotAndAddPoints(x + speed, y);

            // teleportation
            if (x == 1480 && y == 400)
                x = 0;

            x += speed;
            animationX = 0;

        }

        if (left && isColission(x - speed, y)) {
            ifIntersectWithDotThenRemoveDotAndAddPoints(x - speed, y);
            // teleportation
            if (x == 0 && y == 400)
                x = 1480;

            x -= speed;

            animationX = 1;
        }
        if (up && isColission(x, y - speed)) {
            ifIntersectWithDotThenRemoveDotAndAddPoints(x, y - speed);
            y -= speed;

            animationX = 2;
        }
        if (down && isColission(x, y + speed)) {
            ifIntersectWithDotThenRemoveDotAndAddPoints(x, y + speed);
            y += speed;

            animationX = 3;
        }


        //  animation of player - change picture of player after every 10 tick
        if (TimeAnimation == 0) {
            animationPicture = 0;
        } else if (TimeAnimation == 10) {
            animationPicture = 1;
        } else if (TimeAnimation == 20) {
            animationPicture = 2;
        } else if (TimeAnimation == 30) {
            animationPicture = 3;
        }
        if (TimeAnimation == 40) {
            TimeAnimation = 0;
        }
        TimeAnimation++;
    }

    private boolean isColission(int x, int y) {
        Rectangle rectangle = new Rectangle(x, y, PacmanAppRunner.TILE_SIZE, PacmanAppRunner.TILE_SIZE);
        List<Items> listOfCollisingTile = maze.getMaze().parallelStream()
                .flatMap(line -> line.getLineOfItems().stream())
                .filter(items -> (items instanceof Wall && (rectangle.intersects((Wall) items))))
                .collect(Collectors.toList());

        int numberOfCollision = listOfCollisingTile.size();
        return numberOfCollision <= 0;
    }

    public void ifIntersectWithDotThenRemoveDotAndAddPoints(int x, int y) {


        Rectangle rectangle = new Rectangle(x, y, PacmanAppRunner.TILE_SIZE, PacmanAppRunner.TILE_SIZE);
        LinkedList<LineOfMaze> lineOfMazes = maze.getMaze();
        int lineNumber = y/PacmanAppRunner.TILE_SIZE;

        int minLineNumber, maxLinenumber;
        maxLinenumber = lineNumber +1;
        if (lineNumber<=0) {
            minLineNumber = 0;
        } else minLineNumber = lineNumber-1;


        for (lineNumber=minLineNumber; lineNumber < maxLinenumber; lineNumber++) {
            for (int itemNumber = 0; itemNumber < maze.getMaze().get(lineNumber).getLineOfItems().size(); itemNumber++) {
                if (maze.getMaze().get(lineNumber).getLineOfItems().get(itemNumber) instanceof Dot) {
                    if (rectangle.intersects((Dot) maze.getMaze().get(lineNumber).getLineOfItems().get(itemNumber))) {
                        maze.getMaze().get(lineNumber).getLineOfItems().set(itemNumber, null);
                        PacmanAppRunner.score.addPointForSmallDot();
                    }
                }
                if (maze.getMaze().get(lineNumber).getLineOfItems().get(itemNumber) instanceof BigDot) {
                    if (rectangle.intersects((BigDot) maze.getMaze().get(lineNumber).getLineOfItems().get(itemNumber))) {
                        maze.getMaze().get(lineNumber).getLineOfItems().set(itemNumber, null);
                        PacmanAppRunner.score.addPointForBigDot();
                        bonusMode.startBonus();

                    }
                }
            }
        }
    }


    public void paintComponent(Graphics g) {
        g.drawImage(Animation.player[animationX][animationPicture], x, y, 32, 32, null);


    }
}
