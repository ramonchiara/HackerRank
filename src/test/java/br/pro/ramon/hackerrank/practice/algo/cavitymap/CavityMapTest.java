package br.pro.ramon.hackerrank.practice.algo.cavitymap;

import java.util.Arrays;
import java.util.List;
import org.junit.Assert;
import org.junit.Test;

public class CavityMapTest {

    @Test
    public void testExample() {
        List<String> grid = Arrays.asList(new String[]{"989", "191", "111"});
        List<String> expected = Arrays.asList(new String[]{"989", "1X1", "111"});
        List<String> cavityMap = Result.cavityMap(grid);
        Assert.assertEquals(expected, cavityMap);
    }

    @Test
    public void testSample1() {
        List<String> grid = Arrays.asList(new String[]{"1112", "1912", "1892", "1234"});
        List<String> expected = Arrays.asList(new String[]{"1112", "1X12", "18X2", "1234"});
        List<String> cavityMap = Result.cavityMap(grid);
        Assert.assertEquals(expected, cavityMap);
    }

}
