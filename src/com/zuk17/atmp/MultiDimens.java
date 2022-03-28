package com.zuk17.atmp;

import java.util.Scanner;

class MultiDimens {
    public static void main(String[] args) {
        // put your code here
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int[][] array = new int[n][m];

        int max = 0;
        int row = 0;
        int column = 0;

        for (int i = 0; i < n; i++)
            for (int j = 0; j < m; j++) {
                array[i][j] = scanner.nextInt();

                if (i == 0 && j == 0) max = array[i][j];

                if (max < array[i][j]) {
                    max = array[i][j];
                    row = i;
                    column = j;
                }
            }
        System.out.println(row + 1 + " " + ++column);
    }
}