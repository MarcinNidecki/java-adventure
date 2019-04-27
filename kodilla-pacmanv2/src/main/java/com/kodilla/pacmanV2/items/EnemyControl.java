package com.kodilla.pacmanV2.items;

import com.kodilla.pacmanV2.GameInit;

import java.awt.*;

class EnemyControl {
    private final Enemy enemy;
    private final Player player;
    private final WallCollision wallCollision = new WallCollision();



    EnemyControl(Enemy enemy, Player player) {
        this.enemy = enemy;
        this.player = player;
    }




    void goDown() {
        enemy.y += GameInit.speed;
    }

    void goUp() {
        enemy.y -= GameInit.speed;
    }

    void goRight() {
        enemy.x += GameInit.speed;
    }

    void goLeft() {
        enemy.x -= GameInit.speed;
    }



    boolean checkIfIsInHome() {
        return enemy.y <= GameInit.TILE_SIZE * 11 && enemy.y > GameInit.TILE_SIZE * 8 && enemy.x > GameInit.TILE_SIZE * 17 && enemy.x < GameInit.TILE_SIZE * 21;
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
        Rectangle rectangle = new Rectangle(xx, yy, GameInit.TILE_SIZE, GameInit.TILE_SIZE);
        if (rectangle.intersects(player.getX(), player.getY(), 40, 40)) {

            // if is bonus send enemy to home
            if (GameInit.bonus) {
                enemy.setItsEye(true);


            } else{

                player.sendPlayerToStart();
                GameInit.getPlayerLives().removeLive();
                player.setHitByEnemy(true);
            }
        }
    }

    void changeDirection() {


        //  when enemy have more then 2 way to choose,  check where is player then go closer
        //  when enemy have only one possibilities then just change direction.
        switch (enemy.getDirection()) {
            case UP:
            case DOWN:
                if (wallCollision.thereIsNoCollisionOnLeft(enemy.x,enemy.y) && wallCollision.thereIsNoCollisionOnRight(enemy.x,enemy.y)) {

                    // if you have 2 open direction  check player position then change direction
                    if (enemy.x > player.getX()) {
                        enemy.setDirections(Enemy.Directions.LEFT);
                        goLeft();
                        break;
                    } else {
                        enemy.setDirections(Enemy.Directions.RIGHT);
                        goRight();
                        break;
                    }
                }

                if (wallCollision.thereIsNoCollisionOnRight(enemy.x,enemy.y)) {
                    enemy.setDirections(Enemy.Directions.RIGHT);
                    goRight();
                    break;
                }
                if (wallCollision.thereIsNoCollisionOnLeft(enemy.x,enemy.y)) {
                    enemy.setDirections(Enemy.Directions.LEFT);
                    goLeft();
                    break;
                }

            case RIGHT:
            case LEFT:
                if (wallCollision.thereIsNoCollisionOnDown(enemy.x,enemy.y) && wallCollision.thereIsNoCollisionOnUp(enemy.x,enemy.y)) {
                    if (enemy.y < player.getY()) {
                        enemy.setDirections(Enemy.Directions.DOWN);
                        goDown();
                        break;
                    } else {
                        enemy.setDirections(Enemy.Directions.UP);
                        goUp();
                        break;
                    }

                }
                if (wallCollision.thereIsNoCollisionOnDown(enemy.x,enemy.y)) {
                    enemy.setDirections(Enemy.Directions.DOWN);
                    goDown();
                    break;

                }
                if (wallCollision.thereIsNoCollisionOnUp(enemy.x,enemy.y)) {
                    enemy.setDirections(Enemy.Directions.UP);
                    goUp();
                    break;
                }
        }
    }

    private void EscapeOnDistanceWhenLeftOrRight(int safeDistance) {

        // if enemy is in a center of tile  and can go up and  player is above enemy
        if (enemy.x % GameInit.TILE_SIZE == 0 && wallCollision.thereIsNoCollisionOnUp(enemy.x,enemy.y) && enemy.y <= player.getY()) {
            if ((player.getY() - enemy.y) < safeDistance) {
                enemy.setDirections(Enemy.Directions.UP);
                goUp();
                enemy.setChangeOfDirection(true);
                return;
            } else {
                if (wallCollision.thereIsNoCollisionOnDown(enemy.x,enemy.y)) {
                    enemy.setDirections(Enemy.Directions.DOWN);
                    goDown();
                    enemy.setChangeOfDirection(true);
                    return;
                }

            }
            if (enemy.x % GameInit.TILE_SIZE == 0 && wallCollision.thereIsNoCollisionOnDown(enemy.x,enemy.y) && enemy.y >= player.getY()) {
                if ((enemy.y - player.getY()) < safeDistance) {
                    enemy.setDirections(Enemy.Directions.DOWN);
                    goDown();
                    enemy.setChangeOfDirection(true);

                } else {
                    if (wallCollision.thereIsNoCollisionOnUp(enemy.x,enemy.y)) {
                        enemy.setDirections(Enemy.Directions.UP);
                        goUp();
                        enemy.setChangeOfDirection(true);

                    }
                }

            }

        }
    }

    private void escapeOnDistanceWhenUpOrDown(int safeDistance) {
        //If enemy is escaping down/up and have option to turn on right
        // check  if player is on left  side then escape on right
        if (enemy.y % GameInit.TILE_SIZE == 0 && wallCollision.thereIsNoCollisionOnRight(enemy.x,enemy.y) && enemy.x >= player.getX()) {
            // if distance between player and enemy is not safe then still go right
            if ((enemy.x - player.getX()) < safeDistance) {
                enemy.setDirections(Enemy.Directions.RIGHT);
                goRight();
                enemy.setChangeOfDirection(true);
                return;
                // if distance is safe  then go closer to player
            }


        }
        //If enemy is escaping down/up and have option to turn on left
        // check  if player is on right side then escape on left
        if (enemy.y % GameInit.TILE_SIZE == 0 && wallCollision.thereIsNoCollisionOnLeft(enemy.x,enemy.y) && enemy.x <= player.getX()) {
            // if distance between player and enemy is not safe then still go right
            if ((enemy.x - player.getX()) > safeDistance) {
                enemy.setDirections(Enemy.Directions.LEFT);
                goLeft();
                enemy.setChangeOfDirection(true);
            }

        }
    }

    boolean trackPlayerAndCheckIfIsBetterToChangeDirectionThenChangeDirection() {
        enemy.setChangeOfDirection(false);
        switch (enemy.getDirection()) {
            case UP:
            case DOWN:

                // if brave and is no bonus time
                if (enemy.isBrave() && !GameInit.bonus) {

                    if (enemy.x > player.getX() && enemy.x % GameInit.TILE_SIZE == 0 && wallCollision.thereIsNoCollisionOnLeft(enemy.x,enemy.y)) {
                        enemy.setDirections(Enemy.Directions.LEFT);
                        goLeft();
                        enemy.setChangeOfDirection(true);
                        break;
                    }
                    if (enemy.x < player.getX() && enemy.x % GameInit.TILE_SIZE == 0 && wallCollision.thereIsNoCollisionOnRight(enemy.x,enemy.y)) {
                        enemy.setDirections(Enemy.Directions.RIGHT);
                        goRight();
                        enemy.setChangeOfDirection(true);
                        break;
                    }
                    break;


                } else {
                    // if is not brave and bonus is off then go closer and when is close to player run away
                    if (!GameInit.bonus) {
                        escapeOnDistanceWhenUpOrDown(160);
                        break;
                        // is is bonus then everyone run away
                    } else {
                        escapeOnDistanceWhenUpOrDown(1600);
                    }
                    break;
                }

            case RIGHT:
            case LEFT:
                // if brave then get closer to player
                if (enemy.isBrave()&& !GameInit.bonus) {
                    if (enemy.y > player.getY() && enemy.y % GameInit.TILE_SIZE == 0 && wallCollision.thereIsNoCollisionOnUp(enemy.x,enemy.y)) {
                        enemy.setDirections(Enemy.Directions.UP);
                        goUp();
                        enemy.setChangeOfDirection(true);
                        break;
                    }
                    if (enemy.y < player.getY() && enemy.y % GameInit.TILE_SIZE == 0 && wallCollision.thereIsNoCollisionOnDown(enemy.x,enemy.y)) {
                        enemy.setDirections(Enemy.Directions.DOWN);
                        goDown();

                        enemy.setChangeOfDirection(true);
                        break;
                    }
                    break;

                    // if is not brave  then when is close to player run away
                } else {
                    if (!GameInit.bonus) {
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
        return enemy.isChangeOfDirection();
    }

}