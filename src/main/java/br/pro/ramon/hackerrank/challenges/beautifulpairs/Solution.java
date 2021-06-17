package br.pro.ramon.hackerrank.challenges.beautifulpairs;

import java.io.*;
import java.util.*;
import static java.util.function.Function.identity;
import java.util.stream.*;
import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.toList;

class Result {

    /*
     * Complete the 'beautifulPairs' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER_ARRAY A
     *  2. INTEGER_ARRAY B
     */
    public static int beautifulPairs(List<Integer> A, List<Integer> B) {
        changeOneElementInB(A, B);
        List<Integer[]> beautifulSet = createPairwiseDisjointedBeautifulSet(A, B);
        return beautifulSet.size();
    }

    static void changeOneElementInB(List<Integer> A, List<Integer> B) {
        int j = findBestPlaceToChange(A, B);
        Integer onlyInA = elementOnlyInA(A, B);
        if (A != null) {
            B.set(j, onlyInA);
        } else {
            B.set(j, B.stream().max(Integer::compare).get() + 1);
        }
    }

    static int findBestPlaceToChange(List<Integer> A, List<Integer> B) {
        Integer onlyInB = elementOnlyInB(A, B);
        Integer mostRepeated = mostRepeatedElementIn(B);
        int j1 = B.indexOf(onlyInB);
        int j2 = B.indexOf(mostRepeated);
        return j1 >= 0 ? j1 : j2 >= 0 ? j2 : 0;
    }

    static Integer elementOnlyInA(List<Integer> A, List<Integer> B) {
        List<Integer> onlyInA = A.stream().filter(e -> !B.contains(e)).collect(Collectors.toList());
        return onlyInA.isEmpty() ? null : onlyInA.get(0);
    }

    static Integer elementOnlyInB(List<Integer> A, List<Integer> B) {
        List<Integer> onlyInB = B.stream().filter(e -> !A.contains(e)).collect(Collectors.toList());
        return onlyInB.isEmpty() ? null : onlyInB.get(0);
    }

    static Integer mostRepeatedElementIn(List<Integer> L) {
        return L.stream()
                .collect(groupingBy(identity(), counting()))
                .entrySet().stream()
                .max(Map.Entry.comparingByValue())
                .get().getKey();
    }

    static List<Integer[]> createBeautifulSet(List<Integer> A, List<Integer> B) {
        return IntStream.range(0, A.size())
                .mapToObj(i -> IntStream.range(0, B.size()).mapToObj(j -> new Integer[]{i, j}))
                .flatMap(s -> s.sequential())
                .filter(pair -> isBeautifulPair(pair, A, B))
                .collect(Collectors.toList());
    }

    static List<Integer[]> createPairwiseDisjointedBeautifulSet(List<Integer> A, List<Integer> B) {
        List<Integer[]> pairwiseDisjointedBeautifulSet = new ArrayList<>();
        createBeautifulSet(A, B).stream().
                filter(pair -> !pairwiseDisjointedBeautifulSet.stream().anyMatch(cached -> isJointed(pair, cached)))
                .forEach(pairwiseDisjointedBeautifulSet::add);
        return pairwiseDisjointedBeautifulSet;
    }

    static boolean isBeautifulPair(Integer[] pair, List<Integer> A, List<Integer> B) {
        Integer i = pair[0];
        Integer j = pair[1];
        return Objects.equals(A.get(i), B.get(j));
    }

    static boolean isPairwiseDisjointed(List<Integer[]> beautifulSet) {
        return !IntStream.range(0, beautifulSet.size() - 1)
                .mapToObj(i -> IntStream.range(i + 1, beautifulSet.size()).mapToObj(j -> new Integer[][]{beautifulSet.get(i), beautifulSet.get(j)}))
                .flatMap(s -> s.sequential())
                .anyMatch(e -> isJointed(e[0], e[1]));
    }

    static boolean isJointed(Integer[] pair1, Integer[] pair2) {
        Integer l1 = pair1[0];
        Integer l2 = pair2[0];
        Integer r1 = pair1[1];
        Integer r2 = pair2[1];
        return Objects.equals(l1, l2) || Objects.equals(r1, r2);
    }
}

public class Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> A = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        List<Integer> B = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        int result = Result.beautifulPairs(A, B);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
