package com.chaco.chao.algorithms.dp;

import org.springframework.util.StringUtils;

/**
 * [1143.最长公共子序列](https://leetcode-cn.com/problems/longest-common-subsequence)
 * <p>
 * 输入: str1 = "abcde", str2 = "ace"
 * 输出: 3
 * 解释: 最长公共子序列是 "ace"，它的长度是 3
 *
 * @author zhaopeiyan
 * @date 2021/11/29 8:03 下午
 */
public class LongestCommonSubsequence {
    public static int longestCommonSubsequence(String text1, String text2) {
        char[] str1 = text1.toCharArray();
        char[] str2 = text2.toCharArray();
        int i = str1.length, j = str2.length;
        int[][] dp = new int[i + 1][j + 1];
        for (int i1 = 1; i1 <= i; i1++) {
            for (int j1 = 1; j1 <= j; j1++) {
                if (str1[i1 - 1] == str2[j1 - 1]) {
                    dp[i1][j1] = dp[i1 - 1][j1 - 1] + 1;
                } else {
                    dp[i1][j1] = Math.max(dp[i1][j1 - 1], dp[i1 - 1][j1]);
                }
            }
        }
        return dp[i][j];
    }

    public static void main(String[] args) {
        try {
            int i = LongestCommonSubsequence.longestCommonSubsequence("abcde", "ace");
            System.out.println(i);
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
