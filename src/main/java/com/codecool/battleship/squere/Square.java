package com.codecool.battleship.squere;

public class Square {
    private int x;
    private int y;
    private SquareStatus squareStatus;



    public Square(int x, int y,SquareStatus squareStatus ) {
        this.x = x;
        this.y = y;
        this.squareStatus = squareStatus;

    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public SquareStatus getSquareStatus() {
        return squareStatus;
    }

    public void setSquareStatus(SquareStatus squareStatus) {
        this.squareStatus = squareStatus;
    }



    //    The Square class has method that returns a graphical representation of SquareStatus

}
