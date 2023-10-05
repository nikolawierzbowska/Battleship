package com.codecool.battleship.ship;
import com.codecool.battleship.squere.Square;
import java.util.ArrayList;
import java.util.List;

public class Ship {
    private final List<Square> squareList = new ArrayList<>();

    public List<Square> getSquareList() {
        return squareList;
    }
}
