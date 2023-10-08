package com.codecool.battleship.board;

import java.util.Objects;

public class Position {

    private final int x;
    private final int y;

    public Position(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o instanceof Position) {
            Position position = (Position) o;
            return x == position.x && y == position.y;
        } else
            return false;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }
}
