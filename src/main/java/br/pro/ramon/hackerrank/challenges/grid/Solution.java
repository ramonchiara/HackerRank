package br.pro.ramon.hackerrank.challenges.grid;

import java.io.*;
import java.util.*;
import java.util.stream.*;
import static java.util.stream.Collectors.toList;

class Result {

    /*
     * Complete the 'gridChallenge' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts STRING_ARRAY grid as parameter.
     */
    public static String gridChallenge(List<String> grid) {
        grid = grid.stream()
                .map(String::toCharArray)
                .map(a -> {
                    Arrays.sort(a);
                    return a;
                })
                .map(String::new)
                .collect(Collectors.toList());

        for (int c = 0; c < grid.get(0).length(); c++) {
            if (!isColumnSorted(c, grid)) {
                return "NO";
            }
        }

        return "YES";
    }

    private static boolean isColumnSorted(int c, List<String> grid) {
        List<Character> col = grid.stream()
                .map(s -> s.charAt(c))
                .collect(Collectors.toList());

        return !IntStream.range(0, col.size() - 1).anyMatch(i -> col.get(i) > col.get(i + 1));
    }

}

public class Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int t = Integer.parseInt(bufferedReader.readLine().trim());

        IntStream.range(0, t).forEach(tItr -> {
            try {
                int n = Integer.parseInt(bufferedReader.readLine().trim());

                List<String> grid = IntStream.range(0, n).mapToObj(i -> {
                    try {
                        return bufferedReader.readLine();
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    }
                })
                        .collect(toList());

                String result = Result.gridChallenge(grid);

                bufferedWriter.write(result);
                bufferedWriter.newLine();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        bufferedReader.close();
        bufferedWriter.close();
    }
}
