package br.pro.ramon.hackerrank.challenges.minmaxsum;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        Long[] v = new Long[5];
        for (int i = 0; i < v.length; i++) {
            v[i] = in.nextLong();
        }

        LongSummaryStatistics stats = IntStream.range(0, v.length)
                .mapToObj(i -> IntStream.range(0, v.length).filter(j -> j != i).mapToObj(j -> v[j]).collect(Collectors.toList()))
                .flatMap(l -> Stream.of(l.stream().mapToLong(Long::longValue).sum()))
                .collect(Collectors.summarizingLong(Long::longValue));

        System.out.printf("%d %d", stats.getMin(), stats.getMax());

    }
}
