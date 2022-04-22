package com.zuk17.atmp;

import java.util.Scanner;
import java.util.stream.Stream;

public class ShiftArray {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // put your code here
        int shift = Integer.parseInt(scanner.nextLine());
        int[] array = Stream.of(scanner.nextLine().split(" ")).
                mapToInt(Integer::parseInt).toArray();

        if (shift >= array.length) shift -= array.length;

        for (int i = 0; i < array.length; i++) {
            if (i + shift < array.length) {
                System.out.print(array[i + shift] + " ");
            } else {
                System.out.print(array[i - shift] + " ");
            }
        }
    }
}
