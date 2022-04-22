package com.zuk17.atmp;

import java.io.BufferedReader;
import java.io.InputStreamReader;


public class AbcTest {

    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        // start coding here
        StringBuilder a = new StringBuilder(reader.read());
        while (reader.ready()) {
            a.append(reader.read());
        }
        reader.close();
        a.reverse();
        System.out.println(a);

    }

}
