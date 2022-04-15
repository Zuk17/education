package com.zuk17.atmp;

import java.util.Scanner;

public class TryBoolean {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        // start coding here
        int max = 0;
        while (scanner.hasNext()) {
            int tmp = scanner.nextInt();
            if (tmp % 4 == 0 && tmp > max) max = tmp;
        }
        System.out.println(max);
    }

}