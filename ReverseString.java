package org.example;

public class Main {
    public static void main(String[] args) {
        String strValue = "entoto";
        String reversedValue = "";
        for (int i =0; i <strValue.length(); i++) {
            reversedValue += strValue.charAt(strValue.length() - i - 1);
        }
        System.out.println("Reversed string vlaue is : "+ reversedValue);
    }
}

