package com.codecool.battleship.player;

import com.codecool.battleship.board.*;
import com.codecool.battleship.ship.Ship;
import java.util.List;

public abstract class Player {
    private final String name;
    private final List<Ship> ships;
    private final Board board;
    public Player(Board board,String name){
        this.name = name;
        this.board = board;
        ships = board.getShips();
    }
    public String getName(){
        return name;
    }

    public Board getBoard() {
        return board;
    }
    public List<Ship> getShips(){return ships;}

    public boolean isAlive() {
        return ships.stream().anyMatch(ship -> ship.isShipAlive());
    }

    public abstract Position getCoordinates();
}
