package com.codecool.battleship.display;


public class Display {

    public void askPlayerName() {
        System.out.println("Put your name (from 3 char to 8char): ");
    }

    public void askMenu() {
        System.out.println("1 - start new game\n2 - display high scores\n3 - exit");
    }

    public void putNumberMenu() {
        System.out.println("Please put the number: ");
    }


    public void askRandomOrManualPlacement() {
        System.out.println("Choose the number\n1 - random\n2 - manual");
    }


    public void askToCoordinates() {
        System.out.println("Put coordinates  ex.  a1 or A1?");
    }


    public void wrongInput() {
        System.out.println("Wrong input, try again!");
    }


    public void outcome() {
        System.out.println("The winner is .....");
    }


}
