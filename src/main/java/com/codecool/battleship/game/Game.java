package com.codecool.battleship.game;

import com.codecool.battleship.display.Display;
import com.codecool.battleship.input.Input;
import com.codecool.battleship.player.HumanPlayer;
import com.codecool.battleship.ship.ShipType;

public class Game {

    private final Input inputPlayer = new Input();
    private final Display displayMessage = new Display();
    private ShipType shipType;
    //    private final Square square = new Square();
    protected String playerName1;
    protected String playerName2;

    int player1Placement;
    int player2Placement;
    private static final int MIN_VALUE_OF_NAME = 3;
    private static final int MAX_VALUE_OF_NAME = 10;
    private static final int MIN_VALUE_OF_PLACEMENT = 1;
    private static final int MAX_VALUE_OF_PLACEMENT = 2;
    HumanPlayer player1 = new HumanPlayer();
    HumanPlayer player2 = new HumanPlayer();


    public String getPlayerName(HumanPlayer player) {
        String playerName;
        do {
            displayMessage.askPlayerName();
            playerName = player1.setName(inputPlayer.inputPlayerName());
        }
        while (!inputPlayer.isInputPlayerNameIsValid(playerName, MIN_VALUE_OF_NAME, MAX_VALUE_OF_NAME));
        return playerName;
    }

    public int getRandomOrManualPlacement(HumanPlayer player) {
        displayMessage.askRandomOrManualPlacement();
        int playerInput;
        do {playerInput= inputPlayer.inputPlayer();
        }
        while (!inputPlayer.isInputPlayerIsValid(playerInput,MIN_VALUE_OF_PLACEMENT, MAX_VALUE_OF_PLACEMENT));
        return playerInput;
    }


    public void startGame() {
        playerName1 = getPlayerName(player1);
        player1Placement = getRandomOrManualPlacement(player1);




        playerName2 = getPlayerName(player2);
        player2Placement = getRandomOrManualPlacement(player2);


    }


}
