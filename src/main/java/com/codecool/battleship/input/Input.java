package com.codecool.battleship.input;

import com.codecool.battleship.display.Display;

import java.util.*;


public class Input {
    private Scanner scanner;
    private static final int MIN_VALUE_COORDINATE = 1;
    private static final int MAX_VALUE_COORDINATE = 10;
    private final Display DISPLAY_MESSAGE = new Display();


    public int inputPlayer() {
        this.scanner = new Scanner(System.in);
        try {
            int inputPlayer = scanner.nextInt();
            return inputPlayer;
        } catch (InputMismatchException | NumberFormatException e) {
            return -1;
        }

    }

    public String inputPlayerString() {
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
            DISPLAY_MESSAGE.printWrongInputMessage();
        }
        return false;
    }

    public boolean isInputPlayerNameIsValid(String playerInputName, int a, int b) {
        if (playerInputName.length() >= a && playerInputName.length() <= b) {
            return true;
        } else {
            DISPLAY_MESSAGE.printWrongInputMessage();
        }

        return false;
    }


    public String putCoordinates() {
        DISPLAY_MESSAGE.askForCoordinates();
        this.scanner = new Scanner(System.in);
        try {
            String coordinates = scanner.nextLine();
            return coordinates;
        } catch (InputMismatchException e) {
            return null;
        }

    }

    public boolean isValidateCoordinatesInRange(String coordinates) {
        List<String> letters = DISPLAY_MESSAGE.getLetters();
        String firstCoordinate = coordinates.substring(0, 1);
        String secondCoordinate = coordinates.substring(1);

        if (letters.contains(firstCoordinate.toUpperCase()) &&
                Integer.parseInt(secondCoordinate) >= MIN_VALUE_COORDINATE &&
                Integer.parseInt(secondCoordinate) <= MAX_VALUE_COORDINATE) {
            return true;
        } else {
            DISPLAY_MESSAGE.printWrongInputMessage();
        }


        return false;
    }

    public int[] getCoordinates() {
        String coordinates;

        int xCoordinate;
        int yCoordinate;
        do {
            coordinates = putCoordinates();
        } while (!isValidateCoordinatesInRange(coordinates));

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

    public boolean isValidateDirection(String direction){

        return direction. equals("VU") || direction.equals("VD") || direction.equals("HL") || direction.equals("HR");

    }


}
