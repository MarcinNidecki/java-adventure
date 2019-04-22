package com.kodilla.pacmanV2.pacmanBoard.levelFactory;

import com.kodilla.pacmanV2.items.BigDot;
import com.kodilla.pacmanV2.items.Dot;
import com.kodilla.pacmanV2.items.Items;
import com.kodilla.pacmanV2.items.Wall;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class LevelFactory {

    public static Maze maze = new Maze();
    public BufferedImage background;
    ArrayList<String> levelData = new ArrayList<>();
    private char c;

    public LevelFactory() {


        // try read the file
        Scanner scanner = null;
        try {

            ClassLoader classLoader = getClass().getClassLoader();
            File fileTxTLevel = new File(classLoader.getResource("assets/text/pacman_level.txt").getFile());
            scanner = new Scanner(fileTxTLevel);



        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        while (scanner.hasNextLine()) {
            levelData.add(scanner.nextLine());
        }
        scanner.close();


        // load elements from file
        int w = levelData.get(0).length();
        for (int xx = 0; xx < levelData.size(); xx++) {
            String line = levelData.get(xx);
            LineOfMaze lineOfMaze = new LineOfMaze();
            for (int yy = 0; yy < w; yy++) {
                c = line.charAt(yy);

                switch (c) {

                    case '1':
                        Wall wall = new Wall(yy * 40, xx * 40);

                        lineOfMaze.addElement(wall);

                        break;
                    case '0':
                        Dot dot = new Dot(yy * 40, xx * 40);
                        lineOfMaze.addElement(dot);
                        break;
                    case '2':
                        BigDot bigDot = new BigDot(yy * 40, xx * 40);
                        lineOfMaze.addElement(bigDot);
                        break;
                }
            }
            maze.addRow(lineOfMaze);

        }
    }

    public static void closeDoor() {


        maze.getMaze().get(9).getLineOfItems().set(18, new Wall(720, 360));
        maze.getMaze().get(9).getLineOfItems().set(19, new Wall(760, 360));
        maze.getMaze().get(9).getLineOfItems().set(20, new Wall(800, 360));

    }

    public static void openDoor() {


        maze.getMaze().get(9).getLineOfItems().set(18, null);
        maze.getMaze().get(9).getLineOfItems().set(19, null);
        maze.getMaze().get(9).getLineOfItems().set(20, null);

    }

    public void render(Graphics g) {

        List<Items> ListOfDots = maze.getMaze().stream()
                .flatMap(row -> row.getLineOfItems().stream())
                .filter(t -> (t instanceof Dot) || (t instanceof BigDot))
                .collect(Collectors.toList());


        ListOfDots.size();


        for (int i = 0; i < ListOfDots.size(); i++) {
            if (ListOfDots.get(i) instanceof Dot) {
                Dot dot = (Dot) ListOfDots.get(i);
                dot.render(g);
            }

            if (ListOfDots.get(i) instanceof BigDot) {
                BigDot bigDot = (BigDot) ListOfDots.get(i);
                bigDot.render(g);
            }

        }
    }
}

