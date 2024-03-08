package org.example.integrationAndDifferentiation;

import static java.lang.Math.*;
import static java.lang.Math.exp;

public class SimpsonRuleFormula {

    // Function to calculate f(x)
    static float func(float x) {
        return (float) (exp(x) / (1 + x));
    }

    // Function for approximate integral
    static float simpsons_(float ll, float ul,
                           int n)
    {
        // Calculating the value of h
        float h = (ul - ll) / n;

        // Array for storing value of x
        // and f(x)
        float[] x = new float[10];
        float[] fx= new float[10];

        // Calculating values of x and f(x)
        for (int i = 0; i <= n; i++) {
            x[i] = ll + i * h;
            fx[i] = func(x[i]);
        }

        // Calculating result
        float res = 0;
        for (int i = 0; i <= n; i++) {
            if (i == 0 || i == n)
                res += fx[i];
            else if (i % 2 != 0)
                res += 4 * fx[i];
            else
                res += 2 * fx[i];
        }

        res = res * (h / 3);
        return res;
    }

    // Driver Code
    public static void main(String s[])
    {
        // Lower limit
        float lower_limit = 0;

        // Upper limit
        float upper_limit = 6;

        // Number of interval
        int n = 2;

        System.out.println(simpsons_(lower_limit,
                upper_limit, n));
    }
}
