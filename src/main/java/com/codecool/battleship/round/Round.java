package com.codecool.battleship.round;

import com.codecool.battleship.board.Position;
import com.codecool.battleship.player.Player;
import com.codecool.battleship.ship.Ship;
import com.codecool.battleship.square.SquareStatus;
import com.codecool.battleship.utils.Display;

public class Round {
    private final Display display = new Display();

    public boolean playRound(Player opponent, Position position) {
        Ship currentShipToSunk = opponent.getShips()
                .stream()
                .filter(ship -> ship.getSquares().stream().anyMatch(square -> square.equals(position)))
                .findAny().orElse(null);

        opponent.getBoard().getSea()[position.getX()][position.getY()].updateSquareStatus();

        display.clearScreen();
        display.boardWithoutShips(opponent.getBoard().getSea());
        display.printSquareStatus(opponent.getBoard().getSea()[position.getX()][position.getY()]);

        if(currentShipToSunk != null)
            updateShipStatus(currentShipToSunk);
        return opponent.isAlive();
    }

    public void updateShipStatus(Ship ship) {
        if (!ship.isShipAlive())
            return;

        ship.setAlive(ship.getSquares().stream().anyMatch(square -> square.getStatus() != SquareStatus.HIT));
        if(!ship.isShipAlive())
            display.printShipSunk();

    }
}


