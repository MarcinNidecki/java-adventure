package com.kodilla.pacmanV2.items;

import com.kodilla.pacmanV2.GameInit;
import com.kodilla.pacmanV2.pacmanBoard.levelFactory.LevelFactory;

import java.awt.*;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

class WallCollision {



     private boolean isNoCollision(int x, int y) {
        Rectangle rectangle = new Rectangle(x, y, GameInit.TILE_SIZE, GameInit.TILE_SIZE);

        int yLine = y/GameInit.TILE_SIZE;
        int xLine = x/GameInit.TILE_SIZE;

        List<Map.Entry> listOfCollidingTile = LevelFactory.maze.getMaze().entrySet().parallelStream()
                .filter(lineOfMaze -> lineOfMaze.getKey()<=yLine+1  && lineOfMaze.getKey() >=yLine-1)
                .flatMap(line -> line.getValue().getLineOfItems().entrySet().stream())
                .filter(lineOfMaze -> lineOfMaze.getKey()<=xLine+1  && lineOfMaze.getKey() >=xLine-1)
                .filter(item -> (item.getValue() instanceof Wall && (rectangle.intersects((Wall) item.getValue()))))
                .collect(Collectors.toList());

        int numberOfCollision = listOfCollidingTile.size();
        return numberOfCollision <= 0;
    }

    boolean thereIsNoCollisionOnLeft(int x, int y) {
        return isNoCollision(x - GameInit.speed, y);
    }

    boolean thereIsNoCollisionOnRight(int x, int y) {
        return isNoCollision(x + GameInit.speed, y);
    }

    boolean thereIsNoCollisionOnDown(int x, int y) {
        return isNoCollision(x, y + GameInit.speed);
    }

    boolean thereIsNoCollisionOnUp(int x, int y) {
        return isNoCollision(x, y - GameInit.speed);
    }

}

