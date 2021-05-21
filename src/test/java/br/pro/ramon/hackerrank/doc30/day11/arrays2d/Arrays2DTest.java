package br.pro.ramon.hackerrank.doc30.day11.arrays2d;

import static br.pro.ramon.hackerrank.doc30.day11.arrays2d.Solution.maxHourglasses;
import org.junit.Test;
import static org.junit.Assert.*;

public class Arrays2DTest {

    @Test
    public void testExample() {
        int[][] a = {
            {1, 1, 1, 0, 0, 0},
            {0, 1, 0, 0, 0, 0},
            {1, 1, 1, 0, 0, 0},
            {0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0}
        };

        assertEquals(7, maxHourglasses(a));
    }

    @Test
    public void testSampleInput() {
        int[][] a = {
            {1, 1, 1, 0, 0, 0},
            {0, 1, 0, 0, 0, 0},
            {1, 1, 1, 0, 0, 0},
            {0, 0, 2, 4, 4, 0},
            {0, 0, 0, 2, 0, 0},
            {0, 0, 1, 2, 4, 0}
        };

        assertEquals(19, maxHourglasses(a));
    }

}
