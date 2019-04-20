package com.kodilla.pacmanV2.pacmanBoard;

import com.kodilla.pacmanV2.items.Items;

import java.util.LinkedList;

public class RowOfBoard {

    public LinkedList <Items> itemList = new LinkedList<>();

    public void addElement (Items items) {

        itemList.add(items);
    }


    public void removeElements(Items items) {
        int index = itemList.indexOf(items);
        itemList.remove(index);
        itemList.set(index, null);
    }

    public Items getRow (int rowNumber) {
        return itemList.get(rowNumber);
    }
    public LinkedList<Items> getItemList() {
        return itemList;
    }

    public void setItemList(LinkedList<Items> itemList) {
        this.itemList = itemList;
    }


}
