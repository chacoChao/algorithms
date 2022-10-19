package com.chaco.chao.algorithms.dp;

import java.util.Objects;

/**
 * @author zhaopeiyan
 * @date 2021/12/9 5:28 下午
 */
public class Distance {

    /**
     * 给定两个字符串
     * str1=horse
     * str2=ros
     * 计算出变为相等修改的最短路径
     *
     * @param word1
     * @param word2
     * @return
     */
    public static int editDistance(String word1, String word2) {
        int[][] dp = new int[word1.length() + 1][word2.length() + 1];
        // 第一行
        for (int j = 1; j <= word2.length(); j++) {
            dp[0][j] = dp[0][j - 1] + 1;
        }
        // 第一列
        for (int i = 1; i <= word1.length(); i++) {
            dp[i][0] = dp[i - 1][0] + 1;
        }

        for (int i = 1; i <= word1.length(); i++) {
            for (int j = 1; j <= word2.length(); j++) {
                if (Objects.equals(i, -1)) {
                    return i + 1;
                }
                if (Objects.equals(j, -1)) {
                    return j + 1;
                }
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.min(Math.min(dp[i - 1][j], dp[i][j - 1]), dp[i - 1][j - 1]) + 1;
                }
            }
        }
        return dp[word1.length()][word2.length()];
    }

    public static void main(String[] args) {
        int i = Distance.editDistance("horse", "ros");
        int i1 = Distance.editDistance("apple", "rad");
        int i2 = Distance.editDistance("intention", "execution");
        System.out.println(i);
    }
}
