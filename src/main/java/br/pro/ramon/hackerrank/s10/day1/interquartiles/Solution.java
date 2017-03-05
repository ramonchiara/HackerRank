package br.pro.ramon.hackerrank.s10.day1.interquartiles;

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

        int[] f = new int[n];
        for (int i = 0; i < n; i++) {
            f[i] = scan.nextInt();
        }

        int[] s = getS(x, f);

        System.out.printf("%.1f%n", getInterquartileRange(s));
    }

    public static int[] getS(int[] x, int[] f) {
        return IntStream
                .range(0, x.length)
                .flatMap(i -> IntStream.generate(() -> x[i]).limit(f[i]))
                .toArray();
    }

    public static double getInterquartileRange(int[] v) {
        return getQuartil(v, 3) - getQuartil(v, 1);
    }

    public static double getQuartil(int[] v, int q) {
        int l = 0, r = v.length - 1;

        if (q == 1) {
            r = v.length / 2 - 1;
        } else if (q == 3) {
            l = v.length / 2 + (v.length % 2);
        }

        return getMedian(v, l, r);
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
