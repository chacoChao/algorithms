package com.chaco.algorithms.array;

import java.util.Arrays;

/**
 * https://leetcode.cn/problems/longest-increasing-subsequence/description/
 * 给你一个整数数组 nums ，找到其中最长严格递增子序列的长度。
 * 子序列 是由数组派生而来的序列，删除（或不删除）数组中的元素而不改变其余元素的顺序。
 * 例如，[3,6,2,7] 是数组 [0,3,1,6,2,2,7] 的子序列。
 */
public class lengthOfLIS {
    public static void main(String[] args) {
        System.out.println("lengthOfLIS.main");
    }

    public int lengthOfLIS(int[] nums) {
        int[] dp = new int[nums.length];
        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j <= i; j++) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[j] + 1, dp[i]);
                }
            }
        }
        return Arrays.stream(dp).max().getAsInt() + 1;
    }
}