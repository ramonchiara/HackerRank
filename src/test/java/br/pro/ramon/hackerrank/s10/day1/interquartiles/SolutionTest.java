package br.pro.ramon.hackerrank.s10.day1.interquartiles;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class SolutionTest {

    @Test
    public void test() {
        int[] x = new int[]{6, 12, 8, 10, 20, 16};
        int[] f = new int[]{5, 4, 3, 2, 1, 5};
        int[] s = Solution.getS(x, f);
        double iqr = Solution.getInterquartileRange(s);

        assertArrayEquals(new int[]{6, 6, 6, 6, 6, 12, 12, 12, 12, 8, 8, 8, 10, 10, 20, 16, 16, 16, 16, 16}, s);
        assertEquals(9.0, iqr, 0.000001);
    }

}
