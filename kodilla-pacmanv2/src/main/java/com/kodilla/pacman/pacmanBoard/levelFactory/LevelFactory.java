package com.kodilla.pacman.pacmanBoard.levelFactory;

import com.kodilla.pacman.items.BigDot;
import com.kodilla.pacman.items.Dot;
import com.kodilla.pacman.items.Empty;
import com.kodilla.pacman.items.Wall;

import java.awt.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.*;
import java.util.stream.Collectors;

public class LevelFactory {

    public static Maze maze = new Maze();

    public LevelFactory() {


        // try read the file
        Scanner scanner = null;
        try {

            ClassLoader classLoader = getClass().getClassLoader();
            File fileTxTLevel = new File(Objects.requireNonNull(classLoader.getResource("assets/text/pacman_level.txt")).getFile());
            scanner = new Scanner(fileTxTLevel);


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        ArrayList<String> levelData = new ArrayList<>();
        assert scanner != null;
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
                char c = line.charAt(yy);

                switch (c) {

                    case '1':
                        Wall wall = new Wall(yy * 40, xx * 40);

                        lineOfMaze.addElement(yy, wall);

                        break;
                    case '0':
                        Dot dot = new Dot(yy * 40, xx * 40);
                        lineOfMaze.addElement(yy, dot);
                        break;
                    case '2':
                        BigDot bigDot = new BigDot(yy * 40, xx * 40);
                        lineOfMaze.addElement(yy, bigDot);
                        break;
                    case '3':
                        Empty empty = new Empty(yy * 40, xx * 40);
                        lineOfMaze.addElement(yy, empty);
                        break;
                }
                System.out.println(lineOfMaze.getLineOfItems().size());
            }
            maze.addLine(xx, lineOfMaze);

        }
    }

    public static void closeDoor() {

        maze.getMaze().get(9).getLineOfItems().replace(18, new Wall(720, 360));
        maze.getMaze().get(9).getLineOfItems().replace(19, new Wall(760, 360));
        maze.getMaze().get(9).getLineOfItems().replace(20, new Wall(800, 360));

    }

    public static void openDoor() {

        maze.getMaze().get(9).getLineOfItems().replace(18, new Empty(720, 360));
        maze.getMaze().get(9).getLineOfItems().replace(19, new Empty(760, 360));
        maze.getMaze().get(9).getLineOfItems().replace(20, new Empty(800, 360));

    }

    public int render(Graphics g) {

        List<Map.Entry> listOfDots = maze.getMaze().entrySet().stream()
                .flatMap(row -> row.getValue().getLineOfItems().entrySet().stream())
                .filter(t -> (t.getValue() instanceof Dot) || (t.getValue() instanceof BigDot))
                .collect(Collectors.toList());


        listOfDots.size();


        for (Map.Entry listOfDot : listOfDots) {
            if (listOfDot.getValue() instanceof Dot) {
                Dot dot = (Dot) listOfDot.getValue();
                dot.render(g);
            }

            if (listOfDot.getValue() instanceof BigDot) {
                BigDot bigDot = (BigDot) listOfDot.getValue();
                bigDot.render(g);
            }

        }
        return listOfDots.size();
    }
}

