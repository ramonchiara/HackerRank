package br.pro.ramon.hackerrank.challenges.luckbalance;

import java.io.*;
import java.util.*;
import java.util.stream.*;
import static java.util.stream.Collectors.toList;

class Result {

    /*
     * Complete the 'luckBalance' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER k
     *  2. 2D_INTEGER_ARRAY contests
     */
    public static int luckBalance(int k, List<List<Integer>> contests) {
        contests.sort((o1, o2) -> {
            int l1 = o1.get(0);
            int t1 = o1.get(1);
            int l2 = o2.get(0);
            int t2 = o2.get(1);

            int byL = Integer.compare(l1, l2);
            int byT = Integer.compare(t1, t2);

            return byT != 0 ? byT : -byL;
        });

        int luck = 0;
        int loses = 0;

        for (int i = 0; i < contests.size(); i++) {
            int l = contests.get(i).get(0);
            int t = contests.get(i).get(1);

            if (t == 0) {
                luck += l;
            }
            if (t == 1) {
                if (loses < k) {
                    luck += l;
                    loses++;
                } else {
                    luck -= l;
                }
            }
        }

        return luck;
    }

    public static int luckBalance(int k, int[][] contests) {
        List<List<Integer>> contestsAsList = new ArrayList<>();

        for (int l = 0; l < contests.length; l++) {
            List<Integer> contest = new ArrayList<>();
            contest.add(contests[l][0]);
            contest.add(contests[l][1]);
            contestsAsList.add(contest);
        }

        return luckBalance(k, contestsAsList);
    }
}

public class Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int n = Integer.parseInt(firstMultipleInput[0]);

        int k = Integer.parseInt(firstMultipleInput[1]);

        List<List<Integer>> contests = new ArrayList<>();

        IntStream.range(0, n).forEach(i -> {
            try {
                contests.add(
                        Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                                .map(Integer::parseInt)
                                .collect(toList())
                );
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        int result = Result.luckBalance(k, contests);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
