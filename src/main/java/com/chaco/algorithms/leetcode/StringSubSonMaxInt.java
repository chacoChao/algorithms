package com.chaco.chao.algorithms.leetcode;

import java.util.HashSet;

/**
 * 20220602-Soul一面  无重复字串最大长度
 * https://leetcode.cn/problems/longest-substring-without-repeating-characters/
 */
public class StringSubSonMaxInt {
    public static void main(String[] args) {
        String s = "pwwkew";
        int l = StringSubSonMaxInt.lengthSonStr(s);
        System.out.println("Hello World!" + l);
    }

    public static int lengthSonStr(String str) {
        HashSet<Character> show = new HashSet();
        int length = str.length();
        int r = -1, ans = 0;
        for (int i = 0; i < length; i++) {
            if (0 != i) {
                show.remove(str.charAt(i - 1));
            }
            while (r + 1 < length && !show.contains(str.charAt(r + 1))) {
                show.add(str.charAt(r + 1));
                r++;
            }
            ans = Math.max(ans, r - i + 1);
        }
        return ans;
    }
}
