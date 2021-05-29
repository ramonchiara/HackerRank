package br.pro.ramon.hackerrank.challenges.marktoys;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import org.junit.Test;
import static org.junit.Assert.*;

public class MarkAndToysTest {

    @Test
    public void testExample() {
        int[] prices = {1, 2, 3, 4};
        int k = 7;
        assertEquals(3, Result.maximumToys(asList(prices), k));
    }

    @Test
    public void testSample() {
        int[] prices = {1, 12, 5, 111, 200, 1000, 10};
        int k = 50;
        assertEquals(4, Result.maximumToys(asList(prices), k));
    }

    private static List<Integer> asList(int[] prices) {
        return Arrays.stream(prices).mapToObj(Integer::valueOf).collect(Collectors.toList());
    }
}
