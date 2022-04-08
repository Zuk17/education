package com.zuk17.battleship;

public class Main {

    public final static boolean $DEBUG = false;


    public static void main(String[] args) {
        // Write your code here

        // Создание класса для чтения входящих данных
        Input input = new Input();

        // Инициализация игроков
        Player[] players = new Player[2];
        players[0] = new Player("Player 1", input);
        players[1] = new Player("Player 2", input);

        System.out.println("\nThe game starts!\n\n");

        Player prevPlayer = players[1];
        do {
            for (Player a : players) {
                System.out.println(prevPlayer.getField().printField(Mark.FOG));
                System.out.println(a.getField().printField(Mark.SHIP));

                System.out.println(a.getName() + ", it's your turn:\n");
                System.out.println(prevPlayer.getField().hit(input.readCoord()));

                a.changePlayer(input);
                prevPlayer = a;
            }
        } while (players[0].getField().isAlive() && players[1].getField().isAlive());

        System.out.println("Game end!");
    }
}
