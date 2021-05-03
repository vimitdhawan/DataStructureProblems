package com.vimit.crackig.coding.moderate.tictactoe;

public class Board {
    private Unit[][] board;
    private int[] rowsWon;
    private int[] colsWon;
    private int frontDiagonal;
    private int reverseDiagonal;
    Board(int size){
        rowsWon = new int[size];
        colsWon = new int[size];
        board = new Unit[size][size];
    }
    public boolean hasWon(Unit unit, int row, int column){
        board[row][column] = unit;
        rowsWon[row] = rowsWon[row] + unit.getValue();
        colsWon[column] =  colsWon[row] + unit.getValue();
        if(row == column){
            frontDiagonal += unit.getValue();
        }
        if(row == board.length-column-1){
            reverseDiagonal +=  unit.getValue();
        }
        return Math.abs(rowsWon[row]) == board.length || Math.abs(colsWon[row]) == board.length ||  Math.abs(frontDiagonal) == board.length || Math.abs(reverseDiagonal) == board.length;
    }

}
