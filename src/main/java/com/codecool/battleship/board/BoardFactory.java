package com.codecool.battleship.board;
import com.codecool.battleship.player.HumanPlayer;

public class BoardFactory {
    Board board;


    private HumanPlayer player = new HumanPlayer();





    public Board getBoard() {
        return board;
    }




//    public Board manualPlacement() {
//
//        for (int i = 0; i < ship.getSquareList().size(); i++) {
//            int newX =   ship.getSquareList().get(i).getX();
//            int newY =   ship.getSquareList().get(i).getY();
//
//
//            board.getBoard()[newX][newY] = new Square(newX, newY, SquareStatus.SHIP);
//        }
//
//        return board;
//    }


    public String randomPlacement() {
        return null;

    }


}
