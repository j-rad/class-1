package com.company;

import java.util.Scanner;

public class Main {
    public Main() {
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("input some number :");
        int input = sc.nextInt();
        int tmp = input;
        int sum = 0;

        do {
            int ret = tmp % 10;
            sum += power(ret, 3);
            tmp /= 10;
        } while(tmp != 0);

        if (input == sum) {
            System.out.println("number is armstrong");
        } else {
            System.out.println("number is not armstrong");
        }

    }

    private static int power(int base, int pwr) {
        int tmp = 1;

        for(int i = 0; i < pwr; ++i) {
            tmp *= base;
        }

        return tmp;
    }
}
