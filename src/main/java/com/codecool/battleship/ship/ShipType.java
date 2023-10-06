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


    public  List<ShipType> getShipTypeList(){
        List<ShipType> typeShip =new ArrayList<>();
        typeShip.add(ShipType.DESTROYER);
        typeShip.add(ShipType.CRUISER);
        typeShip.add(ShipType.CARRIER);
        typeShip.add(ShipType.BATTLESHIP);
        typeShip.add(ShipType.SUBMARINE);
        return  typeShip;
    }


}
