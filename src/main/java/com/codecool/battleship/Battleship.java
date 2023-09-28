package com.codecool.battleship;

import com.codecool.battleship.display.Display;
import com.codecool.battleship.input.Input;

public class Battleship {
    private Input inputPlayer;
    private Display displayMessage;


    protected void displayMenu() {
        displayMessage = new Display();
//        displayMessage.askMenu();
//        displayMessage.putNumberMenu();

//        displayMessage.askPlayerName();
//        displayMessage.askRandomOrManualPlacement();
        displayMessage.askToCoordinates();


    }

    protected void choseNumberOfMenu(){
        inputPlayer = new Input();
//        inputPlayer.validateNumberOfMenu();
//        inputPlayer.putPlayerName();
//        inputPlayer.validateRandomOrManualPlacement();
        inputPlayer.validateCoordinatesInRange();




    }




}
