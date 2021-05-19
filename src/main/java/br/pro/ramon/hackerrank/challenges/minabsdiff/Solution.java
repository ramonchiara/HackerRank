package br.pro.ramon.hackerrank.challenges.minabsdiff;

import java.util.*;
import java.util.stream.Collectors;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int[] v = {-2, 2, 4};
        int min = minimumAbsoluteDifference(v);
        System.out.printf("min = %d | esperado = %d%n", min, 2);

        v = new int[]{3, -7, 0};
        min = minimumAbsoluteDifference(v);
        System.out.printf("min = %d | esperado = %d%n", min, 3);

        v = new int[]{-59, -36, -13, 1, -53, -92, -2, -96, -54, 75};
        min = minimumAbsoluteDifference(v);
        System.out.printf("min = %d | esperado = %d%n", min, 1);

        v = new int[]{1, -3, 71, 68, 17};
        min = minimumAbsoluteDifference(v);
        System.out.printf("min = %d | esperado = %d%n", min, 3);

        /*
        v = readArray(in);
        min = minimumAbsoluteDifference(Arrays.stream(v).boxed().collect(Collectors.toList()));
        System.out.printf("%d%n", min);
         */
    }

    private static int[] readArray(Scanner in) {
        int n = in.nextInt();
        int[] v = new int[n];
        for (int i = 0; i < v.length; i++) {
            v[i] = in.nextInt();
        }

        return v;
    }

    public static int minimumAbsoluteDifference(int[] arr) {
        return minimumAbsoluteDifference(Arrays.stream(arr).boxed().collect(Collectors.toList()));
    }

    public static int minimumAbsoluteDifference(List<Integer> arr) {
        int result = 1_000_000_000; // 10E9
        arr.sort(Integer::compare);

        for (int i = 0; i < arr.size() - 1; i++) {
            int a = arr.get(i);
            int b = arr.get(i + 1);
            int diff = Math.abs(a - b);
            if (diff < result) {
                result = diff;
            }
        }

        return result;
    }

    public static int minimumAbsoluteDifferenceN2(List<Integer> arr) {
        int result = 1_000_000_000; // 10E9

        for (int i = 0; i < arr.size() - 1; i++) {
            for (int j = i + 1; j < arr.size(); j++) {
                int a = arr.get(i);
                int b = arr.get(j);
                int diff = Math.abs(a - b);
                if (diff < result) {
                    result = diff;
                }
            }
        }

        return result;
    }

}
