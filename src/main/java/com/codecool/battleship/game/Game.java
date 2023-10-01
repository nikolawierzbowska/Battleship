package com.codecool.battleship.game;

import com.codecool.battleship.board.Board;
import com.codecool.battleship.board.BoardFactory;
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
    private static final int MIN_VALUE_OF_SHIP = 1;
    private static final int MAX_VALUE_OF_SHIP = 5;

    HumanPlayer player1 = new HumanPlayer();
    HumanPlayer player2 = new HumanPlayer();

    BoardFactory board1 = new BoardFactory();
    BoardFactory board2 = new BoardFactory();



    public String setPlayerName(HumanPlayer player) {
        String playerName;
        do {
            displayMessage.askForPlayerName();
            playerName = player.setName(inputPlayer.inputPlayerString());
        }
        while (!inputPlayer.isInputPlayerNameIsValid(playerName, MIN_VALUE_OF_NAME, MAX_VALUE_OF_NAME));
        return playerName;
    }

    public int setRandomOrManualPlacement(HumanPlayer player) {
        displayMessage.askForRandomOrManualPlacement();
        int playerInput;
        do {playerInput= inputPlayer.inputPlayer();
        }
        while (!inputPlayer.isInputPlayerIsValid(playerInput,MIN_VALUE_OF_PLACEMENT, MAX_VALUE_OF_PLACEMENT));
        return playerInput;
    }


    public void startGame() {


        playerName1 = setPlayerName(player1);
        player1Placement = setRandomOrManualPlacement(player1);



        int[] coordinates = inputPlayer.getCoordinates();
        int x = coordinates[0];
        int y = coordinates[1];

        displayMessage.askForDirection();
        String direction;
        do {direction=inputPlayer.inputPlayerString().toUpperCase();
        }
        while (!inputPlayer.isValidateDirection(direction));



        displayMessage.askForTypeOfShip();
        int typeOfShip;
        do {typeOfShip= inputPlayer.inputPlayer();
        }
        while (!inputPlayer.isInputPlayerIsValid(typeOfShip,MIN_VALUE_OF_SHIP, MAX_VALUE_OF_SHIP));

        ShipType type = null;
        switch (typeOfShip) {

            case 1 -> type = ShipType.CARRIER;
            case 2 -> type = ShipType.CRUISER;
            case 3 -> type = ShipType.BATTLESHIP;
            case 4 -> type = ShipType.SUBMARINE;
            case 5 -> type = ShipType.DESTROYER;
        }

        if(player1Placement == 2) {
            Board board = board1.manualPlacement(x,y,direction,type);
            displayMessage.printBoard(board.getBoard());

        }

//        playerName2 = setPlayerName(player2);
//        player2Placement = setRandomOrManualPlacement(player2);


    }


}
