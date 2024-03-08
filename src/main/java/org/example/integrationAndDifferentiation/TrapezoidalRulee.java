package org.example.integrationAndDifferentiation;

import java.util.Scanner;

import static java.lang.Math.*;

public class TrapezoidalRulee {
    static Scanner sc = new Scanner(System.in);

    static float funcX(float x) {
        return (float) (1 / x);
    }

    static float calculateT(float lower, float upper, float dX) {
        float T = dX / 2;
        float temp = funcX(lower) + funcX(upper);
        for (float i = lower + dX; i < upper; i += dX) {
            temp += (2 * funcX(i));
        }
        return  T * temp;
    }

    public static void main(String[] args) {
        float lBound = (float) 1;
        float uBound = (float) 3;
        float n = 1;
        float dx = (uBound - lBound ) / n;
        System.out.printf("T = %f", calculateT(lBound, uBound, dx));
    }
}
