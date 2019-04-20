package com.kodilla.pacmanV2.pacmanBoard;

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

    ArrayList<String> levelData = new ArrayList<>();
    private char c;
    public static Board board = new Board();
    public BufferedImage background;

    public LevelFactory() {


        // try read the file
        Scanner scanner = null;
        try {

            scanner = new Scanner(new File("kodilla-pacmanv2\\src\\main\\resources\\assets\\text\\pacman_level.txt"));


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
            String row = levelData.get(xx);
            RowOfBoard rowOfBoard = new RowOfBoard();
            for (int yy = 0; yy < w; yy++) {
                c = row.charAt(yy);

                switch (c) {

                    case '1':
                        Wall wall = new Wall(yy * 40, xx * 40);

                        rowOfBoard.addElement(wall);

                        break;
                    case '0':
                        Dot dot = new Dot(yy * 40, xx * 40);
                        rowOfBoard.addElement(dot);
                        break;
                    case '2':
                        BigDot bigDot = new BigDot(yy * 40, xx * 40);
                        rowOfBoard.addElement(bigDot);
                        break;
                }
            }
            board.addRow(rowOfBoard);
           //rowOfBoard.getItemList().clear();
        }
    }

    public static void closeDoor() {


        board.getBoardOfRows().get(9).getItemList().set(18, new Wall(720, 360));
        board.getBoardOfRows().get(9).getItemList().set(19, new Wall(760, 360));
        board.getBoardOfRows().get(9).getItemList().set(20, new Wall(800, 360));

    }

    public static void openDoor() {


        board.getBoardOfRows().get(9).getItemList().set(18,null);
        board.getBoardOfRows().get(9).getItemList().set(19, null);
        board.getBoardOfRows().get(9).getItemList().set(20,null);

    }

    public void render(Graphics g) {

        List<Items> ListOfDots = board.getBoardOfRows().stream()
                .flatMap(row -> row.getItemList().stream())
                .filter(t -> (t instanceof Dot) || (t instanceof BigDot))
                .collect(Collectors.toList());


        ListOfDots.size();
        for (int i=0; i<ListOfDots.size();i++) {
            if (ListOfDots.get(i) instanceof Dot) {
                Dot dot =(Dot)ListOfDots.get(i);
                dot.render(g);
            }

            if (ListOfDots.get(i)instanceof BigDot) {
                BigDot bigDot = (BigDot)ListOfDots.get(i);
                bigDot.render(g);
            }



        }
    }

}

