package com.codecool.battleship;

import com.codecool.battleship.board.Board;
import com.codecool.battleship.display.Display;
import com.codecool.battleship.game.Game;
import com.codecool.battleship.input.Input;

public class Battleship {
    private final Input inputPlayer = new Input();
    private final Display displayMessage = new Display();

    private Board ocean;

    private static final int MIN_VALUE_OF_MENU = 1;
    private static final int MAX_VALUE_OF_MENU = 3;
    private static final int VALUE_OF_COME_BACK = 4;


//    this.ocean = new Board();
//        displayMessage.printBoard(ocean.getBoard());


    public void displayMenu() {
        displayMessage.displayMenu();
        displayMessage.putNumberMenu();
    }



//        inputPlayer.isValidateCoordinatesInRange();






    public void runProgram(){
        boolean isFinished = false;
        while(! isFinished) {
            displayMenu();
            int playerInput;
            do {playerInput= inputPlayer.inputPlayer();
            }
            while (!inputPlayer.isInputPlayerIsValid(playerInput,MIN_VALUE_OF_MENU, MAX_VALUE_OF_MENU));
            if(playerInput ==1){
                Game game = new Game();
                game.startGame();

            }else if(playerInput ==2){
                displayMessage.readFile();
                do {playerInput= inputPlayer.inputPlayer();
                }
                while (!(inputPlayer.isInputPlayerIsValid(playerInput,VALUE_OF_COME_BACK, VALUE_OF_COME_BACK)));

            }else {
                System.exit(3);
                isFinished = true;
            }

        }

    }

}





