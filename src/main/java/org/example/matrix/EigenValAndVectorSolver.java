package org.example.matrix;

import org.apache.commons.math3.linear.*;

import static org.example.matrix.MatrixComputation.printMatrix;

public class EigenValAndVectorSolver {
    public static void main(String[] args) {
        // Define the matrix
        double[][] matrixData = {
                {4, -2, 1},
                {-2, 5, -2},
                {1, -2, 4}
        };
        // Initialize matrix from given Values
        RealMatrix matrix = new Array2DRowRealMatrix(matrixData);

        // Create an instance of the EigenDecomposition class
        EigenDecomposition eigenDecomposition = new EigenDecomposition(matrix);

        // Get eigenvalues
        double[] eigenvalues = eigenDecomposition.getRealEigenvalues();
        System.out.println("Eigenvalues:");
        for (double eigenvalue : eigenvalues) {
            System.out.println(Math.round(eigenvalue));
        }

        // Get eigenvectors
        RealMatrix eigenvectors = eigenDecomposition.getV();
        System.out.println("\nEigenvectors:");
        for (int i = 0; i < eigenvectors.getColumnDimension(); i++) {
            double[] eigenvector = eigenvectors.getColumn(i);
            System.out.print("Eigenvalue " + (Math.round(eigenvalues[i])) + ": ");
            for (double component : eigenvector) {
                System.out.print(Math.round(component) + " ");
            }
            System.out.println();
        }
    }
}