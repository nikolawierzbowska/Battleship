package com.codecool.battleship.square;

import com.codecool.battleship.board.Position;

public class Square extends Position {

    private SquareStatus status;
    public Square(int x,int y, SquareStatus status){
        super(x,y);
        this.status = status;
    }

    public Square(int x, int y) {
        super(x,y);
    }

    public String display () {
        return status.getCharacter();
    }

    public void updateSquareStatus(){
        if (status == SquareStatus.EMPTY) {
            status = SquareStatus.MISSED;
        } else if(status == SquareStatus.SHIP){
            status = SquareStatus.HIT;
        }
    }

    public SquareStatus getStatus(){
        return status;
    }

    public int getX() {
        return super.getX();
    }

    public int getY() {
        return super.getY();
    }

    @Override
    public boolean equals(Object o) {
        return super.equals(o);
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }
}
