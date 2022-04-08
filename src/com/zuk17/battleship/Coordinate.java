package com.zuk17.battleship;

class Coordinate {
    private final int coordX;
    private final int coordY;

    public Coordinate(String inputStr) {
        StringBuilder number = new StringBuilder();

        for (int i = 1; i < inputStr.length(); i++) {
            number.append(inputStr.charAt(i));
        }

        coordX = inputStr.charAt(0) - 'A' + 1;
        coordY = Integer.parseInt(number.toString());
    }

    public Coordinate(int x, int y) {
        coordX = x;
        coordY = y;
    }

    public String toString() {
        return "[" + coordX + "," + coordY + "]";
    }

    public boolean equals(Coordinate One) {
        return coordX == One.coordX && coordY == One.coordY;
    }


    public int getX() {
        return coordX;
    }

    public int getY() {
        return coordY;
    }

}
