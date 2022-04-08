package com.zuk17.atmp;

public class ThrowUnchecked {
    public static void method() throws Exception {
        // write your code here
        throw new Exception();

    }

    /* Do not change code below */
    public static void main(String[] args) {
        try {
            method();
        } catch (RuntimeException e) {
            System.out.println("U failed");
            System.out.println("RuntimeException");
        } catch (Exception e) {
            System.out.println("It`s good");
            System.out.println("Exception");
        }
    }
}
