package com.kodilla.pacmanV2.pacmanBoard.levelFactory;

import com.kodilla.pacmanV2.items.Items;

import java.util.HashMap;

public class LineOfMaze {

    private HashMap<Integer, Items> lineOfItems = new HashMap<>();


    void addElement(Integer lineNr, Items items) {

        lineOfItems.put(lineNr, items);
    }

    public HashMap<Integer, Items> getLineOfItems() {
        return lineOfItems;
    }


}
