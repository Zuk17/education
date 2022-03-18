package com.zuk17.buzz;

import java.util.Scanner;

public class Buzz {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        printHello();

        do {
            System.out.print("Enter a request: > ");
            long number = scanner.nextLong();
            System.out.print("\n");
            if (number == 0) {
                return;
            }
            if (number < 0) {
                System.out.println("The first parameter should be a natural number or zero.\n");
            } else {
                printOut(number, checkEven(number), checkBuzz(number), checkDuck(number), checkPalindromic(number));
            }
        } while (true);
    }

    private static void printHello() {
        System.out.println("Welcome to Amazing Numbers!\n");
        System.out.println("Supported requests:");
        System.out.println("- enter a natural number to know its properties;");
        System.out.println("- enter 0 to exit.\n");
    }

    private static boolean checkPalindromic(long number) {
        String S = String.valueOf(number);
        if (S.equals(new StringBuilder(S).reverse().toString())) {
            return true;
        }
        return false;
    }

    public static void printOut(long number, boolean even, boolean buzz, boolean duck, boolean palindromic) {
        System.out.println("Properties of " + number);
        System.out.println("        even: " + even);
        System.out.println("         odd: " + !even);
        System.out.println("        buzz: " + buzz);
        System.out.println("        duck: " + duck);
        System.out.println(" palindromic: " + palindromic);
        System.out.println("");
    }

    public static boolean checkDuck(long number) {
        String S = String.valueOf(number);
        for (int i = 1; i < S.length(); i++) {
            if (S.charAt(i) == '0') return true;
        }
        return false;
    }

    public static boolean checkBuzz(long number) {
        if (number % 7 == 0 || number % 10 == 7) {
            return true;
        } else {
            return false;
        }
    }

    public static boolean checkEven(long number) {
        return number % 2 == 0 ? true : false;
    }
}
