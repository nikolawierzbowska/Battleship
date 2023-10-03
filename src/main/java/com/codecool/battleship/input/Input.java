package com.codecool.battleship.input;

import com.codecool.battleship.display.Display;

import java.util.*;


public class Input {
    private Scanner scanner;
    private static final int MIN_VALUE_COORDINATE = 1;
    private static final int MAX_VALUE_COORDINATE = 10;
    private final Display displayMessage = new Display();


    public int inputPlayer() {
        this.scanner = new Scanner(System.in);
        try {
            return scanner.nextInt();
        } catch (InputMismatchException | NumberFormatException e) {
            return -1;
        }

    }

    public String inputPlayerString() {
        this.scanner = new Scanner(System.in);
        try {
            return scanner.nextLine();
        } catch (InputMismatchException e) {
            return null;
        }
    }


    public boolean isInputPlayerIsValid(int playerInput, int a, int b) {
        if (playerInput >= a && playerInput <= b) {
            return true;
        } else {
            displayMessage.printWrongInputMessage();
        }
        return false;
    }

    public boolean isInputPlayerNameIsValid(String playerInputName, int a, int b) {
        if (playerInputName.length() >= a && playerInputName.length() <= b) {
            return true;
        } else {
            displayMessage.printWrongInputMessage();
        }
        return false;
    }


    public String putCoordinates() {
        displayMessage.askForCoordinates();
        this.scanner = new Scanner(System.in);
        try {
            return scanner.nextLine();
        } catch (InputMismatchException | NumberFormatException e) {
            return null;
        }

    }

    public boolean isValidateCoordinatesInRange(String coordinates) {
        List<String> letters = displayMessage.getLetters();
        String firstCoordinate = coordinates.substring(0, 1);
        String secondCoordinate = coordinates.substring(1);
        try{
            if (letters.contains(firstCoordinate.toUpperCase()) &&
                    Integer.parseInt(secondCoordinate) >= MIN_VALUE_COORDINATE &&
                    Integer.parseInt(secondCoordinate) <= MAX_VALUE_COORDINATE) {
                return true;
            } else {
                displayMessage.printWrongInputMessage();
            }
        } catch (InputMismatchException | NumberFormatException e){
            displayMessage.printWrongInputMessage();
        }

        return false;
    }



    public boolean isValidateDirection(String direction){
        return direction. equals("VU") || direction.equals("VD") || direction.equals("HL") || direction.equals("HR");
    }


}
