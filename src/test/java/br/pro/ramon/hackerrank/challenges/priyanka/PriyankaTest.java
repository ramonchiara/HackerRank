package br.pro.ramon.hackerrank.challenges.priyanka;

import java.util.Arrays;
import org.junit.Test;
import static org.junit.Assert.*;

public class PriyankaTest {

    @Test
    public void testExample() {
        Integer[] w = {1, 2, 3, 4, 5, 10, 11, 12, 13};
        assertEquals(2, Result.toys(Arrays.asList(w)));
    }

    @Test
    public void testSample() {
        Integer[] w = {1, 2, 3, 21, 7, 12, 14, 21};
        assertEquals(4, Result.toys(Arrays.asList(w)));
    }
}
