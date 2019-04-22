package com.kodilla.pacmanV2.pacmanBoard.levelFactory;

import com.kodilla.pacmanV2.items.Items;

import java.util.LinkedList;

public class LineOfMaze {

    public LinkedList<Items> lineOfItems = new LinkedList<>();

    public void addElement(Items items) {

        lineOfItems.add(items);
    }


    public Items getLine(int lineNumber) {
        return lineOfItems.get(lineNumber);
    }

    public LinkedList<Items> getLineOfItems() {
        return lineOfItems;
    }


}
