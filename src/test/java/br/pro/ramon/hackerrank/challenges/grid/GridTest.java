package br.pro.ramon.hackerrank.challenges.grid;

import java.util.ArrayList;
import java.util.List;
import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class GridTest {

    @Test
    public void testExample() {
        List<String> grid = new ArrayList<>();
        grid.add("abc");
        grid.add("ade");
        grid.add("efg");
        assertEquals("YES", Result.gridChallenge(grid));
    }

    @Test
    public void testSample() {
        List<String> grid = new ArrayList<>();
        grid.add("ebacd");
        grid.add("fghij");
        grid.add("olmkn");
        grid.add("trpqs");
        grid.add("xywuv");
        assertEquals("YES", Result.gridChallenge(grid));
    }

    @Test
    public void testCase11() {
        List<String> grid = new ArrayList<>();
        grid.add("abc");
        grid.add("lmp");
        grid.add("qrt");
        assertEquals("YES", Result.gridChallenge(grid));
    }

    @Test
    public void testCase12() {
        List<String> grid = new ArrayList<>();
        grid.add("mpxz");
        grid.add("abcd");
        grid.add("wlmf");
        assertEquals("NO", Result.gridChallenge(grid));
    }

    @Test
    public void testCase13() {
        List<String> grid = new ArrayList<>();
        grid.add("abc");
        grid.add("hjk");
        grid.add("mpq");
        grid.add("rtv");
        assertEquals("YES", Result.gridChallenge(grid));
    }

}
