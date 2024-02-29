package org.example.approximation;

import java.util.Scanner;

import static java.lang.Math.*;

public class BisectionMethod {
    static double precision = 0.0001;

    public static double rootY(double x) {
        return pow(x, 3) - 4 * x + 9;
    }

    public static void outputIntervals() {
        for (int i = -10; i <= 10; i++) {
            System.out.printf("[i = %d, f(i) = %f]\n", i, rootY(i));
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        outputIntervals();
        System.out.print("a = ");
        double a = sc.nextDouble();
        System.out.print("b = ");
        double b = sc.nextDouble();
        double answer;
        int i = 2;
        System.out.printf("%d iteration: [%f, %f]\n", 1, a, b);
        while (true) {
            double mid = (a + b) / 2;
            double val = rootY(mid);
            if (val > 0) {
                b = mid;
            } else if (val < 0) {
                a = mid;
            }
            System.out.printf("%d iteration: [%f, %f]\n", i, a, b);
            if (abs(a - b) <= precision) {
                answer = mid;
                break;
            } else {
                i++;
            }
        }
        System.out.printf("Answer = %f\n", answer);
    }
}
