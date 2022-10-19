package com.chaco.algorithms.str;

/**
 * 给你一个字符串 s，找到 s 中最长的回文子串。
 *
 * @author zhaopeiyan
 * @link https://leetcode-cn.com/problems/longest-palindromic-substring/
 * @date 2021/12/22 2:51 PM
 */
public class LongestPalindromicSubstring {
    public static String longestPalindrome(String s) {
        int length = s.length();
        boolean[][] dp = new boolean[length][length];
        int maxLength = 1;
        int maxI = 0;

        for (int i = 0; i < length; i++) {
            for (int j = 0; j + i < length; j++) {
                if (i == 0) {
                    dp[j][i + j] = true;
                } else if (i == 1) {
                    if (s.charAt(j) == s.charAt(j + 1)) {
                        dp[j][i + j] = true;
                        if (i + 1 > maxLength) {
                            maxLength = i + 1;
                            maxI = j;
                        }
                    } else {
                        dp[j][i + j] = false;
                    }
                } else {
                    if (dp[j + 1][i + j - 1] && s.charAt(j) == s.charAt(i + j)) {
                        dp[j][i + j] = true;
                        if (i + 1 > maxLength) {
                            maxLength = i + 1;
                            maxI = j;
                        }
                    }
                }
            }
        }
        return s.substring(maxI, maxI + maxLength);
    }

    public static void main(String[] args) {
        String babad = LongestPalindromicSubstring.longestPalindrome("babad");
        String babad1 = LongestPalindromicSubstring.longestPalindrome("cbbd");
        System.out.println(babad);
    }
}
