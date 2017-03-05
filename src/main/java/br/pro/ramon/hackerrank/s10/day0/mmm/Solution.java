package br.pro.ramon.hackerrank.s10.day0.mmm;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Solution {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int n = scan.nextInt();
        int[] v = new int[n];

        for (int i = 0; i < n; i++) {
            v[i] = scan.nextInt();
        }

        System.out.printf("%.1f%n%.1f%n%d%n", getMean(v), getMedian(v), getMode(v));
    }

    public static double getMean(int[] v) {
        return Arrays.stream(v)
                .average()
                .getAsDouble();
    }

    public static double getMedian(int[] v) {
        return getMedian(v, 0, v.length - 1);
    }

    public static int getMode(int[] v) {
        return Arrays.stream(v)
                .mapToObj(Integer::new)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet().stream()
                .sorted(Map.Entry.comparingByKey())
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .findFirst()
                .get()
                .getKey();
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
