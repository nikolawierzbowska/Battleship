package com.codecool.battleship.player;

import com.codecool.battleship.ship.Ship;
import com.codecool.battleship.squere.Square;
import com.codecool.battleship.squere.SquareStatus;

import java.util.List;

public abstract class AbstractPlayer {
    protected String name;
    public List<Ship> ships;

    public AbstractPlayer(String name, List<Ship> ships) {
        this.name = name;
        this.ships = ships;
    }

    public List<Ship> getShips() {
        return ships;
    }

    public void setShips(List<Ship> ships) {
        this.ships = ships;
    }

    public AbstractPlayer() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;

    }

    public boolean isAlive() {
        for (Ship ship : ships) {
            for (Square sq : ship.getSquareList()) {
                if (sq.getSquareStatus().equals(SquareStatus.SHIP)) {
                    return true;
                }
            }
        }
        return false;
    }
}
