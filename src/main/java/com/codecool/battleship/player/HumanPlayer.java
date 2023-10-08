package com.codecool.battleship.player;

import com.codecool.battleship.board.*;
import com.codecool.battleship.utils.Display;
import com.codecool.battleship.utils.Input;

public class HumanPlayer extends Player {
    private final Display display = new Display();
    private final Input input = new Input();

    public HumanPlayer(Board board, String name) {
        super(board, name);
    }

    @Override
    public Position getCoordinates() {
        display.chooseCoordinates();
        return input.getShot();
    }
}
