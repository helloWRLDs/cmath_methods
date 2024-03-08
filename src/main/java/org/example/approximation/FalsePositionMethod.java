package org.example.approximation;

import java.util.Scanner;

import static java.lang.Math.*;

public class FalsePositionMethod {
    static double precision = 0.0001;

    static double rootY(double x) {
        return 2 * exp(x) * sin(x) - 3;
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
        int i = 1;
        double res, answer;
        while (true) {
            res = a - (((b - a) / (rootY(b) - rootY(a))) * rootY(a));
            if (rootY(res) > 0) {
                if (abs(b - res) <= precision) {
                    answer = res;
                    break;
                } else {
                    b = res;
                }
            } else if (rootY(res) < 0) {
                if (abs(a - res) <= precision) {
                    answer = res;
                    break;
                }
                a = res;
            }
            System.out.printf("%d Iteration: [%f, %f] res = %f, f(res) = %f\n", i, a, b, res, rootY(res));
            i++;
        }
        System.out.printf("Answer = %f", answer);
    }
}
