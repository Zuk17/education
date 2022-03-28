package com.zuk17.numbers;

import java.util.Arrays;
import java.util.HashSet;

import static java.util.Arrays.copyOfRange;

public class InputData {
    private AmazingNumber number;
    private long iterator;
    private String errorString;
    private MenuOptions menuChoice;

    private HashSet<TypeNumbers> typesForFind;
    private HashSet<TypeNumbers> typesForDeny;


    public InputData() {
        menuChoice = MenuOptions.REPEAT;
    }

    public InputData(String[] arrayStr) {
        int length = arrayStr.length;

        if (length == 0 || arrayStr[0].isEmpty()) {
            menuChoice = MenuOptions.REPEAT;
            return;
        }

        readNumber(arrayStr[0]);
        if (length > 1 && checkOut()) readIterator(arrayStr[1]);
        if (length > 2 && checkOut())
            readTypeNumbers(copyOfRange(arrayStr, 2, length));
    }

    private void readTypeNumbers(String[] arrayStr) {
        HashSet<String> errorArray = new HashSet<>();

        typesForDeny = new HashSet<>();
        typesForFind = new HashSet<>();

        //Read arrayStr for two hashsets
        for (String a : arrayStr) {
            try {
                if (a.charAt(0) == '-') typesForDeny.add(TypeNumbers.valueOf(a.substring(1).toUpperCase()));
                else typesForFind.add(TypeNumbers.valueOf(a.toUpperCase()));
            } catch (RuntimeException e) {
                errorArray.add(a);
            }
        }

        // Is not in TypeNumbers
        if (errorArray.size() > 0) {
            createErrorByWrongProperty(errorArray);
            menuChoice = MenuOptions.ERROR;
            return;
        }

        // Even and Odd, Duck and Spy, Sunny and Square, Sad and Happy
        errorArray = TypeNumbers.checkTypesFindAndDeny(typesForFind, typesForDeny);

        if (errorArray.size() > 0) {
            System.out.println("The request contains mutually exclusive properties: " +
                    Arrays.toString(errorArray.toArray()) + "\n" +
                    "There are no numbers with these properties.\n");
            menuChoice = MenuOptions.ERROR;
        }
    }

    private void createErrorByWrongProperty(HashSet<String> errorArray) {
        if (errorArray.size() == 1) {
            errorString = "The property " + Arrays.toString(errorArray.toArray()) + " is wrong.\n";
        } else
            errorString = "The properties " + Arrays.toString(errorArray.toArray()) + " are wrong.\n";
        errorString += "Available properties: " + Arrays.toString(TypeNumbers.values()) + "\n";
        menuChoice = MenuOptions.ERROR;
    }

    private void readIterator(String arrayStr) {
        try {
            iterator = Long.parseLong(arrayStr);

            if (iterator <= 0) {
                throw new NumberFormatException();
            }
            menuChoice = MenuOptions.ALL;

        } catch (NumberFormatException e) {
            errorString = "The second parameter should be a natural number.\n";
            menuChoice = MenuOptions.ERROR;
        }
    }

    private void readNumber(String arrayStr) {
        try {
            number = new AmazingNumber(Long.parseLong(arrayStr));

            if (number.get() == 0) menuChoice = MenuOptions.EXIT;
            else if (number.get() < 0) throw new NumberFormatException();
            else menuChoice = MenuOptions.ONE;

        } catch (NumberFormatException e) {
            errorString = "The first parameter should be a natural number or zero.\n";
            menuChoice = MenuOptions.ERROR;
        }
    }

    boolean checkOut() {
        return menuChoice != MenuOptions.ERROR && menuChoice != MenuOptions.EXIT;
    }

    public void printErrorString() {
        System.out.println(errorString);
    }

    public AmazingNumber getNumber() {
        return number;
    }

    public MenuOptions getMyChoice() {
        return menuChoice;
    }

    public long getIterator() {
        return iterator;
    }

    public HashSet<TypeNumbers> getTypesForFind() {
        return typesForFind;
    }

    public HashSet<TypeNumbers> getTypesForDeny() {
        return typesForDeny;
    }
}