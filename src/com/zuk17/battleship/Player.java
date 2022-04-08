package com.zuk17.battleship;

public class Player {
    private final String name;
    private final Field field;

    public Player(String name, Input input) {
        this.name = name;
        // Создание поля боя
        field = new Field(10, 10);

        // Установка кораблей на поле
        System.out.println(this.name + ", place your ships on the game field");
        addShips(input);
        changePlayer(input);
    }

    public void changePlayer(Input input) {
        System.out.println("Press Enter and pass the move to another player\n...");
        input.isNextTurn();
        input.isNextTurn();
    }

    private void addShips(Input input) {

        for (Ship ship : field.ListShips) {
            System.out.println("\n" + field.printField(Mark.SHIP));
            System.out.println(ship.toString() + ":\n");

            Coordinate[] inputCoordinates;
            while (!ship.isAddedOnField()) {
                if (Main.$DEBUG) {
                    inputCoordinates = new Coordinate[]{new Coordinate(ship.getType().getCoord1()),
                            new Coordinate(ship.getType().getCoord2())};
                } else
                    inputCoordinates = input.readCoordShip();
                System.out.println(field.addShipToField(ship, new Coordinates(inputCoordinates)));
            }
        }
        System.out.println(field.printField(Mark.SHIP));
    }

    public Field getField() {
        return field;
    }

    public String getName() {
        return name;
    }
}
