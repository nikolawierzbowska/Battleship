package com.codecool.battleship.board;

public enum Direction {

    SOUTH(new Position(1, 0)),
    WEST(new Position(0, -1)),
    NORTH(new Position(-1, 0)),
    EAST(new Position(0, 1));

    private final Position direction;

    Direction(Position direction) {
        this.direction = direction;
    }

    public Position getValue() {
        return direction;
    }

}
