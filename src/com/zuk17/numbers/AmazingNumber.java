package com.zuk17.numbers;

import java.util.HashSet;

public class AmazingNumber {

    private final long number;
    private HashSet<TypeNumbers> property;

    public AmazingNumber(long number) {
        this.number = number;
        if (number > 0) {
            property = new HashSet<>();
            isEven();
            isBuzz();
            isDuck();
            isPalindromic();
            isGapful();
            isSpy();
            isSquare();
            isSunny();
            isJumping();
            isHappySad();
        }
    }

    private void isHappySad() {
        char[] abc = String.valueOf(number).toCharArray();
        HashSet<Long> sum_hash = new HashSet<>();

        long sum = 0;

        while (sum_hash.add(sum)) {
            sum = 0;

            for (char a : abc)
                sum += (long) Math.pow((Character.getNumericValue(a)), 2);

            abc = String.valueOf(sum).toCharArray();

            // exit with Happy Code
            if (sum == 1) {
                property.add(TypeNumbers.HAPPY);
                return;
            }
        }
        property.add(TypeNumbers.SAD);
    }

    private void isJumping() {
        char[] abc = String.valueOf(number).toCharArray();
        for (int i = 1; i < abc.length; i++) {
            if (Math.abs(Character.getNumericValue(abc[i]) - Character.getNumericValue(abc[i - 1])) != 1)
                return;
        }
        property.add(TypeNumbers.JUMPING);
    }

    private void isSunny() {
        int a = (int) Math.sqrt((double) number + 1);
        if ((long) a * a == number + 1) {
            property.add(TypeNumbers.SUNNY);
        }
    }

    private void isSquare() {
        int a = (int) Math.sqrt((double) number);
        if ((long) a * a == number) {
            property.add(TypeNumbers.SQUARE);
        }
    }

    private void isSpy() {
        char[] abc = String.valueOf(number).toCharArray();
        long sum = 0;
        long product = 1;
        for (char a : abc) {
            sum += Character.getNumericValue(a);
            product *= Character.getNumericValue(a);
        }
        if (sum == product) {
            property.add(TypeNumbers.SPY);
        }
    }

    private void isGapful() {
        String numberS = String.valueOf(number);
        if (numberS.length() > 2) {
            String divider = String.valueOf(numberS.charAt(0));
            divider += numberS.charAt(numberS.length() - 1);

            if (number % Integer.parseInt(divider) == 0) {
                property.add(TypeNumbers.GAPFUL);
            }
        }
    }

    private void isPalindromic() {
        String numberS = String.valueOf(number);
        if (numberS.equals(new StringBuilder(numberS).reverse().toString())) {
            property.add(TypeNumbers.PALINDROMIC);
        }
    }

    private void isDuck() {
        String numberS = String.valueOf(number);
        for (int i = 1; i < numberS.length(); i++) {
            if (numberS.charAt(i) == '0') {
                property.add(TypeNumbers.DUCK);
                return;
            }
        }
    }

    private void isBuzz() {
        if (number % 7 == 0 || number % 10 == 7) {
            property.add(TypeNumbers.BUZZ);
        }
    }

    private void isEven() {
        property.add(number % 2 == 0 ? TypeNumbers.EVEN : TypeNumbers.ODD);
    }

    public void printOut() {
        System.out.println("Properties of " + number);
        for (TypeNumbers a : TypeNumbers.values()) {
            System.out.printf("%12s", a.toString().toLowerCase());
            System.out.println(": " + property.contains(a));
        }
    }

    public void printStr() {
        StringBuilder output = new StringBuilder("\t\t" + number + " is ");
        for (TypeNumbers a : property) {
            output.append(a.toString().toLowerCase()).append(", ");
        }
        System.out.println(output.substring(0, output.length() - 2));
    }

    public boolean checkPropertyAccess(HashSet<TypeNumbers> typesForFind) {
        boolean checkProperty = true;
        if (typesForFind != null)
            for (TypeNumbers a : typesForFind) {
                checkProperty = checkProperty && property.contains(a);
            }
        return checkProperty;
    }

    public boolean checkPropertyDeny(HashSet<TypeNumbers> typesForDeny) {
        boolean checkProperty = true;
        if (typesForDeny != null)
            for (TypeNumbers a : typesForDeny) {
                checkProperty = checkProperty && !property.contains(a);
            }
        return checkProperty;
    }

    public long get() {
        return number;
    }
}