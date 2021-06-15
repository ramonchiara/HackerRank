package br.pro.ramon.hackerrank.challenges.priyanka;

import java.io.*;
import java.util.*;
import java.util.stream.*;
import static java.util.stream.Collectors.toList;

class Result {

    /*
     * Complete the 'toys' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts INTEGER_ARRAY w as parameter.
     */
    public static int toys(List<Integer> w) {
        // Write your code here
        int result = 1;
        w.sort(Integer::compare);

        int first = w.get(0);
        for (int i = 1; i < w.size(); i++) {
            int next = w.get(i);
            if (next > first + 4) {
                result++;
                first = next;
            }
        }

        return result;
    }

}

public class Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> w = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        int result = Result.toys(w);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
