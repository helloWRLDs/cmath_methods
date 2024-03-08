package org.example.integrationAndDifferentiation;

import java.util.Scanner;

public class TrapezoidalRuleByTable {
    static Scanner sc = new Scanner(System.in);


    static float[] getInput(int n) {
        float[] arr = new float[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextFloat();
        }
        return  arr;
    }

    static void printArr(float[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.printf("%f ", arr[i]);
        }
        System.out.println();
    }

    static float calculateT(float T, float[] x, float[] y) {
        float temp = y[0] + y[y.length - 1];
        for (int i = 1; i < y.length - 1; i++) {
            temp += (2 * y[i]);
        }
        return T * temp;
    }


    public static void main(String[] args) {
        System.out.print("Number of cells: ");
        int n = sc.nextInt();

        System.out.println("Enter x vals: ");
        float[] x = getInput(n);                // x col
        System.out.println("Enter f(x) vals: ");
        float[] y = getInput(n);                // y col

        float dX = (x[n - 1] - x[0]) / (n - 1); // delta x

        float T = calculateT(dX / 2, x, y);

        System.out.printf("T = %.2f", T);
    }
}
