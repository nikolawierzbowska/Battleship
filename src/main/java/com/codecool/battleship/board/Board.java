package com.codecool.battleship.board;

import com.codecool.battleship.ship.ShipType;
import com.codecool.battleship.squere.Square;
import com.codecool.battleship.squere.SquareStatus;

public class Board {
    public final int BOARD_SIZE = 10;
    private Square[][] ocean;


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

    public void setOcean(Square[][] ocean, int x, int y) {
        this.ocean = ocean;
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
                } else if (a == -1) {
                    if (y + i > BOARD_SIZE) {
                        return false;
                    }
                    if (y + i < 9 && (ocean[x][y + i + 1].getSquareStatus() != SquareStatus.EMPTY)) {
                        return false;
                    }
                }
                if (ocean[x][y - i * a].getSquareStatus() != SquareStatus.EMPTY) {
                    return false;
                }
                if ((x > 0 && x < 9) && (y > 0 && y < 9) && (ocean[x - 1][y - i * a].getSquareStatus() != SquareStatus.EMPTY) &&
                        (ocean[x + 1][y - i * a].getSquareStatus() != SquareStatus.EMPTY)) {
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
                    if (x + i > BOARD_SIZE) {
                        return false;
                    }
                    if (x + i < 9 && (ocean[x][y + i - a].getSquareStatus() != SquareStatus.EMPTY)) {
                        return false;
                    }
                }
                if (ocean[x - i * a][y].getSquareStatus() != SquareStatus.EMPTY) {
                    return false;
                }
                if ((x > 0 && x < 9) && (y > 0 && y < 9) && (ocean[x - i * a][y - 1].getSquareStatus() != SquareStatus.EMPTY) &&
                        (ocean[x - i * a][y + 1].getSquareStatus() != SquareStatus.EMPTY)) {
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

    public boolean isPlacementOk(int x, int y, String direction, ShipType shipType) {
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


//    public boolean isPlacementOk(int x, int y, String direction, ShipType shipType) {
//        int shipLength = shipType.length;
//
//        if (ocean[x][y].getSquareStatus() != SquareStatus.EMPTY) {
//            return false;
//        } else {
//            for (int i = 0; i < shipLength; i++) {
//                if (direction.equals("VU")) {
//                    if (y - i < 0) {
//                        return false;
//                    }
//                    if (ocean[x][y - i].getSquareStatus() != SquareStatus.EMPTY) {
//                        return false;
//                    }
//                    if (y - i > 0 && (ocean[x][y - i - 1].getSquareStatus() != SquareStatus.EMPTY)) {
//                        return false;
//                    }
//                    if ((x > 0 && x < 9) && (y > 0 && y < 9) && (ocean[x - 1][y - i].getSquareStatus() != SquareStatus.EMPTY) &&
//                            (ocean[x + 1][y - i].getSquareStatus() != SquareStatus.EMPTY)) {
//                        return false;
//                    }
//                    if (x == 0 && (ocean[x + 1][y - i].getSquareStatus() != SquareStatus.EMPTY)) {
//                        return false;
//                    }
//                    if (x == 9 && (ocean[x - 1][y - i].getSquareStatus() != SquareStatus.EMPTY)) {
//                        return false;
//                    }
//                } else if (direction.equals("VD")) {
//
//                    if (y + i > BOARD_SIZE) {
//                        return false;
//                    }
//                    if (ocean[x][y + i].getSquareStatus() != SquareStatus.EMPTY) {
//                        return false;
//                    }
//                    if (y + i <9 && (ocean[x][y + i + 1].getSquareStatus() != SquareStatus.EMPTY)) {
//                        return false;
//                    }
//                    if ((x > 0 && x < 9) && (y > 0 && y < 9) && (ocean[x - 1][y + i].getSquareStatus() != SquareStatus.EMPTY) &&
//                            (ocean[x + 1][y + i].getSquareStatus() != SquareStatus.EMPTY)) {
//                        return false;
//                    }
//                    if (x == 0 && (ocean[x + 1][y + i].getSquareStatus() != SquareStatus.EMPTY)) {
//                        return false;
//                    }
//                    if (x == 9 && (ocean[x - 1][y + i].getSquareStatus() != SquareStatus.EMPTY)) {
//                        return false;
//                    }
//                } else if (direction.equals("HL")) {
//                    if (x - i < 0) {
//                        return false;
//                    }
//                    if (ocean[x - i][y].getSquareStatus() != SquareStatus.EMPTY) {
//                        return false;
//                    }
//                    if (x - i > 0 && (ocean[x - i - 1][y].getSquareStatus() != SquareStatus.EMPTY)) {
//                        return false;
//                    }
//                    if ((x > 0 && x < 9) && (y > 0 && y < 9) && (ocean[x - i][y - 1].getSquareStatus() != SquareStatus.EMPTY) &&
//                            (ocean[x - i][y + 1].getSquareStatus() != SquareStatus.EMPTY)) {
//                        return false;
//                    }
//                    if (y == 0 && (ocean[x - i][y + 1].getSquareStatus() != SquareStatus.EMPTY)) {
//                        return false;
//                    }
//                    if (y == 9 && (ocean[x - i][y - 1].getSquareStatus() != SquareStatus.EMPTY)) {
//                        return false;
//                    }
//                } else if (direction.equals("HR")) {
//                    if (x + i > BOARD_SIZE) {
//                        return false;
//                    }
//                    if (ocean[x + i][y].getSquareStatus() != SquareStatus.EMPTY) {
//                        return false;
//                    }
//                    if (x + i < 9 && (ocean[x + i + 1][y].getSquareStatus() != SquareStatus.EMPTY)) {
//                        return false;
//                    }
//                    if ((x > 0 && x < 9) && (y > 0 && y < 9) && (ocean[x + i][y - 1].getSquareStatus() != SquareStatus.EMPTY) &&
//                            (ocean[x + i][y + 1].getSquareStatus() != SquareStatus.EMPTY)) {
//                        return false;
//                    }
//                    if (y == 0 && (ocean[x + i][y + 1].getSquareStatus() != SquareStatus.EMPTY)) {
//                        return false;
//                    }
//                    if (y == 9 && (ocean[x + i][y - 1].getSquareStatus() != SquareStatus.EMPTY)) {
//                        return false;
//                    }
//                }
//
//
//            }
//            return true;
//        }
//    }


}