package com.chaco.algorithms.leetcode;

import java.util.Objects;

/**
 * {@link <a href="https://leetcode.cn/problems/number-of-islands/">problems</a>}
 * 给你一个由 '1'（陆地）和 '0'（水）组成的的二维网格，请你计算网格中岛屿的数量。
 * 岛屿总是被水包围，并且每座岛屿只能由水平方向和/或竖直方向上相邻的陆地连接形成。
 * 此外，你可以假设该网格的四条边均被水包围。
 * example
 * 输入：grid = [
 * ["1","1","1","1","0"],
 * ["1","1","0","1","0"],
 * ["1","1","0","0","0"],
 * ["0","0","0","0","0"]
 * ]
 * 输出：1
 * 示例 2：
 * 输入：grid = [
 * ["1","1","0","0","0"],
 * ["1","1","0","0","0"],
 * ["0","0","1","0","0"],
 * ["0","0","0","1","1"]
 * ]
 * 输出：3
 */
public class numIslands {
    public static void main(String[] args) {
        char[][] arr = new char[][]{
                {'1', '1', '0', '0', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '1', '0', '0'},
                {'0', '0', '0', '1', '1'}
        };
        int numIslands = numIslands(arr);
        System.out.println("numIslands.main" + numIslands);
    }

    public static int numIslands(char[][] grid) {
        int res = 0;
        int len = grid.length, len2 = grid[0].length;
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len2; j++) {
                if (Objects.equals('1', grid[i][j])) {
                    res++;
                    dfs(grid, i, j);
                }
            }
        }
        return res;
    }

    private static void dfs(char[][] grid, int i, int j) {
        int m = grid.length, n = grid[0].length;
        if (i >= m || j >= n || j < 0 || i < 0) {
            return;
        }
        if (Objects.equals('0', grid[i][j])) {
            return;
        }
        grid[i][j] = '0';
        dfs(grid, i + 1, j);
        dfs(grid, i, j + 1);
        dfs(grid, i - 1, j);
        dfs(grid, i, j - 1);
    }
}