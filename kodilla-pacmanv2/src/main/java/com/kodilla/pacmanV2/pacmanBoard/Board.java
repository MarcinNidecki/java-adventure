package com.kodilla.pacmanV2.pacmanBoard;

import java.util.LinkedList;

public class Board {

    private LinkedList<RowOfBoard> boardRows = new LinkedList<>();

    public void addRow(RowOfBoard row) {
        boardRows.add(row);

    }

    public LinkedList<RowOfBoard> getBoardOfRows() {
        return boardRows;
    }

    public void setBoardRows(LinkedList<RowOfBoard> itemList) {
        this.boardRows = itemList;
    }

    public  void tick() {


    }

}
