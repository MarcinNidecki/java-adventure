package com.kodilla.pacmanV2.pacmanBoard.levelFactory;

import java.util.LinkedList;

public class Maze {

    private LinkedList<LineOfMaze> maze = new LinkedList<>();

    public void addRow(LineOfMaze line) {
        maze.add(line);

    }

    public LinkedList<LineOfMaze> getMaze() {
        return maze;
    }

    public void setMaze(LinkedList<LineOfMaze> maze) {
        this.maze = maze;
    }

    public void tick() {


    }

}
