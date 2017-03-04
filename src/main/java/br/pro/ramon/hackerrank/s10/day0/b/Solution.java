package br.pro.ramon.hackerrank.s10.day0.b;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

public class Solution {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int n = scan.nextInt();
        int[] v = new int[n];
        int[] w = new int[n];

        for (int i = 0; i < n; i++) {
            v[i] = scan.nextInt();
        }
        for (int i = 0; i < n; i++) {
            w[i] = scan.nextInt();
        }

        System.out.printf("%.1f%n", getWeightedMean(v, w));

    }

    public static double getWeightedMean(int[] v, int[] w) {
        int sv = IntStream
                .range(0, v.length)
                .map(i -> v[i] * w[i])
                .sum();

        int sw = Arrays.stream(w)
                .sum();

        return (double) sv / sw;
    }

}
