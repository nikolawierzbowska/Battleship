package com.codecool.battleship.board;

import com.codecool.battleship.controler.SeaBattle;
import com.codecool.battleship.ship.Ship;
import com.codecool.battleship.ship.ShipType;
import com.codecool.battleship.square.Square;
import com.codecool.battleship.square.SquareStatus;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BoardFactory {

    public Board randomPlacement() {
        Board board = new Board();
        int boardLength = board.getSea().length;
        ShipType[] shipTypes = ShipType.getTypes();
        for (ShipType shipType : shipTypes) {
            Position bow;
            Position stern;
            do {
                bow = getRandomPosition(boardLength);
                Direction direction = Direction.values()[getRandomInt(0, Direction.values().length - 1)];
                stern = new Position(
                        bow.getX() + direction.getValue().getX() * shipType.getShipLength(),
                        bow.getY() + direction.getValue().getY() * shipType.getShipLength()
                );
            } while (!board.isPlacementOk(bow, stern, shipType));
            board.addShip(createShip(bow, stern, shipType));
        }
        return board;
    }

    /**
     * return random int in range < min, max >. The numbers at the ends of the range are included.
     */
    private int getRandomInt(int min, int max) {
        return (int) ((Math.random() * (max - min + 2)) + min - 1);
    }

    private Position getRandomPosition(int boardLength) {
        return new Position(getRandomInt(0, boardLength - 1), getRandomInt(0, boardLength - 1));
    }

    private Ship createShip(Position bow, Position stern, ShipType shipType) {
        List<Square> squares = new ArrayList<>();
        for (int partOfShip = 0; partOfShip < shipType.getShipLength(); partOfShip++) {
            squares.add(
                    new Square(bow.getX() + partOfShip * (stern.getX() - bow.getX()) / shipType.getShipLength(),
                            bow.getY() + partOfShip * (stern.getY() - bow.getY()) / shipType.getShipLength(),
                            SquareStatus.SHIP));
        }
        return new Ship(squares, shipType);
    }

    public Board manualPlacement(SeaBattle seaBattle) {
        Board board = new Board();
        Arrays.stream(ShipType.getTypes()).forEach(shipType -> {
            Position bow;
            Position stern;
            do {
                seaBattle.getDisplay().clearScreen();
                bow = seaBattle.askForPlacementCoordinates(shipType, board);
                Direction direction = seaBattle.askForPlacementDirection();
                stern = new Position(
                        bow.getX() + direction.getValue().getX() * shipType.getShipLength(),
                        bow.getY() + direction.getValue().getY() * shipType.getShipLength()
                );
                if (!board.isPlacementOk(bow, stern, shipType))
                    seaBattle.getDisplay().printWrongShipPlacementMessage();
            } while (!board.isPlacementOk(bow, stern, shipType));
            board.addShip(createShip(bow, stern, shipType));
        });
        return board;
    }
}
