package com.vimit.crackig.coding.moderate.tictactoe;

public enum Unit {
    EMPTY(0), CROSS(1), CIRCLE(-1);
    private int value;
    Unit(int  value) {
        this.value = value;
    }
    public int getValue(){
        return value;
    }
}
