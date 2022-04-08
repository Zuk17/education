package com.zuk17.battleship;

import java.util.ArrayList;
import java.util.List;

public class Field {
    private static int sizeA = 10;
    private static int size1 = 10;
    private static char[] rows; //create first field column
    private static String columns;

    private boolean alive;
    private Mark[][] field;

    List<Ship> ListShips = new ArrayList<>();

    public Field(int sizeA, int size1) {
        Field.sizeA = Math.min(sizeA, 26);
        Field.size1 = size1;
        rows = new char[sizeA];
        for (ShipTypes a : ShipTypes.values())
            ListShips.add(new Ship(a, a.lengthOf()));
        Init();
        alive = true;
    }

    private void Init() {
        field = new Mark[sizeA][size1];

        for (int i = 0; i < sizeA; i++) {
            rows[i] = (char) ('A' + i);
            for (int j = 0; j < size1; j++)
                field[i][j] = Mark.FOG;
        }

        //Create header for field
        StringBuilder columnStr = new StringBuilder(" ");
        for (int i = 1; i <= size1; i++)
            columnStr.append(" ").append(i);

        columns = columnStr.toString();
    }

    // Print field
    public String printField(Mark fog) {
        StringBuilder output = new StringBuilder(columns).append("\n");
        for (int i = 0; i < sizeA; i++)
            output.append(rows[i]).append(" ").append(str(field[i], fog)).append("\n");

        if (fog == Mark.FOG) output.append("---------------------");
        else output.append("\n");

        return output.toString();
    }

    // sub method for printing field
    private String str(Mark[] strField, Mark fog) {
        StringBuilder output = new StringBuilder();
        for (Mark a : strField)
            if (a == Mark.SHIP && fog == Mark.FOG) output.append(Mark.FOG.valueOf()).append(" ");
            else output.append(a.valueOf()).append(" ");
        return output.toString();
    }

    public String addShipToField(Ship ship, Coordinates coords) {
        //check location
        if (isNotOnField(coords.getBegin()) || isNotOnField(coords.getEnd()) ||
                coords.isNotStraight())
            return "\nError! Wrong ship location! Try again:\n";

        //Check length
        if (!ship.checkLength(coords))
            return "\nError! Wrong length of the " + ship + "! Try again:\n";

        if (!checkArea(coords))
            return "\nError! You placed it too close to another one. Try again:\n";

        ship.setCoords(coords); //для корабля
        setCoords(ship); //для поля
        return "";
    }

    private void setCoords(Ship ship) {
        for (Coordinate coord : ship.getCoordAlive())
            field[coord.getX()][coord.getY()] = Mark.SHIP;
    }

    private boolean checkArea(Coordinates coords) {
        int minX = coords.minX > 1 ? coords.minX - 1 : coords.minX;
        int minY = coords.minY > 1 ? coords.minY - 1 : coords.minY;

        int maxX = coords.maxX < sizeA ? coords.maxX + 1 : coords.maxX;
        int maxY = coords.maxY < size1 ? coords.maxY + 1 : coords.maxY;

        for (int i = minX; i <= maxX; i++)
            for (int j = minY; j <= maxY; j++)
                if (field[i - 1][j - 1] != Mark.FOG) return false;
        return true;
    }

    private boolean isNotOnField(Coordinate coord) {
        return (coord == null) ||
                (coord.getX() > sizeA || coord.getY() > size1) ||
                (coord.getX() < 1 || coord.getY() < 1);
    }

    public String hit(Coordinate hitPlusOne) {
        if (isNotOnField(hitPlusOne))
            return "Error! You entered the wrong coordinates! Try again:";

        Coordinate hit = new Coordinate(hitPlusOne.getX() - 1, hitPlusOne.getY() - 1);
        if (field[hit.getX()][hit.getY()] == Mark.FOG || field[hit.getX()][hit.getY()] == Mark.MISS) {
            field[hit.getX()][hit.getY()] = Mark.MISS;
            return "\nYou missed! Try again:\n";
        }

        field[hit.getX()][hit.getY()] = Mark.HIT;
        return checkAlive(hit);
    }

    private String checkAlive(Coordinate hit) {

        if (Main.$DEBUG) System.out.println("Hit:\t" + hit + "\t" + hit.getX() + "\t" + hit.getY() + "\n");

        for (Ship ship : ListShips)
            if (ship.shipHit(hit))
                if (ship.isAlive()) {
                    return "\nYou hit a ship! Try again:\n";
                } else {
                    ListShips.remove(ship);
                    if (!ListShips.isEmpty())
                        return "\nYou sank a ship! Specify a new target:\n";
                    break;
                }
        if (ListShips.isEmpty()) {
            alive = false;
            return "\nYou sank the last ship. You won. Congratulations!\n";
        }
        return "dummy string";
    }

    public boolean isAlive() {
        return alive;
    }
}
