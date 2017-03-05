package br.pro.ramon.hackerrank.s10.day1.sd;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

public class Solution {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int n = scan.nextInt();
        int[] x = new int[n];

        for (int i = 0; i < n; i++) {
            x[i] = scan.nextInt();
        }

        System.out.printf("%.1f%n", getStandardDeviation(x));
    }

    public static double getStandardDeviation(int[] x) {
        double mean = getMean(x);

        return Math.sqrt(
                IntStream.range(0, x.length)
                        .mapToDouble(i -> Math.pow(x[i] - mean, 2))
                        .average().getAsDouble()
        );
    }

    public static double getMean(int[] v) {
        return Arrays.stream(v)
                .average()
                .getAsDouble();
    }

}
