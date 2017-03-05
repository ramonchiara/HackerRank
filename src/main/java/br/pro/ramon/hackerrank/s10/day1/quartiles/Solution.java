package br.pro.ramon.hackerrank.s10.day1.quartiles;

import java.util.Arrays;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int n = scan.nextInt();
        int[] v = new int[n];

        for (int i = 0; i < n; i++) {
            v[i] = scan.nextInt();
        }

        System.out.printf("%d%n", getQuartil(v, 1));
        System.out.printf("%d%n", getQuartil(v, 2));
        System.out.printf("%d%n", getQuartil(v, 3));
    }

    public static int getQuartil(int[] v, int q) {
        int l = 0, r = v.length - 1;

        if (q == 1) {
            r = v.length / 2 - 1;
        } else if (q == 3) {
            l = v.length / 2 + (v.length % 2);
        }

        return (int) getMedian(v, l, r);
    }

    public static double getMedian(int[] v, int l, int r) {
        int length = r - l + 1;

        int skip = l + length / 2 - (1 - length % 2);
        int limit = length % 2 == 0 ? 2 : 1;

        double median = Arrays.stream(v)
                .sorted()
                .skip(skip)
                .limit(limit)
                .average()
                .getAsDouble();

        return median;
    }

}
