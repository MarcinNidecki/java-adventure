package com.kodilla.pacmanV2.items;

import com.kodilla.pacmanV2.PacmanAppRunner;

import java.awt.*;

public class EnemyControl {
    private final Enemy enemy;

    public EnemyControl(Enemy enemy) {
        this.enemy = enemy;
    }

    boolean ThereIsNoCollisionOnUp() {
        if (enemy.isColission(enemy.x, enemy.y - enemy.getSpeed())) {
            return false;
        } else return true;
    }

    void goDown() {
        enemy.setLocation(enemy.x,(enemy.y + enemy.getSpeed()));
    }

    void checkIfNeedToUseATeleport() {
        if(enemy.x==1480 && enemy.y==400) {
            enemy.x=0;
            goRight();
            goRight();
        }

        if(enemy.x==0 && enemy.y==400) {
            enemy.x = 1480;
            goLeft();
            goLeft();
        }

    }

    boolean ThereIsNoCollisionOnLeft() {
        if (enemy.isColission(enemy.x - enemy.speed, enemy.y)) {
            return false;
        } else return true;
    }

    boolean ThereIsNoCollisionOnRight() {
        if (enemy.isColission(enemy.x + enemy.speed, enemy.y)) {
            return false;
        } else return true;
    }



    boolean ThereIsNoCollisionOnDown() {
        if (enemy.isColission(enemy.x, enemy.y + enemy.speed)) {
            return false;
        } else return true;
    }



    void goUp() {
        enemy.y -= enemy.speed;
    }

    void goRight() {
        enemy.x += enemy.speed;
    }

    void goLeft() {
        enemy.x -= enemy.speed;
    }

    void changeDirection() {

        switch (enemy.directions) {
            case UP:
            case DOWN:
                if (ThereIsNoCollisionOnLeft() && ThereIsNoCollisionOnRight()) {

                    // if you have 2 open direction  check player position then change direction
                    if (enemy.x > Player.xx) {
                        enemy.directions = Enemy.Directions.LEFT;
                        goLeft();
                        break;
                    } else {
                        enemy.directions = Enemy.Directions.RIGHT;
                        goRight();
                        break;
                    }
                }

                if (ThereIsNoCollisionOnRight()) {
                    enemy.directions = Enemy.Directions.RIGHT;
                    goRight();
                    break;
                }
                if (ThereIsNoCollisionOnLeft()) {
                    enemy.directions = Enemy.Directions.LEFT;
                    goLeft();
                    break;
                }

            case RIGHT:
            case LEFT:
                if (ThereIsNoCollisionOnDown() && ThereIsNoCollisionOnUp()) {
                    if (enemy.y < Player.yy) {
                        enemy.directions = Enemy.Directions.DOWN;
                        goDown();
                        break;
                    } else {
                        enemy.directions = Enemy.Directions.UP;
                        goUp();
                        break;
                    }

                }
                if (ThereIsNoCollisionOnDown()) {
                    enemy.directions = Enemy.Directions.DOWN;
                    goDown();
                    break;

                }
                if (ThereIsNoCollisionOnUp()) {
                    enemy.directions = Enemy.Directions.UP;
                    goUp();
                    break;
                }
        }
    }

    void goOutside() {
        if (ThereIsNoCollisionOnUp()) {
            enemy.directions = Enemy.Directions.UP;
            goUp();
        }
    }

    boolean checkIfIsInHome() {
        if (enemy.y <= PacmanAppRunner.TILE_SIZE * 10 && enemy.y > PacmanAppRunner.TILE_SIZE * 8 && enemy.x > PacmanAppRunner.TILE_SIZE * 17 && enemy.x < PacmanAppRunner.TILE_SIZE * 21) {
            return true;
        } return false;
    }

    void checkIfIntersectWithPlayer(int xx, int yy) {
        Rectangle rectangle = new Rectangle(xx, yy, PacmanAppRunner.TILE_SIZE, PacmanAppRunner.TILE_SIZE);
        if (rectangle.intersects(Player.xx,Player.yy,40,40)) {

            // if is bonus send enemy to home
            if(PacmanAppRunner.bonus) {
                enemy.x = 740;
                enemy.y = 400;
            } else {
                PacmanAppRunner.playerLives.removeLive();
            }
        }
    }
    private void EscapeOnDistanceWhenLeftOrRight(int safeDistance) {

        // if enemy is in a center of tile  and can go up and  player is above enemy
        if (enemy.x%PacmanAppRunner.TILE_SIZE==0 && ThereIsNoCollisionOnUp() && enemy.y <= Player.yy) {
            if ((Player.yy - enemy.y)<safeDistance) {
                enemy.directions = Enemy.Directions.UP;
                goUp();
                enemy.changeOfDirection = true;
                return;
            } else {
                if (ThereIsNoCollisionOnDown()) {
                    enemy.directions = Enemy.Directions.DOWN;
                    goDown();
                    enemy.changeOfDirection = true;
                    return;
                }

            }
            if (enemy.x%PacmanAppRunner.TILE_SIZE==0 && ThereIsNoCollisionOnDown() && enemy.y >=Player.yy ) {
                if((enemy.y - Player.yy)<safeDistance ) {
                    enemy.directions = Enemy.Directions.DOWN;
                    goDown();
                    enemy.changeOfDirection = true;

                } else {
                    if (ThereIsNoCollisionOnUp()) {
                        enemy.directions = Enemy.Directions.UP;
                        goUp();
                        enemy.changeOfDirection = true;

                    }
                }

            }



        }
    }

    private void EscapeOnDistanceWhenUpOrDown(int safeDistance) {
        //If enemy moving down and can fit between wall AND is no collision with wall on right side and enemy is on right side player
        if (enemy.y % PacmanAppRunner.TILE_SIZE == 0 && ThereIsNoCollisionOnRight() && enemy.x >= Player.xx) {
            // if distance between player and enemy is not safe then still go right
            if ((enemy.x - Player.xx) < safeDistance) {
                enemy.directions = Enemy.Directions.RIGHT;
                goRight();
                enemy.changeOfDirection = true;
                return;
            } else {
                if (ThereIsNoCollisionOnLeft()) {
                    enemy.directions = Enemy.Directions.LEFT;
                    goLeft();
                    enemy.changeOfDirection = true;
                    return;
                }
            }

        }
        // if enemy moving down  and can fit between wall AND is no collision with wall on left side and enemy is on left side player
        if (enemy.y % PacmanAppRunner.TILE_SIZE == 0 && ThereIsNoCollisionOnLeft() && enemy.x <= Player.xx) {
            if ((enemy.x - Player.xx) > safeDistance) {
                enemy.directions = Enemy.Directions.LEFT;
                goLeft();
                enemy.changeOfDirection = true;


            } else {
                if (ThereIsNoCollisionOnRight()) {
                    enemy.directions = Enemy.Directions.RIGHT;
                    goRight();
                    enemy.changeOfDirection = true;

                }
            }

        }
    }
    boolean TrackPlayerAndCheckIfIsBetterToChangeDirection() {
        enemy.changeOfDirection = false;
        switch (enemy.directions) {
            case UP:
            case DOWN:

                // if brave and is no bonus time
                if (enemy.brave &&!PacmanAppRunner.bonus) {

                    if (enemy.x > Player.xx && enemy.x % PacmanAppRunner.TILE_SIZE == 0 && ThereIsNoCollisionOnLeft()) {
                        enemy.directions = Enemy.Directions.LEFT;
                        goLeft();
                        enemy.changeOfDirection = true;
                        break;
                    }
                    if (enemy.x < Player.xx && enemy.x % PacmanAppRunner.TILE_SIZE == 0 && ThereIsNoCollisionOnRight()) {
                        enemy.directions = Enemy.Directions.RIGHT;
                        goRight();
                        enemy.changeOfDirection= true;
                        break;
                    }
                    break;

                    // if is not brave  is no bonus time then go closer and when is close to player run away
                }else  {

                    if (!PacmanAppRunner.bonus) {
                        EscapeOnDistanceWhenUpOrDown(160);
                        break;
                    // is is bonus then everyone run away
                    } else  {
                        EscapeOnDistanceWhenUpOrDown(1600);
                    }
                    break;
                }
            case RIGHT:
            case LEFT:

                // if brave then get closer to player
                if (enemy.brave &&!PacmanAppRunner.bonus) {
                    if (enemy.y >Player.yy && enemy.y%PacmanAppRunner.TILE_SIZE==0 && ThereIsNoCollisionOnUp()) {
                        enemy.directions = Enemy.Directions.UP;
                        goUp();
                        enemy.changeOfDirection = true;
                        break;
                    }
                    if (enemy.y <Player.yy && enemy.y%PacmanAppRunner.TILE_SIZE==0 && ThereIsNoCollisionOnDown()) {
                        enemy.directions = Enemy.Directions.DOWN;
                        goDown();

                        enemy.changeOfDirection = true;
                        break;
                    }
                    break;


                    // if is not brave  then when is close to player run away
                } else  {
                    if (!PacmanAppRunner.bonus) {
                        EscapeOnDistanceWhenLeftOrRight(160);
                        break;
                    } else  {
                        EscapeOnDistanceWhenLeftOrRight(1600);
                    }




                    break;
                }
        } return enemy.changeOfDirection;
    }

}