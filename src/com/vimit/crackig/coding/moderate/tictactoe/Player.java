package com.vimit.crackig.coding.moderate.tictactoe;

public class Player {
    private String name;
    private Unit unit;
    private Board board;

    public Player(String name, Unit unit, Board board) {
        this.name = name;
        this.unit = unit;
        this.board = board;
    }

    public String getName() {
        return name;
    }

    public Unit getUnit() {
        return unit;
    }

    public boolean move(int row, int col){
        return board.hasWon(this.unit, row, col);
    }
}
