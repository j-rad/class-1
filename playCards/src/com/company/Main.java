package com.company;

import java.util.Scanner;

public class Main {
    static int[] mainDesk = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13
            , 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26
            , 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39
            , 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, 52};
    static int[] repDesk = new int[52];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int choose = 0;
        repDesk = mainDesk ;
        while (choose != 4 ) {
            printMenu();
            choose = sc.nextInt();
            switch (choose) {
                case 1 :
                    showCards();
                    break;
                case 2 :
                    shuffle();
                    break;
                case 3 :
                    System.out.println("input cards you want");
                    int cardsNum = sc.nextInt();
                    removeCards(cardsNum);
                    break;
            }
            if(mainDesk.length==0){
                mainDesk = repDesk ;
            }
        }
    }

    private static void printMenu() {
        System.out.println("1:show cards");
        System.out.println("2:shuffle cards");
        System.out.println("3:give cards");
        System.out.println("4:exit");
    }

    private static void showCards() {
        for (int i = 0; i < mainDesk.length; i++) {
            System.out.print(mainDesk[i]);
            System.out.print(" , ");
            if (i == 14 || i == 27 || i == 40) {
                System.out.println("");
            }
        }
        System.out.println("");
    }

    private static void shuffle() {
        int[] sh = new int[mainDesk.length];
        //Math.random() * ( Max - Min )
        for (int i = 0; i < sh.length; ) {
            int mathR = (int) (Math.random() * ((sh.length + 1) - 0));
            if (checkArray(sh, mathR)) {
                sh[i] = mathR;
                i++;
            }
        }

        //mainDesk = sh ;
        for (int i = 0; i < sh.length; i++) {
            mainDesk[i] = sh[i];
        }
    }

    private static boolean checkArray(int[] A, int num) {
        boolean checked = true; // true means number of num doesnt exist in A array
        for (int i = 0; i < A.length; i++) {
            if (num == A[i]) {
                return false;
            }
        }
        return checked;
    }

    private static void removeCards(int num) {
        int rep[] = new int[mainDesk.length - num];
        for (int i = mainDesk.length-1 ; i >= (mainDesk.length - num); i--) {
            System.out.print(mainDesk[i]);
            System.out.print(" , ");
        }
        System.out.println("");
        for (int i = 0; i < rep.length; i++) {
            rep[i] = mainDesk[i];
        }
        mainDesk = new int[rep.length] ;
        for (int i = 0; i < rep.length ; i++) {
            mainDesk[i] = rep[i];
        }
    }
}
