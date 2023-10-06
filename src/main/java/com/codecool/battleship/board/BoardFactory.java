package com.codecool.battleship.board;
import com.codecool.battleship.display.Display;
import com.codecool.battleship.ship.Ship;
import com.codecool.battleship.squere.Square;
import com.codecool.battleship.squere.SquareStatus;

import java.util.ArrayList;
import java.util.List;

public class BoardFactory {

    Display display = new Display();

//    public static Board manualPlacement(Ship ship) {
//        Board board =new Board();
//
//        for (int i = 0; i < ship.getSquareList().size(); i++) {
//            int newX = ship.getSquareList().get(i).getX();
//            int newY = ship.getSquareList().get(i).getY();
//            board.getBoard()[newX][newY] = new Square(newX, newY, SquareStatus.SHIP);
//        }
//        return board;
//    }


//    public String randomPlacement() {
//        List<String> firstCoordinate = display.getLetters();
//        List <Integer> secondCoord = new ArrayList<1,2,3>()
//
//    }


}
