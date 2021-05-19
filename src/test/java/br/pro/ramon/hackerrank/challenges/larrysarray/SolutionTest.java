package br.pro.ramon.hackerrank.challenges.larrysarray;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.junit.Test;

public class SolutionTest {

    @Test
    public void test1() {
        int[] v = new int[]{3, 1, 2};
        assertTrue(Solution.canSort(v));
    }

    @Test
    public void test2() {
        int[] v = new int[]{1, 3, 4, 2};
        assertTrue(Solution.canSort(v));
    }

    @Test
    public void test3() {
        int[] v = new int[]{1, 2, 3, 5, 4};
        assertFalse(Solution.canSort(v));
    }

    @Test
    public void test4() {
        int[] v = new int[]{2, 4, 3, 5, 1};
        assertFalse(Solution.canSort(v));
    }

    @Test
    public void test5() {
        int[] v = new int[]{1, 1, 1};
        assertTrue(Solution.canSort(v));
    }

    @Test
    public void test6() {
        int[] v = new int[]{1, 1, 1, 1};
        assertTrue(Solution.canSort(v));
    }

    @Test
    public void test7() {
        int[] v = new int[]{1, 1, 1, 2};
        assertTrue(Solution.canSort(v));
    }

    @Test
    public void test8() {
        int[] v = new int[]{1, 1, 2, 1};
        assertTrue(Solution.canSort(v));
    }

    @Test
    public void test9() {
        int[] v = new int[]{1, 2, 1, 1};
        assertTrue(Solution.canSort(v));
    }

    @Test
    public void test10() {
        int[] v = new int[]{2, 1, 1, 1};
        assertTrue(Solution.canSort(v));
    }

    @Test
    public void test11() {
        int[] v = new int[]{2, 1, 2, 1};
        assertTrue(Solution.canSort(v));
    }

}
