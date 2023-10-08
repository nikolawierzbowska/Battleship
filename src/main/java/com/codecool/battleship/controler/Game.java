package com.codecool.battleship.controler;

import com.codecool.battleship.board.Position;
import com.codecool.battleship.player.*;
import com.codecool.battleship.round.Round;
import com.codecool.battleship.square.SquareStatus;
import com.codecool.battleship.utils.Display;

public class Game {
    /**
     * Takes all the actions required to make single com.codecool.battleship.player's move.
     *
     * @param enemyPlayer - opposite com.codecool.battleship.player
     * @param playerShot - array with shot's coordinates
     * @return false if enemy lost the game, otherwise true
     */

    private final int TIME_TO_WAIT = 0;
    private int numberOfRounds = 0;
    HighScores highScores = new HighScores();
    private final Display display = new Display();
    private final Player player1;
    private final Player player2;
    private final Round round = new Round();
    private Player currentPlayer;
    private Player opponentPlayer;

    public Game(Player player1, Player player2) {
        this.player1 = player1;
        this.player2 = player2;
        currentPlayer = player1;
        opponentPlayer = player2;
    }

    public void playGame() {
        while (true) {
            display.clearScreen();
            numberOfRounds++;
            Position position = getPointsToShoot();

            boolean isEnemyAlive = round.playRound(opponentPlayer, position);

            if (isEnemyAlive) {
                continueGame();
                continue;
            }
            int score = (int)Math.ceil(numberOfRounds / 2.0);
            gameOver(score);
            highScores.checkIfPlayerResultIsHighScore(currentPlayer, score);
            break;
        }
    }

    private Position getPointsToShoot() {
        display.printPlayerRound(currentPlayer.getName());
        display.boardWithoutShips(opponentPlayer.getBoard().getSea());
        if (currentPlayer instanceof HumanPlayer) {
            boolean isPointNotCorrect = true;
            Position position;
            do {
                position = currentPlayer.getCoordinates();
                SquareStatus status = opponentPlayer.getBoard().getSea()[position.getX()][position.getY()].getStatus();
                if (status == SquareStatus.EMPTY || status == SquareStatus.SHIP)
                    isPointNotCorrect = false;
                else
                    display.printShotPositionRepeated();
            } while (isPointNotCorrect);
            return position;
        } else {
            return currentPlayer.getCoordinates();
        }
    }

    private void continueGame() {
        waitForSpecifiedTime(TIME_TO_WAIT);
        swapPlayers();
    }

    private void swapPlayers() {
        if (currentPlayer == player1) {
            currentPlayer = player2;
            opponentPlayer = player1;
        } else {
            currentPlayer = player1;
            opponentPlayer = player2;
        }
    }

    private void gameOver(int score) {
        display.boardWithoutShips(opponentPlayer.getBoard().getSea());
        display.gameOver(currentPlayer.getName(), score);
    }


    private void waitForSpecifiedTime(int timeToWait) {
        try {
            Thread.sleep(timeToWait);
        } catch (InterruptedException ie) {
            display.printExceptionMessage(ie.getMessage());
        }
    }
}