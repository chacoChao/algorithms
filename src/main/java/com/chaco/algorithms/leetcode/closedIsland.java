package com.chaco.algorithms.leetcode;

import java.util.Objects;

/**
 * {@linkplain https://leetcode.cn/problems/number-of-closed-islands/}
 * 二维矩阵 grid 由 0 （土地）和 1 （水）组成。岛是由最大的4个方向连通的 0 组成的群，封闭岛是一个 完全 由1包围（左、上、右、下）的岛。
 * <p>
 * 请返回 封闭岛屿 的数目。
 */
public class closedIsland {
    public static void main(String[] args) {
        System.out.println("closedIsland.main");
    }

    public static int closedIsland(int[][] grid) {
        int res = 0, m = grid.length, n = grid[0].length;
        for (int j = 0; j < n; j++) {
            // 把靠上边的岛屿淹掉
            dfs(grid, 0, j);
            // 把靠下边的岛屿淹掉
            dfs(grid, m - 1, j);
        }
        for (int i = 0; i < m; i++) {
            // 把靠左边的岛屿淹掉
            dfs(grid, i, 0);
            // 把靠右边的岛屿淹掉
            dfs(grid, i, n - 1);
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (Objects.equals(0, grid[i][j])) {
                    res++;
                    dfs(grid, i, j);
                }
            }
        }
        return res;
    }

    private static void dfs(int[][] grid, int i, int j) {
        int m = grid.length;
        int n = grid[0].length;
        if (i < 0 || j < 0 || i >= m || j >= n) {
            return;
        }
        if (Objects.equals(grid[i][j], 1)) {
            return;
        }
        grid[i][j] = 1;
        dfs(grid, i + 1, j);
        dfs(grid, i, j + 1);
        dfs(grid, i - 1, j);
        dfs(grid, i, j - 1);
    }
}