package org.example.interpolation;

public class NewtonForwardFormula {
    static double u_cal(double u, int n) {
        double temp = u;
        for (int i = 1; i < n; i++)
            temp = temp * (u - i);
        return temp;
    }

    static int fact(int n) {
        int f = 1;
        for (int i = 2; i <= n; i++)
            f *= i;
        return f;
    }

    public static void printForwardDiff(double[] x, double[][]y) {
        int n = x.length;
        for (int i = 0; i < n; i++) {
            System.out.printf("x = %f\t", x[i]);
            for (int j = 0; j < n - i; j++)
                System.out.printf("%.2f\t", y[i][j]);
            System.out.println();
        }
    }

    public static void main(String[] args) {
        // INPUT VALUES
        double value = 2.4;
        double[] x = new double[]{1.7, 1.8, 1.9, 2, 2.1, 2.2, 2.3};
        int n = x.length;
        double[][] y = new double[x.length][x.length];
        y[0][0] = 5.474;
        y[1][0] = 6.050;
        y[2][0] = 6.686;
        y[3][0] = 7.389;
        y[4][0] = 8.166;
        y[5][0] = 9.025;
        y[6][0] = 9.974;


        for (int i = 1; i < n; i++) {
            for (int j = 0; j < n - i; j++)
                y[j][i] = y[j + 1][i - 1] - y[j][i - 1];
        }
        printForwardDiff(x, y);
        double sum = y[0][0];
        double u = (value - x[0]) / (x[1] - x[0]);
        for (int i = 1; i < n; i++) {
            sum = sum + (u_cal(u, i) * y[0][i]) / fact(i);
        }
        System.out.printf("\n Value at x = %f is %.6g%n", value, sum);
    }
}
