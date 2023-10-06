package com.codecool.battleship.board;
import com.codecool.battleship.ship.Ship;
import com.codecool.battleship.ship.ShipType;
import com.codecool.battleship.squere.Square;
import com.codecool.battleship.squere.SquareStatus;


public class Board {
    public final int BOARD_SIZE = 10;
    private final Square[][] ocean;


    public Board() {
        ocean = new Square[BOARD_SIZE][BOARD_SIZE];
        createBoard();
    }


    public void createBoard() {
        for (int i = 0; i < BOARD_SIZE; i++) {
            for (int j = 0; j < BOARD_SIZE; j++) {
                ocean[i][j] = new Square(i, j, SquareStatus.EMPTY);
            }
        }
    }

    public Square[][] getBoard() {
        return ocean;
    }


    public Ship createdShip(int x, int y, ShipType shipType, String direction) {
        Ship ship = new Ship();

        for (int i = 0; i < shipType.length; i++) {
            int newX = x;
            int newY = y;
            switch (direction) {
                case "VU" -> newY = y - i;
                case "VD" -> newY = y + i;
                case "HL" -> newX = x - i;
                case "HR" -> newX = x + i;
            }
            ship.getSquareList().add(ocean[newX][newY]);
            ocean[newX][newY].setSquareStatus(SquareStatus.SHIP);
            for (Square square : ship.getSquareList()) {
                if (square.getX() == x && square.getY() == y) {
                    square.setSquareStatus(SquareStatus.SHIP);
                }
            }
        }
        return ship;
    }


    public Square[][] manualPlacementOnBoard(Ship ship) {
        for (int i = 0; i < ship.getSquareList().size(); i++) {
            int newX =   ship.getSquareList().get(i).getX();
            int newY =   ship.getSquareList().get(i).getY();
            ocean[newX][newY] = new Square(newX, newY, SquareStatus.SHIP);
        }
        return ocean;
    }

    public boolean isVerticalDirectionCorrect(int x, int y, int shipLength, int a) {
        if (ocean[x][y].getSquareStatus() != SquareStatus.EMPTY) {
            return false;
        } else {
            for (int i = 0; i < shipLength; i++) {
                if (a == 1) {
                    if (y - i * a < 0) {
                        return false;
                    }
                    if (y - i * a > 0 && (ocean[x][y - i * a - a].getSquareStatus() != SquareStatus.EMPTY)) {
                        return false;
                    }
                }
                if (a == -1) {
                    if (y + i > BOARD_SIZE-1) {
                        return false;
                    }
                    if (y + i < 9 && (ocean[x][y + i + 1].getSquareStatus() != SquareStatus.EMPTY)) {
                        return false;
                    }
                }
                if (ocean[x][y - i * a].getSquareStatus() != SquareStatus.EMPTY) {
                    return false;
                }

                if((y-i) >0 && ocean[x][y -i].getSquareStatus() != SquareStatus.EMPTY) {
                    return false;
                }
                if (((x > 0 && x < 9) && (y > 0 && y < 9) && (ocean[x - 1][y - i * a].getSquareStatus() != SquareStatus.EMPTY)) ||
                        ((x > 0 && x < 9) && (y > 0 && y < 9) && (ocean[x + 1][y - i * a].getSquareStatus() != SquareStatus.EMPTY))) {
                    return false;
                }
                if (x == 0 && (ocean[x + 1][y - i * a].getSquareStatus() != SquareStatus.EMPTY)) {
                    return false;
                }
                if (x == 9 && (ocean[x - 1][y - i * a].getSquareStatus() != SquareStatus.EMPTY)) {
                    return false;
                }
            }
        }
        return true;
    }


    public boolean isHorizontalDirectionCorrect(int x, int y, int shipLength, int a) {
        if (ocean[x][y].getSquareStatus() != SquareStatus.EMPTY) {
            return false;
        } else {
            for (int i = 0; i < shipLength; i++) {
                if (a == 1) {
                    if (x - i * a < 0) {
                        return false;
                    }
                    if (x - i * a > 0 && (ocean[x - i - a][y].getSquareStatus() != SquareStatus.EMPTY)) {
                        return false;
                    }
                } else if (a == -1) {
                    if (x + i > BOARD_SIZE-1) {
                        return false;
                    }
                    if (x + i < 9 && (ocean[x + i - a][y].getSquareStatus() != SquareStatus.EMPTY)) {
                        return false;
                    }
                }
                if (ocean[x - i * a][y].getSquareStatus() != SquareStatus.EMPTY) {
                    return false;
                }

                if((y-i) >0 && ocean[x][y -i].getSquareStatus() != SquareStatus.EMPTY) {
                    return false;
                }
                if (((x > 0 && x < 9) && (y > 0 && y < 9) && (ocean[x - i * a][y - 1].getSquareStatus() != SquareStatus.EMPTY)) ||
                        ((x > 0 && x < 9) && (y > 0 && y < 9) &&    (ocean[x - i * a][y + 1].getSquareStatus() != SquareStatus.EMPTY))) {
                    return false;
                }
                if (y == 0 && (ocean[x - i * a][y + 1].getSquareStatus() != SquareStatus.EMPTY)) {
                    return false;
                }
                if (y == 9 && (ocean[x - i * a][y - 1].getSquareStatus() != SquareStatus.EMPTY)) {
                    return false;
                }
            }
        }
        return true;
    }

    public boolean isPlacementOk(int x, int y,  ShipType shipType, String direction) {
        boolean result = false;
        int shipLength = shipType.length;
        switch (direction) {
            case "VU" -> result = isVerticalDirectionCorrect(x, y, shipLength, 1);
            case "VD" -> result = isVerticalDirectionCorrect(x, y, shipLength, -1);
            case "HL" -> result = isHorizontalDirectionCorrect(x, y, shipLength, 1);
            case "HR" -> result = isHorizontalDirectionCorrect(x, y, shipLength, -1);
        }
        return result;
    }
}
