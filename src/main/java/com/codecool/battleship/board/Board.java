package com.codecool.battleship.board;

import com.codecool.battleship.squere.Square;
import com.codecool.battleship.squere.SquareStatus;

import java.util.Arrays;

public class Board {
    public final int  BOARD_SIZE =10;
    private Square[][] ocean;



    public Board(){
        ocean = new Square[BOARD_SIZE][BOARD_SIZE];
        createOcean();
        }


    public void createOcean() {
        for (int i = 0; i < BOARD_SIZE; i++) {
            for (int j = 0; j < BOARD_SIZE; j++) {
                ocean[i][j] = new Square(i, j, SquareStatus.EMPTY);
            }
        }
    }

    public Square[][] getBoard() {
        return ocean;
    }

    public boolean isPlacementOk(){
        System.out.println("ok");

        return false;
    }




}