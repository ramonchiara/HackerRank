package br.pro.ramon.hackerrank.doc30.day11.arrays2d;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import static java.util.stream.Collectors.toList;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        List<List<Integer>> arr = new ArrayList<>();

        IntStream.range(0, 6).forEach(i -> {
            try {
                arr.add(
                        Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                                .map(Integer::parseInt)
                                .collect(toList())
                );
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        int[][] a = arr.stream()
                .map(l -> l.stream().mapToInt(Integer::intValue).toArray())
                .toArray(int[][]::new);

        System.out.println(maxHourglasses(a));

        bufferedReader.close();
    }

    public static int maxHourglasses(int[][] a) {
        final int HOURGLASS_HEIGHT = 3;
        final int HOURGLASS_WIDTH = 3;

        int max = Integer.MIN_VALUE;

        for (int l = 0; l < a.length - HOURGLASS_HEIGHT + 1; l++) {
            for (int c = 0; c < a[0].length - HOURGLASS_WIDTH + 1; c++) {
                int sum = a[l + 0][c + 0] + a[l + 0][c + 1] + a[l + 0][c + 2]
                                          + a[l + 1][c + 1]
                        + a[l + 2][c + 0] + a[l + 2][c + 1] + a[l + 2][c + 2];
                if (sum > max) {
                    max = sum;
                }
            }
        }

        return max;
    }

}
