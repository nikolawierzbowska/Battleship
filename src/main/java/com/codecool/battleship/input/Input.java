package com.codecool.battleship.input;

import java.util.Scanner;

public class Input {

    private String numberOfMenu;
    private String coordinate;
    private String playerName;





    private Scanner putPlayerName(){
        Scanner scanner = new Scanner(System.in);
        playerName = scanner.nextLine();

        return null;
    }





    public String getNumberOfMenu() {
        return numberOfMenu;
    }

    public void setNumberOfMenu(String numberOfMenu) {
        this.numberOfMenu = numberOfMenu;
    }

    public String getCoordinate() {
        return coordinate;
    }

    public void setCoordinate(String coordinate) {
        this.coordinate = coordinate;
    }

    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }
}
