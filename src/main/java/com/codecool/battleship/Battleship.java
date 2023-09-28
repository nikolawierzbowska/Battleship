package com.codecool.battleship;

import com.codecool.battleship.display.Display;
import com.codecool.battleship.input.Input;

public class Battleship {
    private Input inputPlayer;
    private Display displayMessage;

    private static final int MIN_VALUE_OF_MENU = 1;
    private static final int MAX_VALUE_OF_MENU = 3;
    private static final int MIN_VALUE_OF_NAME = 3;
    private static final int MAX_VALUE_OF_NAME = 10;
    private static final int MIN_VALUE_OF_PLACEMENT = 1;
    private static final int MAX_VALUE_OF_PLACEMENT = 2;


    protected void displayMenu() {
        displayMessage = new Display();
//        displayMessage.askMenu();
//        displayMessage.putNumberMenu();

        displayMessage.askPlayerName();
//        displayMessage.askRandomOrManualPlacement();
//        displayMessage.askToCoordinates();


    }

    protected void choseNumberOfMenu(){
        inputPlayer = new Input();
//        inputPlayer.isInputPlayerIsValid(MIN_VALUE_OF_MENU, MAX_VALUE_OF_MENU);
//        inputPlayer.isInputPlayerIsValid(MIN_VALUE_OF_NAME, MAX_VALUE_OF_NAME);
//        inputPlayer.isInputPlayerIsValid(MIN_VALUE_OF_PLACEMENT, MAX_VALUE_OF_PLACEMENT);
//        inputPlayer.isValidateCoordinatesInRange();


        inputPlayer.isInputPlayerIsValid(MIN_VALUE_OF_NAME, MAX_VALUE_OF_NAME);





    }




}
