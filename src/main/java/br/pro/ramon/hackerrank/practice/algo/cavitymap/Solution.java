package br.pro.ramon.hackerrank.practice.algo.cavitymap;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;
import java.util.stream.IntStream;

public class Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<String> grid = IntStream.range(0, n).mapToObj(i -> {
            try {
                return bufferedReader.readLine();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        })
                .collect(toList());

        List<String> result = Result.cavityMap(grid);

        bufferedWriter.write(
                result.stream()
                        .collect(joining("\n"))
                + "\n"
        );

        bufferedReader.close();
        bufferedWriter.close();
    }

}

class Result {

    public static List<String> cavityMap(List<String> grid) {
        List<String> result = new ArrayList<>(grid);

        for (int i = 1; i < grid.size() - 1; i++) {
            for (int j = 1; j < grid.get(i).length() - 1; j++) {
                int cell = v(grid, i, j);
                int north = v(grid, i - 1, j);
                int south = v(grid, i + 1, j);
                int east = v(grid, i, j - 1);
                int west = v(grid, i, j + 1);

                if (cell > north && cell > south && cell > east && cell > west) {
                    char[] line = result.get(i).toCharArray();
                    line[j] = 'X';
                    result.set(i, new String(line));
                }
            }
        }

        return result;
    }

    private static int v(List<String> grid, int i, int j) {
        return grid.get(i).charAt(j) - '0';
    }

}
