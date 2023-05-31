package org.example;

import java.io.Console;

public class Main {
    public static void main(String[] args) {
        var number = 532;
        String strValue = String.valueOf(number);
        while(strValue.length() > 1) {
            int sumValue = 0;
            System.out.print("Step " + (String.valueOf(number).length() - strValue.length() + 1) + ": " + strValue + "=> ");
            for(int i = 0; i<strValue.length(); i++) {
                System.out.print((i == 0 ? "" : " + ") + strValue.charAt(i));
                sumValue += Integer.parseInt(Character.toString(strValue.charAt((i))));
            }
            System.out.println("=" + sumValue);
            strValue = String.valueOf(sumValue);
        }
        System.out.print(number);
        if (strValue.equals(("1"))) {
            System.out.println(" is a magic number");
        } else {
            System.out.println(" is not a magic number");
        }

    }
}