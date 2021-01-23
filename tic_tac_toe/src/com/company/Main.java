package com.company;


import java.util.Scanner;

public class Main {
    /*
     1 | 2 | 3
     4 | 5 | 6
     7 | 8 | 9
    */
    //static char mainTable [] = new char[9];
    static char mainTable[] = {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '};
    static int numTable[] = new int[9];
    static int corners[] = {1, 3, 7, 9};
    static int rightDiagonal[] = {1, 5, 9};
    static int leftDiagonal[] = {3, 5, 7};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        printMenu();
        do {
            int player = playerChoose(sc);
            if (winnerChoose(player, 'o')) {
                System.out.printf(" you win ");
                break;
            }
            printTable();
            int program = programChoose();
            if (winnerChoose(program, 'x')) {
                System.out.printf(" you lose ");
                break;
            }
            printTable();
        } while (in(0, numTable));

    }

    private static void printMenu() {
        System.out.println("| 1 | 2 | 3 |");
        System.out.println("| 4 | 5 | 6 |");
        System.out.println("| 7 | 8 | 9 |");

    }

    private static void printTable() {
        System.out.println(mainTable[0] + " | " + mainTable[1] + " | " + mainTable[2]);
        System.out.println(mainTable[3] + " | " + mainTable[4] + " | " + mainTable[5]);
        System.out.println(mainTable[6] + " | " + mainTable[7] + " | " + mainTable[8]);
        System.out.println("");
        System.out.println("**next turn**");
        System.out.println("");

    }

    private static int playerChoose(Scanner sc) {
        int ch;
        do {
            System.out.println("input number you want :");
            ch = sc.nextInt();
            if (ch > 9 || ch < 1) {
                System.out.println("wrong input");
            }
        } while (numTable[ch - 1] == 1 || ch > 9 || ch < 1);
        mainTable[ch - 1] = 'o';
        numTable[ch - 1] = 1;
        return ch - 1;
    }

    private static int programChoose() {
        int[] playerWinMove = winMove('o');
        int[] programWinMove = winMove('x');
        if (playerWinMove.length != 0) {//player has move to win
            if (programWinMove.length != 0) {//program has move to win
                for (int i = 0; i < programWinMove.length; i++) {
                    for (int j = 0; j < playerWinMove.length; j++) {
                        if (programWinMove[i] == playerWinMove[j]) {
                            mainTable[programWinMove[i]] = 'x';
                            numTable[programWinMove[i]] = 1;
                            return programWinMove[i];
                        }
                    }
                }
                for (int i = 0; i < programWinMove.length; i++) {
                    mainTable[programWinMove[i]] = 'x';
                    numTable[programWinMove[i]] = 1;
                    return programWinMove[i];
                }
            }
        } else {//player has no move to win
            if (programWinMove.length != 0) {//program has move to win
                for (int i = 0; i < programWinMove.length; i++) {
                    mainTable[programWinMove[i]] = 'x';
                    numTable[programWinMove[i]] = 1;
                    return programWinMove[i];
                }
            } else {//program has no move to win
                for (int i = 0; i < corners.length; i++) {
                    if (numTable[corners[i] - 1] == 0) {
                        mainTable[corners[i] - 1] = 'x';
                        numTable[corners[i] - 1] = 1;
                        return corners[i] - 1;
                    }
                }
            }
        }
        int ran;
        do {
            ran = (int) (Math.random() * 8.0D + 0.0D);
        } while (numTable[ran] == 1);

        mainTable[ran] = 'x';
        numTable[ran] = 1;
        return ran;
    }

    private static int[] winMove(char player) {
        int[] ret = new int[winMoveDigits(player)];
        int c = 0;
        for (int i = 0; i < numTable.length; i++) {
            if (winnerChoose(i, player) && numTable[i] == 0) {
                ret[c] = i;
                c++;
            }
        }
        return ret;
    }

    private static int winMoveDigits(char player) {
        int ret = 0;
        for (int i = 0; i < numTable.length; i++) {
            if (winnerChoose(i, player) && numTable[i] == 0) {
                ret++;
            }
        }
        return ret;
    }

    private static boolean winnerChoose(int h, char player) {
        boolean ret = false;
        if (h == 4) {
            if (player == mainTable[1] && player == mainTable[7])
                return true;
            if (player == mainTable[6] && player == mainTable[2])
                return true;
            if (player == mainTable[8] && player == mainTable[0])
                return true;
            if (player == mainTable[3] && player == mainTable[5])
                return true;
        } else {
            if (in(h, corners)) {
                switch (h) {
                    case 0:
                        if (player == mainTable[1] && player == mainTable[2])
                            return true;
                        if (player == mainTable[3] && player == mainTable[6])
                            return true;
                        if (player == mainTable[4] && player == mainTable[8])
                            return true;
                        break;
                    case 2:
                        if (player == mainTable[5] && player == mainTable[8])
                            return true;
                        if (player == mainTable[1] && player == mainTable[0])
                            return true;
                        if (player == mainTable[4] && player == mainTable[6])
                            return true;
                        break;
                    case 6:
                        if (player == mainTable[7] && player == mainTable[8])
                            return true;
                        if (player == mainTable[3] && player == mainTable[2])
                            return true;
                        if (player == mainTable[4] && player == mainTable[2])
                            return true;
                        break;
                    case 8:
                        if (player == mainTable[7] && player == mainTable[6])
                            return true;
                        if (player == mainTable[5] && player == mainTable[2])
                            return true;
                        if (player == mainTable[4] && player == mainTable[0])
                            return true;
                        break;
                }
            } else {
                switch (h) {
                    case 1:
                        if (player == mainTable[4] && player == mainTable[7])
                            return true;
                        if (player == mainTable[0] && player == mainTable[2])
                            return true;
                        break;
                    case 3:
                        if (player == mainTable[4] && player == mainTable[5])
                            return true;
                        if (player == mainTable[6] && player == mainTable[0])
                            return true;
                        break;
                    case 5:
                        if (player == mainTable[8] && player == mainTable[2])
                            return true;
                        if (player == mainTable[4] && player == mainTable[3])
                            return true;
                        break;
                    case 7:
                        if (player == mainTable[6] && player == mainTable[8])
                            return true;
                        if (player == mainTable[4] && player == mainTable[1])
                            return true;
                        break;
                }
            }
        }
        return ret;
    }

    private static boolean in(int num, int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == num)
                return true;
        }
        return false;
    }


}
