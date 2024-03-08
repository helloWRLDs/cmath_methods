package org.example.approximation;

import static java.lang.Math.*;

public class GaussSeidalMethod {
    static double precision = 0.0001;

    static double xRoot(double y, double z) {
        return ((double) 1 / 5) * (10 + y - z);
    }

    static double yRoot(double x, double z) {
        return ((double ) 1 / 4) * (12 - 2 * x);
    }

    static double zRoot(double x, double y) {
        return ((double ) 1 / 5) * (-1 - x - y);
    }

    public static void main(String[] args) {
        double x = 0.0, y = 0.0, z = 0.0;
        double xEx = 0.0, yEx = 0.0, zEx = 0.0;
        int i = 1;
        while (true) {
            if (i != 0) {
                xEx = x;
                yEx = y;
                zEx = z;
            }
            x = xRoot(y, z);
            y = yRoot(x, z);
            z = zRoot(x, y);
            System.out.printf("%d iteration: [x = %f, y = %f, z = %f]\n", i, x, y, z);
            if (abs(x - xEx) <= precision && abs(y - yEx) <= precision && abs(z - zEx) <= precision) {
                break;
            } else {
                i++;
            }
        }
        System.out.printf("Answer: x = %f, y = %f, z = %f", x, y, z);
    }
}
