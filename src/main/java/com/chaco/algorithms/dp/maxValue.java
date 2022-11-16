package com.chaco.algorithms.dp;

import java.util.Objects;

/**
 * https://www.nowcoder.com/practice/2237b401eb9347d282310fc1c3adb134
 * https://leetcode.cn/problems/li-wu-de-zui-da-jie-zhi-lcof/solutions/
 * 在一个m\times nm×n的棋盘的每一格都放有一个礼物，每个礼物都有一定的价值（价值大于 0）。
 * 你可以从棋盘的左上角开始拿格子里的礼物，并每次向右或者向下移动一格、直到到达棋盘的右下角。
 * 给定一个棋盘及其上面的礼物的价值，请计算你最多能拿到多少价值的礼物？
 * 如输入这样的一个二维数组，
 * [
 * [1,3,1],
 * [1,5,1],
 * [4,2,1]
 * ]
 * 那么路径 1→3→5→2→1 可以拿到最多价值的礼物，价值为12
 */
public class maxValue {
    public static void main(String[] args) {
        int[][] arr = new int[][]{{1, 3, 1}, {1, 5, 1}, {4, 2, 1}};
        int maxValue = maxValueFunc(arr);
        System.out.println("maxValue.main:" + maxValue);
    }

    // dp[i][j]=grid[i][j]+max(dp[i−1][j],dp[i][j−1])
    // dp[i][j]=grid[i][j]+max(dp[i-1][j],dp[i][j-1])
    // dp[i][j]=grid[i][j]+max(dp[i−1][j],dp[i][j−1]).
    public static int maxValueFunc(int[][] grid) {
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (i == 0 && j == 0) continue;
                if (Objects.equals(0, i)) {
                    grid[i][j] += grid[i][j - 1];
                } else if (Objects.equals(0, j)) {
                    grid[i][j] += grid[i - 1][j];
                } else {
                    grid[i][j] += Math.max(grid[i][j - 1], grid[i - 1][j]);
                }
            }
        }
        return grid[grid.length - 1][grid[0].length - 1];
    }
}