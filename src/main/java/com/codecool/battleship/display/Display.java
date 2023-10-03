package com.codecool.battleship.display;


import com.codecool.battleship.squere.Square;

import java.util.ArrayList;
import java.util.List;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Display {

    private final int sizeBoard = 10;


    public void askForPlayerName() {
        System.out.println("Put your name (from 3 char to 8char): ");
    }

    public void displayMenu() {
        System.out.println("1 - start new game\n2 - display high scores\n3 - exit");
    }

    public void putNumberMenu() {
        System.out.println("Please put the number: ");
    }

    public void askForRandomOrManualPlacement() {
        System.out.println(" How to placement ship - choose the number\n1 - random\n2 - manual");
    }

    public void askForDirection() {
        System.out.println("Please write down the correct direction:\nVU - VERTICAL UP, VD - VERTICAL DOWN, HR- HORIZONTAL RIGHT, HL - HORIZONTAL LEFT:  ");
    }

    public void askForTypeOfShip() {
        System.out.println("Please write the ship:\n1- CARRIER, 2- CRUISER,3- BATTLESHIP,4- SUBMARINE,5- DESTROYER: ");
    }



    public void askForCoordinates() {
        System.out.println("Put coordinates  ex.  a1 or A1?");
    }

    public void printWrongInputMessage() {
        System.out.println("Wrong input, try again!");
    }

    public void outcome() {
        System.out.println("The winner is .....");
    }


    public List<String> getLetters() {
        char character;
        List<String> letter = new ArrayList<>();
        char FIRST_LETTER = 'A';
        char LAST_LETTER = 'J';
        for (character = FIRST_LETTER; character <= LAST_LETTER; ++character) {
            letter.add(String.valueOf(character));
        }
        return letter;
    }

    private String printLetters() {
        String result = "    |";
        List<String> alphabet = getLetters();
        for (String letter : alphabet) {
            result += " " + letter + " " + " |";
        }
        result += " \n";
        return result;
    }


    public void printBoard(Square[][] ocean) {
        StringBuilder strBuilderBoard = new StringBuilder();
        strBuilderBoard.append(printLetters());
        for (int i = 0; i < sizeBoard; i++) {
            strBuilderBoard.append("     ");
            for (int k = 0; k < sizeBoard; k++) {
                strBuilderBoard.append("-----");
            }
            strBuilderBoard.append("\n");
            if (i < 9) {
                strBuilderBoard.append(" " + "0" + (i + 1) + " " + "|");
            } else {
                strBuilderBoard.append(" " + (i + 1) + " " + "|");
            }
            for (int j = 0; j < sizeBoard; j++) {
                strBuilderBoard.append(ocean[j][i].getSquareStatus().character);
                strBuilderBoard.append("|");
            }
            if (i < 9) {
                strBuilderBoard.append(" " + "0" + (i + 1) + " ");
            } else {
                strBuilderBoard.append(" " + (i + 1) + " ");
            }
            strBuilderBoard.append("\n");
        }
        strBuilderBoard.append("   ");
        for (int k = 0; k < sizeBoard; k++) {
            strBuilderBoard.append("-----");
        }
        strBuilderBoard.append("\n");
        strBuilderBoard.append(printLetters());
        System.out.println(strBuilderBoard);
    }


    public static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    public  void readFile() {
        String fileName = "C:\\Users\\nikol\\javaProjects\\battleship-oop-java-FenglerPiotr\\src\\main\\java\\com\\codecool\\battleship\\highScore.txt";
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        }catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Put number 4 to come back");


    }


}
