package com.zuk17.atmp;

import java.util.Arrays;
import java.util.Scanner;

public class firstAndLast {

    // write a method here
    public static int[] getFirstAndLast(int[] array) {
        return new int[] {array[0], array[array.length - 1]};
    }

    /* Do not change code below */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] array = Arrays.stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        int[] result = getFirstAndLast(array);
        Arrays.stream(result).forEach(e -> System.out.print(e + " "));
    }
}
