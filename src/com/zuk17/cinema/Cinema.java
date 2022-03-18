package com.zuk17.cinema;

import java.util.Scanner;

public class Cinema {
    public static void main(String[] args) {

        // Menu options
        final var choiceExit = 0;
        final var choiceShow = 1;
        final var choiceBuy = 2;
        final var choiceStat = 3;

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the number of rows:");
        int rows = scanner.nextInt();
        System.out.println("Enter the number of seats in each row:");
        int columns = scanner.nextInt();

        char[][] seats = new char[rows][columns];

        fillArray(seats);

        int choiceMenu;
        do {
            printMenu();
            choiceMenu = scanner.nextInt();

            switch (choiceMenu) {
                case choiceShow:
                    printArray(seats);
                    break;
                case choiceBuy:
                    while (chooseSeat(scanner, seats) != 0) ;
                    break;
                case choiceStat:
                    calcStat(seats);
                    break;
            }
        } while (choiceMenu != choiceExit);
    }

    public static void printMenu() {
        System.out.println("1. Show the seats");
        System.out.println("2. Buy a ticket");
        System.out.println("3. Statistics");
        System.out.println("0. Exit");
    }

    public static void calcStat(char[][] seats) {
        int numTickets = 0;
        int income = 0;
        int incomeTotal = 0;

        for (int i = 0; i < seats.length; i++) {
            incomeTotal += takePrice(i+1, seats) * seats[0].length;
            for (int j = 0; j < seats[0].length; j++) {
                if (seats[i][j] == 'B') {
                    income += takePrice(i+1, seats);
                    numTickets++;
                }
            }
        }
        double percentage = 100 * (double) numTickets / (double) (seats.length * seats[0].length);

        System.out.println("Number of purchased tickets: " + numTickets);
        System.out.format("Percentage: %.2f", percentage);
        System.out.println("%");
        System.out.println("Current income: $" + income);
        System.out.println("Total income: $" + incomeTotal);

    }

    public static void fillArray(char[][] seats) {
        for (int i = 0; i < seats.length; i++) {
            for (int j = 0; j < seats[i].length; j++) {
                seats[i][j] = 'S';
            }
        }
    }

    public static int chooseSeat(Scanner scanner, char[][] seats) {
        System.out.println("Enter a row number:");
        int row = scanner.nextInt();
        System.out.println("Enter a seat number in that row:");
        int column = scanner.nextInt();

        if (row > seats.length || column > seats[0].length || row <= 0 || column <= 0) {
            System.out.println("Wrong input!");
            return -1;
        }
        if (seats[row - 1][column - 1] == 'B') {
            System.out.println("That ticket has already been purchased!");
            return -1;
        }
        System.out.println("Ticket price: $" + takePrice(row, seats));
        seats[row - 1][column - 1] = 'B';
        return 0;
    }

    private static int takePrice(int row, char[][] seats) {
        if (seats.length * seats[0].length > 60 && row > seats.length / 2) {
            return 8;
        } else return 10;
    }

    public static void printArray(char[][] seats) {
        System.out.println("Cinema:");
        String titleString = " ";
        for (int i = 1; i <= seats[0].length; i++) {
            titleString = titleString.concat(" ").concat(Integer.toString(i));
        }
        System.out.println(titleString);
        for (int i = 0; i < seats.length; i++) {
            titleString = Integer.toString(i + 1);
            for (int j = 0; j < seats[i].length; j++) {
                titleString = titleString.concat(" ").concat(String.valueOf(seats[i][j]));
            }
            System.out.println(titleString);
        }
    }
}
