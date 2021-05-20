package br.pro.ramon.hackerrank.challenges.mcakewalk;

import java.util.Arrays;
import org.junit.Test;
import static org.junit.Assert.*;

public class MarcsCakewalkTest {

    @Test
    public void testExample() {
        assertEquals(44, Result.marcsCakewalk(Arrays.asList(5, 10, 7)));
    }

    @Test
    public void testSample0() {
        assertEquals(11, Result.marcsCakewalk(Arrays.asList(1, 3, 2)));
    }

    @Test
    public void testSample1() {
        assertEquals(79, Result.marcsCakewalk(Arrays.asList(7, 4, 9, 6)));
    }
}
