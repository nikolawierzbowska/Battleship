package com.codecool.battleship.ship;

public enum ShipType {

    CARRIER(5),
    BATTLESHIP(4),
    CRUSIER(3),
    SUBMARINE(3),
    DESTROYER(2);
    private static final ShipType[] types = ShipType.values();

    private final int shipLength;

    ShipType(int i) {
        shipLength = i;
    }
    public static ShipType[] getTypes(){
        return types;
    }

    public int getShipLength() {
        return shipLength;
    }
}
