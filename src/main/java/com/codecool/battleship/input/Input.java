package com.codecool.battleship.input;

import com.codecool.battleship.display.Display;
import com.sun.source.tree.BreakTree;

import java.util.*;

public class Input {
    private Scanner scanner;
    private final List<Integer> CORRECT_NUMBERS_OF_MENU = new ArrayList<>(Arrays.asList(1, 2, 3));
    private final List<Integer> CORRECT_NUMBERS_OF_PLACEMENT = new ArrayList<>(Arrays.asList(1, 2));
    private final List<Integer> LIST_OF_COORDINATES_NUMBERS = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10));

    Display message = new Display();


    public int putTheNumberOfMenu() {
        this.scanner = new Scanner(System.in);
        int numberOfMenu = scanner.nextInt();
        return numberOfMenu;
    }

    public boolean validateNumberOfMenu() {
        boolean validNumberOfMenu = false;
        while (!validNumberOfMenu) {
            try {
                int numberMenu = putTheNumberOfMenu();
                if (CORRECT_NUMBERS_OF_MENU.contains(numberMenu)) {
                    validNumberOfMenu = true;
                } else {
                    message.wrongInput();
                }
            } catch (InputMismatchException e) {
                message.wrongInput();
            }
        }
        return false;
    }


    public String putPlayerName() {
        this.scanner = new Scanner(System.in);
        String playerName = scanner.nextLine();
        return playerName;
    }


    public int putRandomOrManualPlacement() {
        this.scanner = new Scanner(System.in);
        int RandomOrManualPlacement = scanner.nextInt();
        return RandomOrManualPlacement;
    }

    public boolean validateRandomOrManualPlacement() {
        boolean validRandomOrManualPlacement = false;
        while (!validRandomOrManualPlacement) {
            try {
                int number = putRandomOrManualPlacement();
                if (CORRECT_NUMBERS_OF_PLACEMENT.contains(number)) {
                    validRandomOrManualPlacement = true;
                } else {
                    message.wrongInput();
                }
            } catch (InputMismatchException e) {
                message.wrongInput();
            }
        }
        return false;
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

    public boolean validateCoordinatesInRange() {
        List<String> letters = listLetter();
        boolean validCoordinatesInRange = false;
        while (!validCoordinatesInRange) {
            try {
                String coordinates = putCoordinates();
                String firstCoordinate = coordinates.substring(0, 1);
                System.out.println(firstCoordinate);

                String secondCoordinate = coordinates.substring(1);
                System.out.println(secondCoordinate);

                if (letters.contains(firstCoordinate.toUpperCase()) && LIST_OF_COORDINATES_NUMBERS.contains(Integer.parseInt(secondCoordinate))){
                    validCoordinatesInRange = true;
                }else{
                    message.wrongInput();
                }
            }
            catch (InputMismatchException e ) {
                message.wrongInput();
            }
        }
        return false;
    }


}
