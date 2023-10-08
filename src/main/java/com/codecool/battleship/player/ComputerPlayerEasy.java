package com.codecool.battleship.player;

import com.codecool.battleship.board.*;
import java.util.concurrent.ThreadLocalRandom;

public class ComputerPlayerEasy extends Player {
    protected Board opponentBoard;

    public ComputerPlayerEasy(Board board, String name) {
        super(board, name);
    }

    public void setUpOpponentBoard(Board opponentBoard){
        this.opponentBoard = opponentBoard;
    }

    @Override
    public Position getCoordinates() {
        int x = ThreadLocalRandom.current().nextInt(super.getBoard().getSea().length);
        int y = ThreadLocalRandom.current().nextInt(super.getBoard().getSea().length);
        return new Position(x, y);
    }

}
