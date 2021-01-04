package com.company;

import org.jetbrains.annotations.Contract;

public class Main {

    public static void main(String[] args) {
        // int , float , char
        int a[] = new int[5];
        int ab[][] = new int[3][3];
        //int a[] = { , , , , }
        //int a[] = [0],[1],[2],[3],[4]

        int b[] = {1, 10, 20000000, 84, 354, 24284, 2815};
        int ba[][] = {{5,4,7,7,8},
                {1,2,3},
                      {0,2,7}};
        //{0,1,2,3,4,5,...}

        a[3] = b[4];
        a[4] = 10;
        a[2] = pwr(21);
        // a = b ;

        for (int i = 0; i < a.length; i++) {
            System.out.println(a[i]);
        }
    }

    private static int pwr(int input) {
        //int a = input * input;
        return input * input;
    }

    // @Contract(pure = true)
    private static float[] circle(float r) {
        float ret[] = new float[2];
        ret[0] = (float) (2.0 * r * 3.14);
        ret[1] = (float) (r * r * 3.14);
        return ret;
    }
}
