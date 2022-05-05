package com.zuk17.atmp;

import java.io.InputStream;

public class inputStream {

    public static void main(String[] args) throws Exception {
        InputStream inputStream = System.in;
        int value = inputStream.read();
        String result = "";
        while (value != -1) {
            result += value;
            value = inputStream.read();
        }
        System.out.println(result);
    }
}
