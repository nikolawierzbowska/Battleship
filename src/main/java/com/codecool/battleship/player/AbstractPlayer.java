package com.codecool.battleship.player;

import com.codecool.battleship.ship.Ship;

import java.util.List;

public abstract class AbstractPlayer implements Player {

    protected String name;
    public List<Ship> ships;

    public AbstractPlayer() {

    }


    public String getName() {
        return name;
    }

    public String setName(String name) {
        this.name = name;
        return name;
    }

    public boolean isAlive(){
        return false;
    }
}
