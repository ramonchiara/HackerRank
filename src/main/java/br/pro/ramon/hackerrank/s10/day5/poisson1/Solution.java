package br.pro.ramon.hackerrank.s10.day5.poisson1;

import static java.lang.Math.E;
import static java.lang.Math.pow;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner console = new Scanner(System.in);

        double lambda = console.nextDouble();
        double x = console.nextDouble();
        double p = poisson(x, lambda);

        System.out.printf("%.3f%n", p);
    }

    private static double poisson(double k, double lambda) {
        return pow(lambda, k) * pow(E, -lambda) / factorial(k);
    }

    private static double factorial(double n) {
        double fat = 1;
        for (int i = 1; i <= n; i++) {
            fat *= i;
        }
        return fat;
    }
}
