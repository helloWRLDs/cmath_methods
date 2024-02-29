package org.example.matrix;

import static java.lang.Math.abs;
import static org.example.matrix.MatrixComputation.*;

public class PowerMethod {

    public static void printApproximation(double[] vector) {
        double min = 100000;
        for (int i = 0; i < vector.length; i++) {
            if (abs(vector[i]) < min) {
                min = vector[i];
            }
        }
        System.out.print("  " + min + " * [ ");
        for (int i = 0; i < vector.length; i++) {
            System.out.print(vector[i] / min + " ");
        }
        System.out.print("]\n");
    }

    public static void main(String[] args) {
        int[][] matrix = new int[][] {
                {25, 1, 2},
                {1, 3, 0},
                {2, 0, -4}
        };
        double[] x = new double[]{1, 0, 0};
        for (int i = 0; i < 5; i++) {
            System.out.printf("x%d = A * x%d", i + 1, i);
            x = multiplyMatrixByVector(matrix, x);
            printVector(x);
        }
    }

    public static double[] multiplyMatrixByVector(int[][] matrix, double[] vector) {
        double[] new_matrix = new double[matrix.length];
        for (int i = 0; i < matrix.length; i++) {
            for (int k = 0; k < vector.length; k++) {
                new_matrix[i] += (double) matrix[i][k] * vector[k];
            }
        }
        return new_matrix;
    }
}
