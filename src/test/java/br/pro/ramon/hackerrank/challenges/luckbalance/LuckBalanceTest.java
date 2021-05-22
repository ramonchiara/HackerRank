package br.pro.ramon.hackerrank.challenges.luckbalance;

import org.junit.Test;
import static org.junit.Assert.*;

public class LuckBalanceTest {

    @Test
    public void testExample1a() {
        int k = 2;
        int[][] contests = {
            {5, 1},
            {1, 1},
            {4, 0}
        };

        assertEquals(10, Result.luckBalance(k, contests));
    }

    @Test
    public void testExample1b() {
        int k = 1;
        int[][] contests = {
            {5, 1},
            {1, 1},
            {4, 0}
        };

        assertEquals(8, Result.luckBalance(k, contests));
    }

    @Test
    public void testSample() {
        int k = 3;
        int[][] contests = {
            {5, 1},
            {2, 1},
            {1, 1},
            {8, 1},
            {10, 0},
            {5, 0}
        };

        assertEquals(29, Result.luckBalance(k, contests));
    }
    
}
