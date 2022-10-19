package com.chaco.chao.algorithms.leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * @author zhaopeiyan
 * @link https://leetcode-cn.com/problems/longest-substring-without-repeating-characters/
 * 给定一个字符串 s ，请你找出其中不含有重复字符的 最长子串 的长度。
 * @date 2021/12/20 3:17 PM
 */
public class LengthOfLongestSubstring {
    public static int lengthOfLongestSubstring(String s) {
        int length = s.length();
        int l = 0;
        if (0 == length) {
            return l;
        }
        for (int i = 0; i < length; i++) {
            int k = 1;
            for (int j = i + 1; j < length; j++) {
                int m = i;
                boolean isreplte = false;
                while (m != j) {
                    if (s.charAt(m) == s.charAt(j)) {
                        isreplte = true;
                        break;
                    }
                    m++;
                }
                if (isreplte) {
                    break;
                }
                k++;
            }
            l = Math.max(k, l);
        }
        return l;
    }

    public static void main(String[] args) {
        int i = LengthOfLongestSubstring.lengthOfLongestSubstring("abcabcbb");
        int i1 = LengthOfLongestSubstring.lengthOfLongestSubstring("bbbbb");
        int i2 = LengthOfLongestSubstring.lengthOfLongestSubstring("pwwkew");
        int i3 = LengthOfLongestSubstring.lengthOfLongestSubstring("");
        System.out.println(i);
    }


    /**
     * 滑动窗口解法
     *
     * @param s
     * @return
     */
    public static int lengthOfLongestSubstring1(String s) {
        Set<Character> characters = new HashSet<>();
        int n = s.length();
        int rk = -1, ans = 0;
        for (int i = 0; i < n; i++) {
            if (i != 0) {
                characters.remove(s.charAt(i - 1));
            }
            while (rk + 1 < n && !characters.contains(s.charAt(rk + 1))) {
                characters.add(s.charAt(rk + 1));
                ++rk;
            }
            ans = Math.max(ans, rk - i + 1);
        }
        return ans;
    }
}
