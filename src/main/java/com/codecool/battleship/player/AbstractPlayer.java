package com.codecool.battleship.player;

public abstract class AbstractPlayer implements Player {

    protected String name;

    public AbstractPlayer(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
