package com.zuk17.atmp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;

public class Anagram {
    public static void main(String[] args) {
        String s = "anagram";
        String t = "nagaram";

        StringBuilder buildS = new StringBuilder();
        if (t.equals(buildS.append(s).reverse().toString())) {
            System.out.println(true);
        } else System.out.println(false);
        int[] a = {9, 8, 3, 1, 5, 4};
        for (int i = 0; i < a.length; i = i + 1) {
            if (a[i] % 2 == 0) {
                a[i] += 1;
            } else a[i] -= 1;
        }
        System.out.println(Arrays.toString(a));
        LinkedList<Integer> list = new LinkedList<>(new ArrayList<>());
    }
}
