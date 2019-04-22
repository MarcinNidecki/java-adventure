package com.kodilla.pacmanV2.items;

import com.kodilla.pacmanV2.PacmanAppRunner;

import java.awt.*;

public class EnemyControl {
    private final Enemy enemy;
    int tick;

    public EnemyControl(Enemy enemy) {
        this.enemy = enemy;
    }


    boolean ThereIsNoCollisionOnLeft() {
        return enemy.isCollision(enemy.x - enemy.speed, enemy.y);
    }

    boolean ThereIsNoCollisionOnRight() {
        return enemy.isCollision(enemy.x + enemy.speed, enemy.y);
    }

    boolean ThereIsNoCollisionOnDown() {
        return enemy.isCollision(enemy.x, enemy.y + enemy.speed);
    }

    boolean ThereIsNoCollisionOnUp() {
        return enemy.isCollision(enemy.x, enemy.y - enemy.speed);
    }


    void goDown() {
        enemy.y += enemy.speed;
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

    void goOutsideHome() {

        if (ThereIsNoCollisionOnUp()) {
            // when fps is set to 60  then 1 second is 60 ticks
            enemy.directions = Enemy.Directions.STOP;
            if (tick > 360) {
                enemy.directions = Enemy.Directions.UP;
                goUp();

            }
            tick++;
        }
    }

    boolean checkIfIsInHome() {
        return enemy.y <= PacmanAppRunner.TILE_SIZE * 10 && enemy.y > PacmanAppRunner.TILE_SIZE * 8 && enemy.x > PacmanAppRunner.TILE_SIZE * 17 && enemy.x < PacmanAppRunner.TILE_SIZE * 21;
    }

    void checkIfNeedToUseATeleport() {
        if (enemy.x == 1480 && enemy.y == 400) {
            enemy.x = 0;
            goRight();

        }

        if (enemy.x == 0 && enemy.y == 400) {
            enemy.x = 1480;
            goLeft();

        }
    }

    void checkIfIntersectWithPlayer(int xx, int yy) {
        Rectangle rectangle = new Rectangle(xx, yy, PacmanAppRunner.TILE_SIZE, PacmanAppRunner.TILE_SIZE);
        if (rectangle.intersects(Player.xx, Player.yy, 40, 40)) {

            // if is bonus send enemy to home
            if (PacmanAppRunner.bonus) {
                enemy.x = 740;
                enemy.y = 400;
                tick = 0;
            } else{

                Player.hitTheGhost = true;
                PacmanAppRunner.player.backToStart();
                PacmanAppRunner.playerLives.removeLive();
            }
        }
    }

    void changeDirection() {


        //  when enemy have more then 2 way to choose,  check where is player then go closer
        //  when enemy have only one possibilities then just change direction.
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

    private void EscapeOnDistanceWhenLeftOrRight(int safeDistance) {

        // if enemy is in a center of tile  and can go up and  player is above enemy
        if (enemy.x % PacmanAppRunner.TILE_SIZE == 0 && ThereIsNoCollisionOnUp() && enemy.y <= Player.yy) {
            if ((Player.yy - enemy.y) < safeDistance) {
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
            if (enemy.x % PacmanAppRunner.TILE_SIZE == 0 && ThereIsNoCollisionOnDown() && enemy.y >= Player.yy) {
                if ((enemy.y - Player.yy) < safeDistance) {
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
        //If enemy is escaping down/up and have option to turn on right
        // check  if player is on left  side then escape on right
        if (enemy.y % PacmanAppRunner.TILE_SIZE == 0 && ThereIsNoCollisionOnRight() && enemy.x >= Player.xx) {
            // if distance between player and enemy is not safe then still go right
            if ((enemy.x - Player.xx) < safeDistance) {
                enemy.directions = Enemy.Directions.RIGHT;
                goRight();
                enemy.changeOfDirection = true;
                return;
                // if distance is safe  then go closer to player
            }


        }
        //If enemy is escaping down/up and have option to turn on left
        // check  if player is on right side then escape on left
        if (enemy.y % PacmanAppRunner.TILE_SIZE == 0 && ThereIsNoCollisionOnLeft() && enemy.x <= Player.xx) {
            // if distance between player and enemy is not safe then still go right
            if ((enemy.x - Player.xx) > safeDistance) {
                enemy.directions = Enemy.Directions.LEFT;
                goLeft();
                enemy.changeOfDirection = true;
            }

        }
    }

    boolean TrackPlayerAndCheckIfIsBetterToChangeDirectionThenChangeDirection() {
        enemy.changeOfDirection = false;
        switch (enemy.directions) {
            case UP:
            case DOWN:

                // if brave and is no bonus time
                if (enemy.brave && !PacmanAppRunner.bonus) {

                    if (enemy.x > Player.xx && enemy.x % PacmanAppRunner.TILE_SIZE == 0 && ThereIsNoCollisionOnLeft()) {
                        enemy.directions = Enemy.Directions.LEFT;
                        goLeft();
                        enemy.changeOfDirection = true;
                        break;
                    }
                    if (enemy.x < Player.xx && enemy.x % PacmanAppRunner.TILE_SIZE == 0 && ThereIsNoCollisionOnRight()) {
                        enemy.directions = Enemy.Directions.RIGHT;
                        goRight();
                        enemy.changeOfDirection = true;
                        break;
                    }
                    break;


                } else {
                    // if is not brave and bonus is off then go closer and when is close to player run away
                    if (!PacmanAppRunner.bonus) {
                        EscapeOnDistanceWhenUpOrDown(160);
                        break;
                        // is is bonus then everyone run away
                    } else {
                        EscapeOnDistanceWhenUpOrDown(1600);
                    }
                    break;
                }
            case RIGHT:
            case LEFT:

                // if brave then get closer to player
                if (enemy.brave && !PacmanAppRunner.bonus) {
                    if (enemy.y > Player.yy && enemy.y % PacmanAppRunner.TILE_SIZE == 0 && ThereIsNoCollisionOnUp()) {
                        enemy.directions = Enemy.Directions.UP;
                        goUp();
                        enemy.changeOfDirection = true;
                        break;
                    }
                    if (enemy.y < Player.yy && enemy.y % PacmanAppRunner.TILE_SIZE == 0 && ThereIsNoCollisionOnDown()) {
                        enemy.directions = Enemy.Directions.DOWN;
                        goDown();

                        enemy.changeOfDirection = true;
                        break;
                    }
                    break;


                    // if is not brave  then when is close to player run away
                } else {
                    if (!PacmanAppRunner.bonus) {
                        // is bonus if OFF but enemy is not brave
                        EscapeOnDistanceWhenLeftOrRight(160);
                        break;
                        // when bonus is on
                    } else {
                        EscapeOnDistanceWhenLeftOrRight(1600);
                    }


                    break;
                }
        }
        return enemy.changeOfDirection;
    }

}