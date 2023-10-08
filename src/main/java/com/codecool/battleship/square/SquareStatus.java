package com.codecool.battleship.square;

public enum SquareStatus {

    EMPTY(" "),
    SHIP("o"),
    HIT("X"),
    MISSED("*");

    private final String status;

    SquareStatus(String status) {
        this.status = status;
    }

    public String getCharacter(){
        return status;
    }

}
