package com.kodilla.pacmanV2.items;

import com.kodilla.pacmanV2.Animation;
import com.kodilla.pacmanV2.PacmanAppRunner;
import com.kodilla.pacmanV2.pacmanBoard.LevelFactory;

import java.awt.*;
import java.util.List;
import java.util.stream.Collectors;

import static com.kodilla.pacmanV2.pacmanBoard.LevelFactory.board;

public class Enemy extends Rectangle {


    private final EnemyControl enemyControl = new EnemyControl(this);
    public boolean up, brave, changeOfDirection;
    private int tick = 0, xx, yy, animationPicture;
    public int speed = 2;

    Directions directions = Directions.DOWN;
    private int TimeAnimationEnd =0;

    public int getSpeed() {
        return speed;
    }


    public enum Directions {
        DOWN,
        UP,
        LEFT,
        RIGHT
    }


    public Enemy(int x, int y, boolean brave) {
        this.brave = brave;
        setBounds(x, y, PacmanAppRunner.TILE_SIZE, PacmanAppRunner.TILE_SIZE);
    }




    public void EnemyTick() {

    // TURN ON animation enemy when bonus ON
        if (PacmanAppRunner.bonus) {
            animationPicture=2;
        } else {
            animationPicture =0;
        }





        enemyControl.checkIfIntersectWithPlayer(x,y);
        enemyControl.checkIfNeedToUseATeleport();

        if (enemyControl.checkIfIsInHome()) {
            LevelFactory.openDoor();
            enemyControl.goOutside();
        }
        if (!enemyControl.checkIfIsInHome()) {
            LevelFactory.closeDoor();
        }



        switch (directions) {
            case DOWN:

                if (enemyControl.ThereIsNoCollisionOnDown()) {
                    if(enemyControl.TrackPlayerAndCheckIfIsBetterToChangeDirection()) {
                        enemyControl.TrackPlayerAndCheckIfIsBetterToChangeDirection();
                        break;
                    }
                    enemyControl.goDown();
                    tick++;

                    break;
                } else {
                    enemyControl.changeDirection();
                    tick = 0;
                    break;
                }
            case UP:

                if (enemyControl.ThereIsNoCollisionOnUp()) {
                    if(enemyControl.TrackPlayerAndCheckIfIsBetterToChangeDirection()) {
                        enemyControl.TrackPlayerAndCheckIfIsBetterToChangeDirection();
                        break;
                    }
                    enemyControl.goUp();
                    tick++;
                    break;
                } else {
                    enemyControl.changeDirection();
                    tick = 0;
                    break;
                }
            case LEFT:

                if (enemyControl.ThereIsNoCollisionOnLeft()) {
                    if(enemyControl.TrackPlayerAndCheckIfIsBetterToChangeDirection()) {
                        enemyControl.TrackPlayerAndCheckIfIsBetterToChangeDirection();
                        break;
                    }
                    enemyControl.goLeft();
                    tick++;

                    break;
                } else {
                    enemyControl.changeDirection();
                    tick = 0;
                    break;
                }
            case RIGHT:
                if (enemyControl.ThereIsNoCollisionOnRight()) {
                    if(enemyControl.TrackPlayerAndCheckIfIsBetterToChangeDirection()) {
                        enemyControl.TrackPlayerAndCheckIfIsBetterToChangeDirection();
                        break;
                    }
                    enemyControl.goRight();
                    tick++;

                    break;
                } else {
                    enemyControl.changeDirection();
                    tick = 0;
                    break;
                }
            default:
                directions = Directions.DOWN;
                break;
        }

    }


    public boolean isColission(int x, int y) {
        Rectangle rectangle = new Rectangle(x, y, PacmanAppRunner.TILE_SIZE, PacmanAppRunner.TILE_SIZE);
        LevelFactory level = PacmanAppRunner.level;
        List<Items> listOfCollisingTile = board.getBoardOfRows().stream()
                .flatMap(row -> row.getItemList().stream())
                .filter(t -> (t instanceof Wall && (rectangle.intersects((Wall) t))))
                .collect(Collectors.toList());

        int numberOfCollision = listOfCollisingTile.size();
        if (numberOfCollision > 0) {
            return true;
        } else {
            return false;
        }
    }

    public void paintComponent(Graphics g) {
        g.drawImage(Animation.enemyGreen[animationPicture], x, y, 32, 32, null);


    }

    public void paintComponentRed(Graphics g) {
        g.drawImage(Animation.enemyRed[animationPicture], x, y, 32, 32, null);


    }
}
