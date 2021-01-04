package com.company;

import java.util.Scanner;

public class Strings {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("input String");
        String input = sc.nextLine();
        String output[] = input.trim().split(" ");
        System.out.println("number of words = " + output.length);

        for (int i = 0; i < output.length; i++) {
            System.out.println(i+1 + " = " + output[i] + " => " + output[i].length());
        }

        //.split
        //.trim
        //.toUpperCase
        //.indexOf
        /** salam in comment
        baraye tamrin ast **/
    }
}
