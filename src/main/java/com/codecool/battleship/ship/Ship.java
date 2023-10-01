package com.codecool.battleship.ship;

import com.codecool.battleship.squere.Square;

import java.util.List;

public class Ship {

    public List<Square> shipLocated;



    public Ship(List<Square> shipLocated) {
        this.shipLocated = shipLocated;
    }
}
