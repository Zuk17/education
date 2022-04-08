package com.zuk17.battleship;

import java.util.Scanner;

public class Input {

    Scanner scanner;

    public Input() {
        scanner = new Scanner(System.in);
    }

    public void isNextTurn() {
        scanner.nextLine();
    }


    //read single coordinate
    public Coordinate readCoord() {
        String inputString = scanner.next().toUpperCase();
        if (inputString.matches("^[A-Z]\\d+")) {
            return new Coordinate(inputString);
        } else {
            System.out.println("ERROR!!!!!!!!!!!\tWrong number or format of elements.!!!!!!!!!!!\tERROR\n");
            return null;
        }
    }

    public Coordinate[] readCoordShip() {
        return new Coordinate[]{readCoord(), readCoord()};
    }
}
