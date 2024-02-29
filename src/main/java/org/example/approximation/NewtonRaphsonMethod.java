package org.example.approximation;

import static java.lang.Math.*;

public class NewtonRaphsonMethod {
    static double precision = 0.0001;

    static double rootY(double x) {
        return pow(x, 5) - 5 * pow(x, 2) + 3;
    }

    static double derivedY(double x) {
        return 5 * pow(x, 4) - 10 * x;
    }

    public static void main(String[] args) {
        double x = 2, res;
        int i = 1;
        while (true) {
            res = x - (rootY(x) / derivedY(x));
            System.out.printf("%d iteration: x = %f, res = %f\n", i, x, res);
            if (abs(x - res) <= precision) {
                x = res;
                break;
            } else {
                x = res;
                i++;
            }
        }
        System.out.printf("Answer: %f", x);
    }
}
