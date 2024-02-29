package org.example.matrix;

public class MatrixComputation {
    public static int[][] squareOfSquaredMatrix(int[][] matrix) {
        int n = matrix.length;
        int[][] newMatrix = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    newMatrix[i][j] += matrix[i][k] * matrix[k][j];
                }
            }
        }
        return newMatrix;
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

    public static void main(String[] args) {
        int[][] matrix = new int[][] {
                {2, 1, 1},
                {0, 1, 0},
                {1, 1, 2}
        };
        printMatrix(squareOfSquaredMatrix(matrix));
    }

    public static void printMatrix(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void printVector(double[] vector) {
        System.out.print(" [");
        for (int i =0 ; i < vector.length; i++) {
            System.out.print(vector[i] + " ");
        }
        System.out.println("]\n");
    }
}
