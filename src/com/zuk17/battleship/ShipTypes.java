package com.zuk17.battleship;

public enum ShipTypes {

    AIRCRAFT("Aircraft Carrier", 5, "J1", "J5"),
    BATTLESHIP("Battleship", 4, "A1", "A4"),
    SUBMARINE("Submarine", 3, "A6", "A8"),
    CRUISER("Cruiser", 3, "C1", "C3"),
    DESTROYER("Destroyer", 2, "J9", "J10");

    private final String name;
    private final int length;
    private final String coord1;
    private final String coord2;


    ShipTypes(String name, int length, String coord1, String coord2) {
        this.name = name;
        this.length = length;
        this.coord1 = coord1;
        this.coord2 = coord2;
    }

    public String toString() {
        return String.valueOf(name);
    }

    int lengthOf() {
        return length;
    }

    public String getCoord1() {
        return coord1;
    }

    public String getCoord2() {
        return coord2;
    }
}
