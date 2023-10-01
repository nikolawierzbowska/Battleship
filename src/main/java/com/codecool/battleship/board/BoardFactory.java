package com.codecool.battleship.board;

import com.codecool.battleship.input.Input;
import com.codecool.battleship.ship.Ship;
import com.codecool.battleship.ship.ShipType;
import com.codecool.battleship.squere.Square;
import com.codecool.battleship.squere.SquareStatus;

import java.util.ArrayList;


public class BoardFactory {

    private Board board = new Board();
    private Square square;
    private Input inputPlayer = new Input();
    private final Ship ship = new Ship(new ArrayList<>());


    public Board manualPlacement(int x, int y, String direction, ShipType shipType){
        if(board.isPlacementOk(x, y, direction,shipType)){

            for (int i = 0; i <shipType.length ; i++) {
                int newX = x;
                int newY = y;
                switch (direction) {
                    case "VU" -> newY = y - i;
                    case "VD" -> newY = y + i;
                    case "HL" -> newX = x - i;
                    case "HR" -> newX = x + i;
                }
                board.getBoard()[newX][newY] = new Square(newX, newY, SquareStatus.SHIP);

//                ship.getShipLocated().add(board.getBoard()[newX][newY]);
            }
        }
        return board;
    }


    public String randomPlacement(){
        return null;

    }
}
