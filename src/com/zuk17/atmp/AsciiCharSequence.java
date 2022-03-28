package com.zuk17.atmp;

import java.nio.charset.StandardCharsets;
import java.util.*;


class AsciiCharSequence implements CharSequence {

    private byte[] array;

    public AsciiCharSequence() {
    }

    public AsciiCharSequence(byte[] array) {
        this.array = array.clone();
    }

    @Override
    public int length() {
        return array.length;
    }

    @Override
    public char charAt(int index) {
        return (char) array[index];
    }

    @Override
    public CharSequence subSequence(int start, int end) {
        return new AsciiCharSequence(Arrays.copyOfRange(array, start, end));
    }

    @Override
    public String toString() {
        return new String(array, StandardCharsets.UTF_8);
/*        StringBuilder s = new StringBuilder("AsciiCharSequence {array = [ ");
        for (byte a : array) {
            s.append((char) a).append(" ");
        }
        return s.append(']').append('}').toString();*/
        // String(array, StandardCharsets.UTF_8);
    }
}
