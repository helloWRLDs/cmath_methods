package org.example.approximation;

import java.util.Scanner;

import static java.lang.Double.isNaN;
import static java.lang.Math.*;

public class SecantMethod {
    static double precision = 0.0001;

    static double rootY(double x) {
        return pow(x, 3) - 2 * x - 5;
    }

    public static void outputIntervals() {
        for (int i = -10; i <= 10; i++) {
            System.out.printf("[i = %d, f(i) = %f]\n", i, rootY(i));
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double[] x = new double[2];
        outputIntervals();

        System.out.print("x1 = ");
        x[0] = sc.nextDouble();
        System.out.print("x2 = ");
        x[1] = sc.nextDouble();

        System.out.printf("Start values: [%f, %f]\n", x[0], x[1]);
        int i = 1;
        double new_x;
        while (true) {
            new_x = x[1] - ((x[0] - x[1]) / (rootY(x[0]) - rootY(x[1]))) * rootY(x[1]);
            System.out.printf("%d Iteration: x = %f, f(x) = %f  [%f, %f]\n", i + 1, new_x, rootY(new_x), x[0], x[1]);
            x[0] = x[1];
            x[1] = new_x;
            if (abs(x[0] - x[1]) <= precision) {
                break;
            } else {
                i++;
            }
        }
        System.out.printf("Answer = %f\n", x[1]);
    }
}
