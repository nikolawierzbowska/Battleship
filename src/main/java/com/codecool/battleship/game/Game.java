package com.codecool.battleship.game;

import com.codecool.battleship.board.Board;
import com.codecool.battleship.display.Display;
import com.codecool.battleship.input.Input;
import com.codecool.battleship.player.HumanPlayer;
import com.codecool.battleship.ship.Ship;
import com.codecool.battleship.ship.ShipType;
import com.codecool.battleship.squere.Square;
import com.codecool.battleship.squere.SquareStatus;

import java.util.ArrayList;
import java.util.List;

public class Game {

    private final Input inputPlayer = new Input();
    private final Display displayMessage = new Display();
    private Ship ship;
    private final HumanPlayer player1 = new HumanPlayer();
    private final HumanPlayer player2 = new HumanPlayer();


    private final Board board1 = new Board();
    private final Board board2 = new Board();
    private final Board boardShoot1 = new Board();
    private final Board boardShoot2 = new Board();

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
            playerName = inputPlayer.inputPlayerString().toUpperCase();
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
        return switch (askForTypeShip()) {
            case 1 -> ShipType.CARRIER;
            case 2 -> ShipType.CRUISER;
            case 3 -> ShipType.BATTLESHIP;
            case 4 -> ShipType.SUBMARINE;
            case 5 -> ShipType.DESTROYER;
            default -> throw new IllegalStateException("Unexpected value: ");
        };
    }


    public String askForDirection() {
        String direction;
        do {
            displayMessage.askForDirection();
            direction = inputPlayer.inputPlayerString().toUpperCase();
        }
        while (!inputPlayer.isValidateDirection(direction));
        return direction;

    }


    public void createPlayerBoardWithShips(HumanPlayer player, Board board, Board emptyBoard) {
        player.setName(getPlayerName());
        playerPlacement = setRandomOrManualPlacement(player);
        if (playerPlacement == 2) {
            displayMessage.printBoard(emptyBoard.getBoard());
            int numberOfShip = 1;
            do {
                displayMessage.printMessage(player.getName());
                displayMessage.printNumberOfShip(numberOfShip);
                int[] coordinates = getCoordinates();
                int x = coordinates[0];
                int y = coordinates[1];

                ShipType type = getShipType();
                String direction = askForDirection();
                if (!board.isPlacementOk(x, y, type, direction)) {
                    displayMessage.printWrongInputMessage();
                } else {
                    ship = board.createdShip(x, y, type, direction);

                    List<Ship> ships = new ArrayList<>();
                    ships.add(ship);
                    player.setShips(ships);
                    displayMessage.printBoard(board.manualPlacementOnBoard(ship));
                    --numberOfShip;
                }
            } while (numberOfShip > 0);

        }
    }


    public void playRoundToPutShips() {
        createPlayerBoardWithShips(player1, board1, boardShoot1);
        createPlayerBoardWithShips(player2, board2, boardShoot2);
    }


    public void shoot(HumanPlayer player, Board board, Board emptyBoard) {
        if (board == board1){
            displayMessage.printMessage(player2.getName());
        }else {
            displayMessage.printMessage(player1.getName());
        }

        displayMessage.printBoard(emptyBoard.getBoard());
        int[] coordinates = getCoordinates();
        int x = coordinates[0];
        int y = coordinates[1];


        if (board.getBoard()[x][y].getSquareStatus().equals(SquareStatus.SHIP)) {
            for (Ship ship : player.getShips()){
                for(Square s : ship.getSquareList()){
                    if (s.getX() == x && s.getY() == y) {
                        s.setSquareStatus(SquareStatus.HIT);

                        emptyBoard.getBoard()[x][y].setSquareStatus(SquareStatus.HIT);

                }



                }
            }

            int count = 0;
            for (Square s : ship.getSquareList()) {

                if (s.getSquareStatus().equals(SquareStatus.HIT)) {
                    count++;
                }
            }
                if(count == ship.getSquareList().size()){
                    for (Square sq : ship.getSquareList()) {
                        emptyBoard.getBoard()[sq.getX()][sq.getY()].setSquareStatus(SquareStatus.SUNK);

                    }
                    displayMessage.messageSunk();
                    displayMessage.printBoard(emptyBoard.getBoard());
                }
                else{
                    displayMessage.messageHit();
                    displayMessage.printBoard(emptyBoard.getBoard());

                }

        } else {
            displayMessage.messageMissed();
            emptyBoard.getBoard()[x][y].setSquareStatus(SquareStatus.MISSED);
            displayMessage.printBoard(emptyBoard.getBoard());
        }
    }


    public boolean startGame() {
        playRoundToPutShips();
        do {
            shoot(player2, board2, boardShoot2);
            if (player2.isAlive()) {
                shoot(player1, board1, boardShoot1);
            }
        }
        while (player1.isAlive() && player2.isAlive());

        if (player1.isAlive()) {
            displayMessage.gameEndMessage(player1.getName());
        }
        if(player2.isAlive()) {
            displayMessage.gameEndMessage(player2.getName());
        }
        return false;
    }
}
