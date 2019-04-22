package com.kodilla.pacmanV2.items;

import com.kodilla.pacmanV2.Animation;
import com.kodilla.pacmanV2.PacmanAppRunner;
import com.kodilla.pacmanV2.pacmanBoard.levelFactory.LevelFactory;

import java.awt.*;
import java.util.List;
import java.util.stream.Collectors;

import static com.kodilla.pacmanV2.pacmanBoard.levelFactory.LevelFactory.maze;

public class Enemy extends Rectangle {


    private final EnemyControl enemyControl = new EnemyControl(this);
    boolean brave, changeOfDirection;
    int speed = 4;
    Directions directions = Directions.DOWN;
    private int tick = 0, animationPicture;


    public enum Directions {
        DOWN,
        UP,
        LEFT,
        RIGHT,
        STOP
    }

    public Enemy(int x, int y, boolean brave) {
        this.brave = brave;
        setBounds(x, y, PacmanAppRunner.TILE_SIZE, PacmanAppRunner.TILE_SIZE);
    }

    public void EnemyTick() {

        // TURN ON animation enemy when bonus ON
        if (PacmanAppRunner.bonus) {
            animationPicture = 2;
        } else {
            animationPicture = 0;
        }

        enemyControl.checkIfIntersectWithPlayer(x, y);
        enemyControl.checkIfNeedToUseATeleport();

        if (enemyControl.checkIfIsInHome()) {
            LevelFactory.openDoor();
            enemyControl.goOutsideHome();
        } else {
            LevelFactory.closeDoor();
        }



        switch (directions) {
            case DOWN:

                if (enemyControl.ThereIsNoCollisionOnDown()) {
                    if (enemyControl.TrackPlayerAndCheckIfIsBetterToChangeDirectionThenChangeDirection()) {
                        enemyControl.TrackPlayerAndCheckIfIsBetterToChangeDirectionThenChangeDirection();
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
                    if (enemyControl.TrackPlayerAndCheckIfIsBetterToChangeDirectionThenChangeDirection()) {
                        enemyControl.TrackPlayerAndCheckIfIsBetterToChangeDirectionThenChangeDirection();
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
                    if (enemyControl.TrackPlayerAndCheckIfIsBetterToChangeDirectionThenChangeDirection()) {
                        enemyControl.TrackPlayerAndCheckIfIsBetterToChangeDirectionThenChangeDirection();
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
                    if (enemyControl.TrackPlayerAndCheckIfIsBetterToChangeDirectionThenChangeDirection()) {
                        enemyControl.TrackPlayerAndCheckIfIsBetterToChangeDirectionThenChangeDirection();
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

    public boolean isCollision(int x, int y) {
        Rectangle rectangle = new Rectangle(x, y, PacmanAppRunner.TILE_SIZE, PacmanAppRunner.TILE_SIZE);
        LevelFactory level = PacmanAppRunner.level;
        List<Items> listOfCollidingTile = maze.getMaze().parallelStream()
                .flatMap(row -> row.getLineOfItems().stream())
                .filter(t -> (t instanceof Wall && (rectangle.intersects((Wall) t))))
                .collect(Collectors.toList());

        int numberOfCollision = listOfCollidingTile.size();
        return numberOfCollision <= 0;
    }

    public void paintComponent(Graphics g) {
        g.drawImage(Animation.enemyGreen[animationPicture], x, y, 32, 32, null);


    }

    public void paintComponentRed(Graphics g) {
        g.drawImage(Animation.enemyRed[animationPicture], x, y, 32, 32, null);


    }

}
