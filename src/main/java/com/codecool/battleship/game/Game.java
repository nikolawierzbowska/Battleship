package com.codecool.battleship.game;

import com.codecool.battleship.board.BoardFactory;
import com.codecool.battleship.display.Display;
import com.codecool.battleship.input.Input;
import com.codecool.battleship.player.HumanPlayer;
import com.codecool.battleship.ship.Ship;
import com.codecool.battleship.ship.ShipType;

public class Game {

    private final Input inputPlayer = new Input();
    private final Display displayMessage = new Display();

    private Ship ship;

    HumanPlayer player1;
    HumanPlayer player2;

    BoardFactory board1 = new BoardFactory();
    BoardFactory board2 = new BoardFactory();

    int playerPlacement;

    private static final int MIN_VALUE_OF_NAME = 3;
    private static final int MAX_VALUE_OF_NAME = 10;
    private static final int MIN_VALUE_OF_PLACEMENT = 1;
    private static final int MAX_VALUE_OF_PLACEMENT = 2;
    private static final int MIN_VALUE_OF_SHIP = 1;
    private static final int MAX_VALUE_OF_SHIP = 5;



    public String getPlayerName() {
        String playerName;
        do {
            displayMessage.askForPlayerName();
            playerName = inputPlayer.inputPlayerString();
        }
        while (!inputPlayer.isInputPlayerNameIsValid(playerName, MIN_VALUE_OF_NAME, MAX_VALUE_OF_NAME));
        return playerName;
    }

    public int setRandomOrManualPlacement(HumanPlayer player) {
        int playerInput;
        do {
            displayMessage.askForRandomOrManualPlacement();
            playerInput = inputPlayer.inputPlayer();
        }
        while (!inputPlayer.isInputPlayerIsValid(playerInput, MIN_VALUE_OF_PLACEMENT, MAX_VALUE_OF_PLACEMENT));
        return playerInput;
    }


    public int[] getCoordinates() {
        String coordinates;
        int xCoordinate;
        int yCoordinate;
        do {
            coordinates = inputPlayer.putCoordinates();
        } while (!inputPlayer.isValidateCoordinatesInRange(coordinates));
        {
            String yCord = coordinates.substring(1);
            int yCordInt = Integer.parseInt(yCord) - 1;
            xCoordinate = (int) coordinates.toUpperCase().charAt(0) - 65;
            yCoordinate = yCordInt;
            System.out.println(xCoordinate);
            System.out.println(yCoordinate);
        }
        return new int[]{xCoordinate, yCoordinate};
    }


    public int askForTypeShip() {
        int typeOfShip;
        do {
            displayMessage.askForTypeOfShip();
            typeOfShip = inputPlayer.inputPlayer();
        }
        while (!inputPlayer.isInputPlayerIsValid(typeOfShip, MIN_VALUE_OF_SHIP, MAX_VALUE_OF_SHIP));

        return typeOfShip;
    }

    public ShipType getShipType() {
        int typeOfShip = askForTypeShip();
        ShipType type = null;
        switch (typeOfShip) {
            case 1 -> type = ShipType.CARRIER;
            case 2 -> type = ShipType.CRUISER;
            case 3 -> type = ShipType.BATTLESHIP;
            case 4 -> type = ShipType.SUBMARINE;
            case 5 -> type = ShipType.DESTROYER;
        }
        return type;
    }


    public String askForDirection() {
        displayMessage.askForDirection();
        String direction;
        do {
            direction = inputPlayer.inputPlayerString().toUpperCase();
        }
        while (!inputPlayer.isValidateDirection(direction));
        return direction;

    }


    public void createPlayerBoardWithShips(HumanPlayer player, BoardFactory boardFactory) {
        boolean correctCoordination = true;
        player = new HumanPlayer(getPlayerName());
        playerPlacement = setRandomOrManualPlacement(player);
        if (playerPlacement == 2) {
            displayMessage.printBoard(boardFactory.getBoard().getBoard());
            while (correctCoordination) {
                int numberOfShip = 5;
                while (numberOfShip > 0) {
                    int[] coordinates = getCoordinates();
                    int x = coordinates[0];
                    int y = coordinates[1];

                    ShipType type = getShipType();
                    String direction = askForDirection();
                    if (!boardFactory.getBoard().isPlacementOk(x, y, type, direction)) {
                        displayMessage.printWrongInputMessage();
                        correctCoordination = false;
                    } else {
                        ship = boardFactory.coordinatesOfShip(x, y, type, direction);
                        displayMessage.printBoard(boardFactory.manualPlacement(ship).getBoard());
                        numberOfShip--;
                    }

                }

            }
        }

    }


    public void playRoundToPutShips(){
        createPlayerBoardWithShips( player1, board1);

        createPlayerBoardWithShips( player2, board2);
    }

    public void startGame() {
        playRoundToPutShips();




    }

}







//
//
//    public void startGame() {
//        boolean correctCoordination = true;
//
//        String firstName = getPlayerName();
//        player1 = new HumanPlayer(firstName);
//        player1Placement = setRandomOrManualPlacement(player1);
//
//        if (player1Placement == 2) {
//            while (correctCoordination) {
//                int numberOfShip = 5;
//                while (numberOfShip > 0) {
//                    int[] coordinates = getCoordinates();
//                    int x = coordinates[0];
//                    int y = coordinates[1];
//
//                    ShipType type = getShipType();
//                    String direction = askForDirection();
//
//                    if (!board1.getBoard().isPlacementOk(x, y,  type, direction)) {
//                        correctCoordination = false;
//                    } else {
//                        ship = board1.coordinatesOfShip(x, y, type, direction);
//
//                        displayMessage.printBoard(board1.manualPlacement(ship).getBoard());
//                        numberOfShip--;
//                    }
//
//
//                }


//
//
//    public void startGame() {
//        boolean correctCoordination =true;
//
//       String firstName = getPlayerName();
//       player1 = new HumanPlayer(firstName);
//
//        player1Placement = setRandomOrManualPlacement(player1);
//
//
//        if(player1Placement == 2) {
//
//            while (correctCoordination) {
//                int numberOfShip = 5;
//                while (numberOfShip > 0) {
//                    int[] coordinates = getCoordinates();
//                    int x = coordinates[0];
//                    int y = coordinates[1];
//
//                    displayMessage.askForDirection();
//                    String direction;
//                    do {
//                        direction = inputPlayer.inputPlayerString().toUpperCase();
//                    }
//                    while (!inputPlayer.isValidateDirection(direction));
//
//
//                    int typeOfShip;
//                    do {
//                        displayMessage.askForTypeOfShip();
//                        typeOfShip = inputPlayer.inputPlayer();
//                    }
//                    while (!inputPlayer.isInputPlayerIsValid(typeOfShip, MIN_VALUE_OF_SHIP, MAX_VALUE_OF_SHIP));
//
//                    ShipType type = null;
//                    switch (typeOfShip) {
//
//                        case 1 -> type = ShipType.CARRIER;
//                        case 2 -> type = ShipType.CRUISER;
//                        case 3 -> type = ShipType.BATTLESHIP;
//                        case 4 -> type = ShipType.SUBMARINE;
//                        case 5 -> type = ShipType.DESTROYER;
//                    }
//
//
//                    if (!board1.getBoard().isPlacementOk(x, y, direction, type)) {
//                        correctCoordination = false;
//
//                    }else{
//                         ship= board1.coordinatesOfShip(x, y,  direction, type);
//
//                        displayMessage.printBoard(board1.manualPlacement(ship).getBoard());
//                        numberOfShip--;
//                        System.out.println(numberOfShip);
//                    }
//
//
//                }
//
//            }
//        }


//        playerName2 = setPlayerName(player2);
//        player2Placement = setRandomOrManualPlacement(player2);


//    }


//            }
//        }
//    }
//}
