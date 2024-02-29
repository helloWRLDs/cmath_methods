package org.example.approximation;

import static java.lang.Math.*;

public class GaussSeidalMethod {
    static double precision = 0.0001;

    static double xRoot(double y, double z) {
        return ((double) 1 / 3) * (7.85 + 0.1 * y + 0.2 * z);
    }

    static double yRoot(double x, double z) {
        return ((double ) 1 / 7) * (-19.3 - 0.1 * x + 0.3 * z);
    }

    static double zRoot(double x, double y) {
        return ((double ) 1 / 10) * (71.4 - 0.3 * x + 0.2* y);
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
