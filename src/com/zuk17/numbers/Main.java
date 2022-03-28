package com.zuk17.numbers;

import java.util.Scanner;

enum MenuOptions {
    EXIT,
    REPEAT,
    ONE,
    ALL,
    ERROR
}

public class Main {
    public static void main(String[] args) {
//        write your code here
        Scanner scanner = new Scanner(System.in);

        sayHello();

        InputData myStr = new InputData();

        while (myStr.getMyChoice() != MenuOptions.EXIT) {

            String[] arrayStr = readUserInput(scanner);
            assert arrayStr != null;
            myStr = new InputData(arrayStr);

            switch (myStr.getMyChoice()) {
                case REPEAT:
                    printInstructions();
                    break;
                case ONE:
                    myStr.getNumber().printOut();
                    System.out.print("\n");
                    break;
                case ALL:
                    printABC(myStr);
                    System.out.print("\n");
                    break;
                case ERROR:
                    myStr.printErrorString();
                    break;
                case EXIT:
                    sayGoodBay();
                    break;
                default:
                    System.out.println("!!!!\tERROR\tUnexpected choice in MenuOption myChoice\tERROR\t!!!!");
            }
        }
    }

    //This method looks like from other class. Can you help to improve?
    private static void printABC(InputData myStr) {
        long iterator = myStr.getIterator();
        AmazingNumber number = myStr.getNumber();

        while (iterator > 0) {
            if (number.checkPropertyDeny(myStr.getTypesForDeny())
                    && number.checkPropertyAccess(myStr.getTypesForFind())) {
                number.printStr();
                iterator--;
            }
            number = new AmazingNumber(number.get() + 1);
        }
    }

    private static String[] readUserInput(Scanner scanner) {
        try {
            System.out.print("Enter a request: > ");
            String[] arrayStr = scanner.nextLine().split(" ");
            System.out.print("\n");
            return arrayStr;
        } catch (RuntimeException e) {
            System.out.println("!!!!\tERROR\tSomething goes wrong while read user input from scanner\tERROR\t!!!!");
            return null;
        }
    }

    private static void sayGoodBay() {
        System.out.println("GoodBay");
    }

    private static void sayHello() {
        System.out.println("Welcome to Amazing Numbers!\n" +
                "In this stage, a user can enter two numbers and properties to search for.\n");
        printInstructions();
    }
    private static void printInstructions() {
        System.out.println("Supported requests:\n" +
                "- enter a natural number to know its properties;\n" +
                "- enter two natural numbers to obtain the properties of the list:\n" +
                "  * the first parameter represents a starting number;\n" +
                "  * the second parameter shows how many consecutive numbers are to be processed;\n" +
                "- two natural numbers and a property to search for;\n" +
                "- a property preceded by minus must not be present in numbers;\n" +
                "- separate the parameters with one space;\n" +
                "- enter 0 to exit.\n");
    }
}