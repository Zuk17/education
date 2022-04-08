package com.zuk17.battleship;

import java.util.ArrayList;
import java.util.List;

public class Ship {
    private final ShipTypes type;
    private final int length;
    private final List<Coordinate> coordAlive;

    boolean addedOnField;

    public Ship(ShipTypes name, int length) {
        this.type = name;
        this.length = length;
        coordAlive = new ArrayList<>();
        addedOnField = false;
    }

    public String toString() {
        return type + " (" + length + " cells)";
    }

    public boolean checkLength(Coordinates coord) {
        return (coord.getXLength() == length - 1 || coord.getYLength() == length - 1);
    }

    public void setCoords(Coordinates coords) {
        if (coords.getXLength() == 0)
            for (int i = coords.minY - 1; i < coords.maxY; i++)
                coordAlive.add(new Coordinate(coords.minX - 1, i));
        else
            for (int i = coords.minX - 1; i < coords.maxX; i++)
                coordAlive.add(new Coordinate(i, coords.minY - 1));
        if (Main.$DEBUG) System.out.println(coordAlive);
        addedOnField = true;
    }

    public boolean shipHit(Coordinate hit) {
        for (Coordinate coord : coordAlive) {

            if (Main.$DEBUG) System.out.println("Coord\t" + coord + "\t" + coord.getX() + "\t" + coord.getY());

            if (coord.equals(hit)) {
                coordAlive.remove(coord);
                return true;
            }
        }
        return false;
    }

    public boolean isAlive() {
        return !coordAlive.isEmpty();
    }

    public List<Coordinate> getCoordAlive() {
        return coordAlive;
    }

    public boolean isAddedOnField() {
        return addedOnField;
    }

    public ShipTypes getType() {
        return type;
    }
}

