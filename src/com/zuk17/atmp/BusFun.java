package com.zuk17.atmp;

import java.util.Scanner;

public class BusFun {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // start coding here
        int height = scanner.nextInt();
        int limit = scanner.nextInt();
        System.out.println(height + limit);
        for (int i = 0; i < limit; i++) {
            if (height >= scanner.nextInt()) {
                System.out.println("Will crash on bridge " + i);
                height = 0;
                break;
            }
        }
        if (height != 0) {
            System.out.println("Will not crash");
        }
    }
}
