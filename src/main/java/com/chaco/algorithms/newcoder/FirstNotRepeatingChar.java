package com.chaco.algorithms.newcoder;

import java.util.HashMap;

/**
 * https://www.nowcoder.com/practice/1c82e8cf713b4bbeb2a5b31cf5b0417c?tpId=13
 * 在一个长为 字符串中找到第一个只出现一次的字符,并返回它的位置, 如果没有则返回 -1（需要区分大小写）.（从0开始计数）
 * 数据范围：0 \le n \le 100000≤n≤10000，且字符串只有字母组成。
 * 要求：空间复杂度 O(n)O(n)，时间复杂度 O(n)O(n)
 * <p>
 * 输入："google"
 * 返回值：4
 * <p>
 * 示例2
 * 输入："aa"
 * 返回值：-1
 */
public class FirstNotRepeatingChar {
    public static void main(String[] args) {
        int firstNotRepeatingChar = FirstNotRepeatingChar.FirstNotRepeatingChar("google");
        System.out.println("FirstNotRepeatingChar.main:" + firstNotRepeatingChar);
    }

    public static int FirstNotRepeatingChar(String str) {
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < str.length(); i++) {
            map.put(str.charAt(i), map.getOrDefault(str.charAt(i), 0) + 1);
        }
        for (int i = 0; i < str.length(); i++) {
            if (map.get(str.charAt(i)) == 1) {
                return i;
            }
        }
        return -1;
    }
}