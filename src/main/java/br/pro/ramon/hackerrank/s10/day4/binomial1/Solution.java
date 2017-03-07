package br.pro.ramon.hackerrank.s10.day4.binomial1;

import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        double ratio = in.nextDouble();
        double bpb = in.nextDouble();

        double p = ratio / (ratio + 1);
        double result = b(3, 6, p) + b(4, 6, p) + b(5, 6, p) + b(6, 6, p);

        System.out.printf("%.3f%n", result);
    }

    public static double b(int x, int n, double p) {
        double q = 1 - p;
        return c(n, x) * Math.pow(p, x) * Math.pow(q, n - x);
    }

    public static double c(int n, int x) {
        return (double) fat(n) / (fat(x) * fat(n - x));
    }

    public static double fat(int n) {
        int f = 1;
        for (int i = 1; i <= n; i++) {
            f *= i;
        }
        return f;
    }
}
