package com.codecool.battleship.input;

import com.codecool.battleship.display.Display;

import java.util.*;


public class Input {
    private Scanner scanner;
    private static final int MIN_VALUE_COORDINATE = 1;
    private static final int MAX_VALUE_COORDINATE = 10;
    private final Display MESSAGE = new Display();


    public int putInputPlayer() {
        this.scanner = new Scanner(System.in);
        int inputPlayer = scanner.nextInt();
        return inputPlayer;
    }


    public boolean isInputPlayerIsValid(int a, int b) {
        boolean isValidInput = false;
        while (!isValidInput) {
            try {
                int playerInput = putInputPlayer();

                if ((playerInput >= a && playerInput <= b )|| (Integer.toString(playerInput).length() >=a)) {
                    System.out.println("nit int");
                    isValidInput = true;

                }
                else {
                    MESSAGE.wrongInput();
                }
            } catch (InputMismatchException | NumberFormatException e) {
                MESSAGE.wrongInput();
                scanner.nextLine();
            }
        }
        return false;
    }


    public String putPlayerName() {
        this.scanner = new Scanner(System.in);
        String playerName = scanner.nextLine();
        return playerName;
    }


    public List<String> listLetter() {
        char character;
        List<String> letter = new ArrayList<>();
        char FIRST_LETTER = 'A';
        char LAST_LETTER = 'J';
        for (character = FIRST_LETTER; character <= LAST_LETTER; ++character) {
            letter.add(String.valueOf(character));
        }
        return letter;
    }


    public String putCoordinates() {
        this.scanner = new Scanner(System.in);
        String coordinates = scanner.nextLine();
        return coordinates;
    }

    public boolean isValidateCoordinatesInRange() {
        List<String> letters = listLetter();
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
