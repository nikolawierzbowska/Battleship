package com.codecool.battleship.input;

import com.codecool.battleship.display.Display;

import java.util.*;


public class Input {
    private Scanner scanner;
    private static final int MIN_VALUE_COORDINATE = 1;
    private static final int MAX_VALUE_COORDINATE = 10;
    private final Display MESSAGE = new Display();


    public int inputPlayer() {
        this.scanner = new Scanner(System.in);
        try {
            int inputPlayer = scanner.nextInt();
            return inputPlayer;
        } catch (InputMismatchException | NumberFormatException e) {
            return -1;
        }

    }

    public String inputPlayerName() {
        this.scanner = new Scanner(System.in);

        try {
            String inputPlayerName = scanner.nextLine();
            return inputPlayerName;
        } catch (InputMismatchException e) {
            return null;
        }

    }


    public boolean isInputPlayerIsValid(int playerInput, int a, int b) {
        if (playerInput >= a && playerInput <= b) {
            return true;
        } else {
            MESSAGE.wrongInput();
        }
        return false;
    }

    public boolean isInputPlayerNameIsValid(String playerInputName, int a, int b) {
        if (playerInputName.length() >= a && playerInputName.length() <= b) {
            return true;
        } else {
            MESSAGE.wrongInput();
        }

        return false;
    }


    public String putCoordinates() {
        this.scanner = new Scanner(System.in);
        String coordinates = scanner.nextLine();
        return coordinates;
    }

    public boolean isValidateCoordinatesInRange() {
        List<String> letters = MESSAGE.getLetters();
        boolean validCoordinatesInRange = false;
        while (!validCoordinatesInRange) {
            try {
                String coordinates = putCoordinates();
                String firstCoordinate = coordinates.substring(0, 1);
                String secondCoordinate = coordinates.substring(1);

                if (letters.contains(firstCoordinate.toUpperCase()) &&
                        Integer.parseInt(secondCoordinate) >= MIN_VALUE_COORDINATE &&
                        Integer.parseInt(secondCoordinate) <= MAX_VALUE_COORDINATE) {
                    validCoordinatesInRange = true;
                } else {
                    MESSAGE.wrongInput();
                }
            } catch (InputMismatchException | NumberFormatException e) {
                MESSAGE.wrongInput();
            }
        }
        return false;


    }


}
