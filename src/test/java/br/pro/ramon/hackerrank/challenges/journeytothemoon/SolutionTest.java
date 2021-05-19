package br.pro.ramon.hackerrank.challenges.journeytothemoon;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.junit.Test;

public class SolutionTest {

    @Test
    public void test0() {
        boolean[][] g = new boolean[][]{
            {false, true, false, false},
            {true, false, false, false},
            {false, false, false, true},
            {false, false, true, false}
        };

        assertEquals(4, Solution.count(g));
    }

    @Test
    public void test1() {
        boolean[][] g = new boolean[][]{
            {false, true, false, false},
            {true, false, true, false},
            {false, true, false, false},
            {false, false, false, false}
        };

        /*
        assertTrue(Solution.hasWay(g, 0, 1));
        assertTrue(Solution.hasWay(g, 1, 0));
        assertTrue(Solution.hasWay(g, 1, 2));
        assertTrue(Solution.hasWay(g, 2, 1));
        assertTrue(Solution.hasWay(g, 0, 2));
        assertTrue(Solution.hasWay(g, 2, 0));
        assertFalse(Solution.hasWay(g, 0, 3));
        */
        
        assertEquals(3, Solution.count(g));
    }
}
