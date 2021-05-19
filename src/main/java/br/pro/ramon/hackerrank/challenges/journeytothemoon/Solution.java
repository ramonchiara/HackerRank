package br.pro.ramon.hackerrank.challenges.journeytothemoon;

import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        int p = in.nextInt();

        boolean[][] g = new boolean[n][n];

        for (int i = 0; i < p; i++) {
            int a = in.nextInt();
            int b = in.nextInt();
            g[a][b] = true;
            g[b][a] = true;
        }

        int count = count(g);

        System.out.println(count);
    }

    public static int count(boolean[][] g) {
        int count = 0;

        for (int i = 0; i < g.length - 1; i++) {
            for (int j = i + 1; j < g[i].length; j++) {
                if (!g[i][j] && hasWay(g, i, j)) {
                    g[i][j] = true;
                    g[j][i] = true;
                }
            }
        }

        for (int i = 0; i < g.length - 1; i++) {
            for (int j = i + 1; j < g[i].length; j++) {
                if (!g[i][j]) {
                    count++;
                }
            }
        }

        return count;
    }

    public static boolean hasWay(boolean[][] g, int i, int j) {
        boolean result = false;

        if (g[i][j]) {
            result = true;
        } else {
            for (int ix = i + 1; ix < g.length; ix++) {
                if (g[i][ix] && hasWay(g, ix, j)) {
                    result = true;
                    break;
                }
            }
        }

        return result;
    }

}
