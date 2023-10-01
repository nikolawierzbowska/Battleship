package com.codecool.battleship.ship;

import java.util.ArrayList;
import java.util.List;

public enum ShipType {
    CARRIER(5), CRUISER(3), BATTLESHIP(4), SUBMARINE(3), DESTROYER(2);

    public ShipType shipType;
    public final int length;


    ShipType(int length) {
        this.length = length;
    }

    public ShipType getShipType() {
        return shipType;
    }

    public void setShipType(ShipType shipType) {
        this.shipType = shipType;
    }


//    public static List<ShipType> getListShips(){
//        List<ShipType> typeShips = new ArrayList<>();
//        typeShips.add(ShipType.CARRIER);
//        typeShips.add(ShipType.CRUISER);
//        typeShips.add(ShipType.BATTLESHIP);
//        typeShips.add(ShipType.SUBMARINE);
//        typeShips.add(ShipType.DESTROYER);
//    return typeShips;
//    }

}
