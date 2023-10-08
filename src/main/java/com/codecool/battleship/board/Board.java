package com.codecool.battleship.board;

import com.codecool.battleship.ship.Ship;
import com.codecool.battleship.ship.ShipType;
import com.codecool.battleship.square.Square;
import com.codecool.battleship.square.SquareStatus;

import java.util.ArrayList;
import java.util.List;

import static java.lang.Math.abs;

public class Board {
    private final List<Ship> ships = new ArrayList<>();
    private Square[][] sea;

    public Board() {
        fillTheBoardWithSquares();
    }

    private void fillTheBoardWithSquares() {
        sea = new Square[10][10];
        for (int row = 0; row < sea.length; row++) {
            for (int col = 0; col < sea.length; col++) {
                sea[row][col] = new Square(row, col, SquareStatus.EMPTY);
            }
        }
    }

    public void addShip(Ship ship) {
        ships.add(ship);
        for (Square square : ship.getSquares()) {
            sea[square.getX()][square.getY()] = square;
        }
    }

    public List<Ship> getShips() {
        return ships;
    }

    public Square[][] getSea() {
        return sea;
    }

    public boolean canNewShipBeHere(Position squareToCheck) {
        for (int x = -1; x < 2; x++) {
            for (int y = -1; y < 2; y++) {
                if (isInBound(new Position(squareToCheck.getX() + x, squareToCheck.getY() + y))) {
                    if (sea[squareToCheck.getX() + x][squareToCheck.getY() + y].getStatus() == SquareStatus.SHIP)
                        return false;
                }
            }
        }
        return true;
    }

    private boolean isThisSquareShipOrIsAShipNextToIt(Position bow, int shipPart,
                                                      Position shipPlacementDirection) {
        Position squareToCheck = new Position(
                bow.getX() + shipPart * shipPlacementDirection.getX(),
                bow.getY() + shipPart * shipPlacementDirection.getY());

        Position restOfTheShipDirection = new Position(
                -shipPlacementDirection.getX(),
                -shipPlacementDirection.getY());

        for (int x = -1; x < 2; x++) {
            for (int y = -1; y < 2; y++) {
                int xCoor = squareToCheck.getX() + x;
                int yCoor = squareToCheck.getY() + y;
                if (isInBound(new Position(xCoor, yCoor))) {
                    if (shipPart == 0) {
                        if (sea[xCoor][yCoor].getStatus() == SquareStatus.SHIP)
                            return true;
                    } else {
                        if (x != restOfTheShipDirection.getX() || y != restOfTheShipDirection.getY()
                        ) {
                            if (sea[xCoor][yCoor].getStatus() == SquareStatus.SHIP)
                                return true;
                        }
                    }
                }
            }
        }

        return false;
    }

    public boolean isPlacementOk(Position bow, Position stern, ShipType shipType) {
        if (!isInBound(bow) || !isInBound(stern)) return false;
        for (int shipPart = 0; shipPart < shipType.getShipLength(); shipPart++) {
            Position direction = getShipDirection(bow, stern);
            if (isThisSquareShipOrIsAShipNextToIt(bow, shipPart, direction)) return false;
        }
        return true;
    }

    private boolean isInBound(Position position) {
        if (position.getX() < 0 || position.getX() > sea.length - 1) return false;
        return !(position.getY() < 0 || position.getY() > sea.length - 1);
    }

    private Position getShipDirection(Position bow, Position stern) {
        int length = abs(stern.getY() - bow.getY() + stern.getX() - bow.getX());
        return new Position(
                (stern.getX() - bow.getX()) / length,
                (stern.getY() - bow.getY()) / length
        );
    }
}
