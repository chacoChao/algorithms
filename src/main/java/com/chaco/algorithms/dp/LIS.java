package com.chaco.algorithms.dp;

import java.util.Arrays;

/**
 * 最长递增子序列（Longest Increasing Subsequence，简写 LIS）是非常经典的一个算法问题，
 * 比较容易想到的是动态规划解法，时间复杂度 O(N^2)，
 * 我们借这个问题来由浅入深讲解如何找状态转移方程，如何写出动态规划解法。
 * 比较难想到的是利用二分查找，时间复杂度是 O(NlogN)，
 * 我们通过一种简单的纸牌游戏来辅助理解这种巧妙的解法。
 *
 * @author zhaopeiyan
 * @date 2021/12/10 4:07 PM
 */
public class LIS {
    /**
     * 动态规划方法，注意状态转移数组边界值设定
     *
     * @param arrs args
     * @return int
     */
    public static int longestIncreasingSub(int[] arrs) {
        int[] dp = new int[arrs.length + 1];
        for (int i = 1; i < arrs.length; i++) {
            for (int j = 0; j <= i; j++) {
                if (arrs[i] > arrs[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }
        return Arrays.stream(dp).max().getAsInt() + 1;
    }

    public static void main(String[] args) {
        int i = LIS.longestIncreasingSub(new int[]{1, 4, 3, 4, 2});
        int i1 = LIS.longestIncreasingSub(new int[]{10, 9, 2, 5, 3, 7, 101, 18});
        int i2 = LIS.longestIncreasingSub(new int[]{0, 1, 0, 3, 2, 3});
        int i3 = LIS.longestIncreasingSub(new int[]{7, 7, 7, 7, 7, 7, 7});
        System.out.println(i + i1 + i2 + i3);

        int i4 = LIS.lengthOfLIS(new int[]{10, 9, 2, 5, 3, 7, 101, 18});
        System.out.println(i4);
    }

    /**
     * 贪心算法 + 二分查找
     *
     * @param arrs args
     * @return int
     */
    public static int lengthOfLIS(int[] arrs) {
        int[] top = new int[arrs.length + 1];
        //牌堆数初始化
        int piles = 0;
        for (int poker : arrs) {
            int left = 0, right = piles;
            while (left < right) {
                int mid = (left + right) / 2;
                if (top[mid] > poker) {
                    right = mid;
                } else if (top[mid] < poker) {
                    left = mid + 1;
                } else {
                    right = mid;
                }
            }

            if (left == piles) {
                piles++;
            }
            top[left] = poker;
        }
        return piles;
    }
}
