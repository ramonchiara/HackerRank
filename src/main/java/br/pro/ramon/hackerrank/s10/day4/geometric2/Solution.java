package br.pro.ramon.hackerrank.s10.day4.geometric2;

import java.util.*;
import java.util.stream.IntStream;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int num = in.nextInt();
        int den = in.nextInt();
        int n = in.nextInt();

        double p = (double) num / den;

        double result = IntStream.range(1, n + 1).mapToDouble(inspection -> g(inspection, p)).sum();

        System.out.printf("%.3f%n", result);
    }

    public static double g(double n, double p) {
        double q = 1 - p;
        return Math.pow(q, n - 1) * p;
    }

    public static double bStar(int x, int n, double p) {
        double q = 1 - p;
        return c(n - 1, x - 1) * Math.pow(p, x) * Math.pow(q, n - x);
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
