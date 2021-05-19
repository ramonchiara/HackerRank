package br.pro.ramon.hackerrank.challenges.larrysarray;

import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int testCases = in.nextInt();
        for (int i = 0; i < testCases; i++) {
            int[] v = readArray(in);
            System.out.printf("%s%n", canSort(v) ? "YES" : "NO");
        }
    }

    private static int[] readArray(Scanner in) {
        int n = in.nextInt();
        int[] v = new int[n];
        for (int i = 0; i < v.length; i++) {
            v[i] = in.nextInt();
        }

        return v;
    }

    public static boolean canSort(int[] v) {
        boolean result = true;

        for (int i = v.length - 3; i >= 0; i--) {
            boolean sequence3 = false;
            for (int j = 0; j < 3; j++) {
                if (!isSequence3(v, i)) {
                    rotate(v, i);
                } else {
                    sequence3 = true;
                    break;
                }
            }
            if (!sequence3) {
                result = false;
                break;
            }
        }

        return result;
    }

    private static boolean isSequence3(int[] v, int i) {
        return v[i] <= v[i + 1] && v[i + 1] <= v[i + 2];
    }

    private static void rotate(int[] v, int i) {
        int k = v[i];
        v[i + 0] = v[i + 1];
        v[i + 1] = v[i + 2];
        v[i + 2] = k;
    }

}
