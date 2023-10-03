package com.codecool.battleship.player;

import com.codecool.battleship.board.Board;
import com.codecool.battleship.board.BoardFactory;
import com.codecool.battleship.ship.Ship;
import com.codecool.battleship.ship.ShipType;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractPlayer  {

    protected String name;
    public List<Ship> ships;



    public AbstractPlayer(String name) {
        this.name = name;
        this.ships = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;

    }

    public boolean isAlive(){
        return false;
    }
}
