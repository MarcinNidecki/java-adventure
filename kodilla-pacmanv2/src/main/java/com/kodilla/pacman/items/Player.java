package com.kodilla.pacman.items;

import com.kodilla.pacman.GameInit;
import com.kodilla.pacman.pacmanBoard.BonusMode;

import java.awt.*;

import static com.kodilla.pacman.pacmanBoard.levelFactory.LevelFactory.maze;

public class Player extends Rectangle {

    private static boolean isAlive;
    private final WallCollision wallCollision = new WallCollision();
    private int animationPicture, playerImagePossition, TimeAnimation = 0;
    private int startingLocationX, startingLocationY;
    private BonusMode bonusMode = new BonusMode();
    private int speed = 4;
    private String mainDirection = "STOP", nextDirection = "STOP";
    private boolean HitByEnemy = false;


    public Player(int x, int y) {
        startingLocationY = y;
        startingLocationX = x;
        setBounds(x, y, GameInit.TILE_SIZE, GameInit.TILE_SIZE);
    }


    public void tick() {

        bonusMode.checkIfBonusIsOn();

        switch (mainDirection) {
            case "RIGHT": {
                if (isInTheMiddleOfTile(x) && checkIfIsNextDirectionTenChangeDirection()) {
                    checkIfIsNextDirectionTenChangeDirection();
                    break;
                }

                if (mainDirection.equals("RIGHT") && wallCollision.thereIsNoCollisionOnRight(x, y)) {
                    ifIntersectWithDotThenRemoveDotAndAddPoints(x + speed, y);
                    checkIfPlayerIsInTeleport();
                    goRight();
                    playerImagePossition = 0;
                    break;

                } else {
                    setMainDirection("STOP");
                    playerImagePossition = 0;

                    break;
                }
            }
            case "LEFT": {
                if (isInTheMiddleOfTile(x) && checkIfIsNextDirectionTenChangeDirection()) {
                    checkIfIsNextDirectionTenChangeDirection();
                    break;
                }

                if (mainDirection.equals("LEFT") && wallCollision.thereIsNoCollisionOnLeft(x, y)) {
                    ifIntersectWithDotThenRemoveDotAndAddPoints(x - speed, y);
                    checkIfPlayerIsInTeleport();
                    goLeft();
                    playerImagePossition = 1;
                    break;
                } else {
                    setMainDirection("STOP");
                    playerImagePossition = 1;
                    break;
                }
            }
            case "UP": {
                if (isInTheMiddleOfTile(y) && checkIfIsNextDirectionTenChangeDirection()) {
                    checkIfIsNextDirectionTenChangeDirection();
                    break;
                }
                if (mainDirection.equals("UP") && wallCollision.thereIsNoCollisionOnUp(x, y)) {
                    ifIntersectWithDotThenRemoveDotAndAddPoints(x, y - speed);
                    goUp();
                    playerImagePossition = 2;
                    break;
                } else {
                    setMainDirection("STOP");
                    playerImagePossition = 2;

                    break;
                }
            }
            case "DOWN": {
                if (isInTheMiddleOfTile(y) && checkIfIsNextDirectionTenChangeDirection()) {
                    checkIfIsNextDirectionTenChangeDirection();
                    break;
                }

                if (mainDirection.equals("DOWN") && wallCollision.thereIsNoCollisionOnDown(x, y)) {
                    ifIntersectWithDotThenRemoveDotAndAddPoints(x, y + speed);
                    goDown();
                    playerImagePossition = 3;
                    break;
                } else {
                    setMainDirection("STOP");
                    playerImagePossition = 3;
                    break;
                }
            }

            default:
                break;

        }


        playerAnimation();
    }

    private void checkIfPlayerIsInTeleport() {
        if (x == 1480 && y == 400) {
            x = 0;
        } else if (x == 0 && y == 400) {
            x = 1480;
        }
    }

    private boolean isInTheMiddleOfTile(int y) {
        return y % GameInit.TILE_SIZE == 0;
    }

    private void playerAnimation() {

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

    private boolean checkIfIsNextDirectionTenChangeDirection() {
        boolean isNextDirection = false;
        switch (nextDirection) {
            case "UP":
                if (wallCollision.thereIsNoCollisionOnUp(x, y)) {

                    mainDirection = "UP";
                    goUp();
                    nextDirection = "STOP";
                    playerImagePossition = 2;
                    isNextDirection = true;
                    break;
                }
                break;
            case "DOWN":
                if (wallCollision.thereIsNoCollisionOnDown(x, y)) {

                    mainDirection = "DOWN";
                    goDown();
                    nextDirection = "STOP";
                    playerImagePossition = 3;
                    isNextDirection = true;
                    break;

                }
                break;

            case "LEFT":
                if (wallCollision.thereIsNoCollisionOnLeft(x, y)) {
                    mainDirection = "LEFT";
                    goLeft();
                    nextDirection = "STOP";
                    playerImagePossition = 1;
                    isNextDirection = true;
                    break;
                }
                break;

            case "RIGHT":
                if (wallCollision.thereIsNoCollisionOnRight(x, y)) {
                    mainDirection = "RIGHT";
                    goRight();
                    nextDirection = "STOP";
                    isNextDirection = true;
                    playerImagePossition = 0;
                    break;
                }
                break;

            default:
                isNextDirection = false;

        }
        return isNextDirection;

    }


    private void ifIntersectWithDotThenRemoveDotAndAddPoints(int x, int y) {


        Rectangle rectangle = new Rectangle(x, y, GameInit.TILE_SIZE, GameInit.TILE_SIZE);
        int lineNumber = y / GameInit.TILE_SIZE;

        int minLineNumber, maxLinenumber;
        maxLinenumber = lineNumber + 1;
        if (lineNumber <= 0) {
            minLineNumber = 0;
        } else minLineNumber = lineNumber - 1;


        for (lineNumber = minLineNumber; lineNumber < maxLinenumber; lineNumber++) {
            for (int itemNumber = 0; itemNumber < maze.getMaze().get(lineNumber).getLineOfItems().size(); itemNumber++) {
                if (maze.getMaze().get(lineNumber).getLineOfItems().get(itemNumber) instanceof Dot) {
                    if (rectangle.intersects((Dot) maze.getMaze().get(lineNumber).getLineOfItems().get(itemNumber))) {
                        maze.getMaze().get(lineNumber).getLineOfItems().replace(itemNumber, new Empty(x, y));
                        GameInit.getScore().addPointForSmallDot();
                    }
                }
                if (maze.getMaze().get(lineNumber).getLineOfItems().get(itemNumber) instanceof BigDot) {
                    if (rectangle.intersects((BigDot) maze.getMaze().get(lineNumber).getLineOfItems().get(itemNumber))) {
                        maze.getMaze().get(lineNumber).getLineOfItems().replace(itemNumber, new Empty(x, y));
                        GameInit.getScore().addPointForBigDot();
                        bonusMode.startBonus();

                    }
                }
            }
        }
    }

    private void goDown() {
        y += speed;
    }

    private void goUp() {
        y -= speed;
    }

    private void goLeft() {
        x -= speed;
    }

    private void goRight() {
        x += speed;
    }

    public String getMainDirection() {
        return mainDirection;
    }

    public void setMainDirection(String mainDirection) {
        this.mainDirection = mainDirection;
    }

    public void setNextDirection(String nextDirection) {
        this.nextDirection = nextDirection;
    }

    public boolean isHitByEnemy() {
        return HitByEnemy;
    }

    public void setHitByEnemy(boolean hitByEnemy) {
        HitByEnemy = hitByEnemy;
    }

    public void repaint(Graphics g) {
        g.drawImage(ItemPictures.player[playerImagePossition][animationPicture], x, y, 32, 32, null);

    }

    public void sendPlayerToStart() {
        x = startingLocationX;
        y = startingLocationY;
    }

}
