package org.example.interpolation;

public class NewtonBackwardFormula {
    static double u_cal(double u, int n) {
        double temp = u;
        for (int i = 1; i < n; i++) {
            temp = temp * (u + i);
        }
        return temp;
    }

    static int fact(int n) {
        int f = 1;
        for (int i = 2; i <= n; i++) {
            f *= i;
        }
        return f;
    }

    public static void printDiff(double[][] y) {
        int n = y.length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= i; j++)
                System.out.print(y[i][j] + "\t");
            System.out.println("");;
        }
    }

    public static void main(String[] args) {
        double value = 1925;
        double x[] = { 1891, 1901, 1911, 1921, 1931 };
        int n = x.length;
        double[][] y = new double[n][n];
        y[0][0] = 46;
        y[1][0] = 66;
        y[2][0] = 81;
        y[3][0] = 93;
        y[4][0] = 101;

        for (int i = 1; i < n; i++) {
            for (int j = n - 1; j >= i; j--)
                y[j][i] = y[j][i - 1] - y[j - 1][i - 1];
        }

        printDiff(y);

        double sum = y[n - 1][0];
        double u = (value - x[n - 1]) / (x[1] - x[0]);
        for (int i = 1; i < n; i++) {
            sum = sum + (u_cal(u, i) * y[n - 1][i]) /
                    fact(i);
        }
        System.out.printf("\n Value at x = %f is %.6g%n", value, sum);
    }
}
