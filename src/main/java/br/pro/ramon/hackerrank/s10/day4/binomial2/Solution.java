package br.pro.ramon.hackerrank.s10.day4.binomial2;

import java.util.*;
import java.util.stream.IntStream;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        double p = in.nextDouble() / 100;
        int batch = in.nextInt();

        double result1 = IntStream.range(0, 2).mapToDouble(rejects -> b(rejects, batch, p)).sum(); // x <= 2
        double result2 = IntStream.range(2, batch).mapToDouble(rejects -> b(rejects, batch, p)).sum(); // x >= 2

        System.out.printf("%.3f%n", result1);
        System.out.printf("%.3f%n", result2);
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
