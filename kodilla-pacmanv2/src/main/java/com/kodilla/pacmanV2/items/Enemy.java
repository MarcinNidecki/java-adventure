package com.kodilla.pacmanV2.items;

import com.kodilla.pacmanV2.GameInit;
import com.kodilla.pacmanV2.pacmanBoard.levelFactory.LevelFactory;

import java.awt.*;

public class Enemy extends Rectangle {

    private final EnemyControl enemyControl = new EnemyControl(this, GameInit.getPlayer());
    private final WallCollision wallCollision = new WallCollision();
    private int startingLocationX, startingLocationY, tick = 0, animationPicture;
    private boolean brave;
    private boolean changeOfDirection;
    private boolean itsEye = false;
    private String colour;
    private Directions direction = Directions.DOWN;

    public Enemy(int x, int y, boolean brave, String colour) {
        this.brave = brave;
        this.colour = colour;
        startingLocationY = y;
        startingLocationX = x;
        setBounds(x, y, GameInit.TILE_SIZE, GameInit.TILE_SIZE);
    }

    public void enemyTick() {

        // TURN ON animation enemy when bonus ON
        if (GameInit.bonus) {
            animationPicture = 1;
        } else {
            animationPicture = 0;
        }

        enemyControl.checkIfIntersectWithPlayer(x, y);
        enemyControl.checkIfNeedToUseATeleport();

        if (enemyControl.checkIfIsInHome()) {
            LevelFactory.openDoor();
            if (colour.equals("RED") || colour.equals("BLUE")) {
                itsEye = false;
                waitThenGoOutside(6);
            } else {
                waitThenGoOutside(12);
                itsEye = false;
            }

        } else {
            LevelFactory.closeDoor();
        }

        goToHomeWhenIsEye();

        switch (direction) {
            case DOWN:

                if (wallCollision.thereIsNoCollisionOnDown(x, y)) {
                    if (enemyControl.trackPlayerAndCheckIfIsBetterToChangeDirectionThenChangeDirection()) {
                        enemyControl.trackPlayerAndCheckIfIsBetterToChangeDirectionThenChangeDirection();
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

                if (wallCollision.thereIsNoCollisionOnUp(x, y)) {
                    if (enemyControl.trackPlayerAndCheckIfIsBetterToChangeDirectionThenChangeDirection()) {
                        enemyControl.trackPlayerAndCheckIfIsBetterToChangeDirectionThenChangeDirection();
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

                if (wallCollision.thereIsNoCollisionOnLeft(x, y)) {
                    if (enemyControl.trackPlayerAndCheckIfIsBetterToChangeDirectionThenChangeDirection()) {
                        enemyControl.trackPlayerAndCheckIfIsBetterToChangeDirectionThenChangeDirection();
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
                if (wallCollision.thereIsNoCollisionOnRight(x, y)) {
                    if (enemyControl.trackPlayerAndCheckIfIsBetterToChangeDirectionThenChangeDirection()) {
                        enemyControl.trackPlayerAndCheckIfIsBetterToChangeDirectionThenChangeDirection();
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
                direction = Directions.DOWN;
                break;
        }

    }

    private void goToHomeWhenIsEye() {

        if (itsEye) {
            if (x > 600 && x < 880 && y > 320 && y < 440) {
                x = startingLocationX;
                y = startingLocationY;
            }
            direction = Directions.STOP;
            animationPicture = 2;
            if (y > startingLocationY) {
                enemyControl.goUp();
            } else if (y < startingLocationY) {
                enemyControl.goDown();
            }
            if (x > startingLocationX) {
                enemyControl.goLeft();
            } else if (x < startingLocationX) {
                enemyControl.goRight();
            }
        }
    }

    public void waitThenGoOutside(int timeInSeconds) {
        double time = timeInSeconds * GameInit.targetTick;
        if (wallCollision.thereIsNoCollisionOnUp(x, y)) {
            // when fps is set to 60  then 1 second is 60 ticks
            setDirections(Enemy.Directions.STOP);
            if (tick > time) {
                setDirections(Directions.UP);
                enemyControl.goUp();

            }
            tick++;
        }
    }

    boolean isBrave() {
        return brave;
    }

    public boolean isItsEye() {
        return itsEye;
    }

    public void setItsEye(boolean itsEye) {
        this.itsEye = itsEye;
    }

    boolean isChangeOfDirection() {
        return changeOfDirection;
    }

    void setChangeOfDirection(boolean changeOfDirection) {
        this.changeOfDirection = changeOfDirection;
    }

    Directions getDirection() {
        return direction;
    }

    void setDirections(Directions direction) {
        this.direction = direction;
    }

    public int getStartingLocationX() {
        return startingLocationX;
    }

    public int getStartingLocationY() {
        return startingLocationY;
    }

    public void paintEnemyBlue(Graphics g) {
        g.drawImage(ItemPictures.enemyBlue[animationPicture], x, y, 32, 32, null);
    }

    public void paintEnemyRed(Graphics g) {
        g.drawImage(ItemPictures.enemyRed[animationPicture], x, y, 32, 32, null);
    }

    public void paintEnemyPurple(Graphics g) {
        g.drawImage(ItemPictures.enemyPurple[animationPicture], x, y, 32, 32, null);
    }

    public void paintEnemyGreen(Graphics g) {
        g.drawImage(ItemPictures.enemyGreen[animationPicture], x, y, 32, 32, null);
    }

    enum Directions {
        DOWN,
        UP,
        LEFT,
        RIGHT,
        STOP
    }
}
