package com.codecool.battleship.board;

import com.codecool.battleship.input.Input;
import com.codecool.battleship.ship.Ship;
import com.codecool.battleship.ship.ShipType;
import com.codecool.battleship.squere.Square;
import com.codecool.battleship.squere.SquareStatus;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class BoardFactory {
    Board board = new Board();

    private final Ship ship = new Ship(new ArrayList<>());

    public Board getBoard() {
        return board;
    }

    public Ship coordinatesOfShip(int x, int y, ShipType shipType, String direction){
         for (int i = 0; i <shipType.length ; i++) {
                int newX = x;
                int newY = y;
                switch (direction) {
                    case "VU" -> newY = y - i;
                    case "VD" -> newY = y + i;
                    case "HL" -> newX = x - i;
                    case "HR" -> newX = x + i;
                }
                ship.getShipLocated().add(board.getBoard()[newX][newY]);
            }

        return ship;
    }

    public Board manualPlacement(Ship ship){
        List <Square> coordinatesShips = ship.getShipLocated();
        for (int i = 0; i <coordinatesShips.size() ; i++) {
            int newX = coordinatesShips.get(i).getX();
            int newY = coordinatesShips.get(i).getY();

            board.getBoard()[newX][newY] = new Square(newX, newY, SquareStatus.SHIP);


//                ship.getShipLocated().add(board.getBoard()[newX][newY]);
//                ship.getShipLocated().add(new Square(newX, newY, SquareStatus.SHIP));
        }

        return board;
    }




    public String randomPlacement(){
        return null;

    }


}
