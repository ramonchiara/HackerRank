package br.pro.ramon.hackerrank.s10.day1.quartiles;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class SolutionTest {

    @Test
    public void test5() {
        int[] v = new int[]{3, 7, 8, 5, 12};
        assertEquals(4, Solution.getQuartil(v, 1));
        assertEquals(7, Solution.getQuartil(v, 2));
        assertEquals(10, Solution.getQuartil(v, 3));
    }

    @Test
    public void test6() {
        int[] v = new int[]{3, 7, 8, 5, 12, 14};
        assertEquals(5, Solution.getQuartil(v, 1));
        assertEquals(7, Solution.getQuartil(v, 2));
        assertEquals(12, Solution.getQuartil(v, 3));
    }

    @Test
    public void test7() {
        int[] v = new int[]{3, 7, 8, 5, 12, 14, 21};
        assertEquals(5, Solution.getQuartil(v, 1));
        assertEquals(8, Solution.getQuartil(v, 2));
        assertEquals(14, Solution.getQuartil(v, 3));
    }

    @Test
    public void test8() {
        int[] v = new int[]{3, 7, 8, 5, 14, 21, 13, 18};
        assertEquals(6, Solution.getQuartil(v, 1));
        assertEquals(10, Solution.getQuartil(v, 2));
        assertEquals(16, Solution.getQuartil(v, 3));
    }

    @Test
    public void test9() {
        int[] v = new int[]{3, 7, 8, 5, 12, 14, 21, 13, 18};
        assertEquals(6, Solution.getQuartil(v, 1));
        assertEquals(12, Solution.getQuartil(v, 2));
        assertEquals(16, Solution.getQuartil(v, 3));
    }

    @Test
    public void test10() {
        int[] v = new int[]{3, 7, 8, 5, 12, 14, 21, 13, 18, 42};
        assertEquals(7, Solution.getQuartil(v, 1));
        assertEquals(12, Solution.getQuartil(v, 2));
        assertEquals(18, Solution.getQuartil(v, 3));
    }

}
