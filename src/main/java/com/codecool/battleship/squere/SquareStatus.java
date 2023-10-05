package com.codecool.battleship.squere;

public enum SquareStatus {
    EMPTY("    "), SHIP(" \uD83D\uDD37 "), HIT("  \u2705"), MISSED("  \u2757 ");


    public final String character;


    SquareStatus(String character) {
        this.character = character;
    }


}
