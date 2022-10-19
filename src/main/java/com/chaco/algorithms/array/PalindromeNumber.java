package com.chaco.algorithms.array;

/**
 * 给你一个整数 x ，如果 x 是一个回文整数，返回 true ；否则，返回 false 。
 * <p>
 * 回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。例如，121 是回文，而 123 不是。
 *
 * @author zhaopeiyan
 * @link https://leetcode-cn.com/problems/palindrome-number/
 * @date 2021/12/22 11:06 AM
 */
public class PalindromeNumber {
    public static boolean isPalindrome(int x) {
        boolean is = true;
        char[] chars = Integer.toString(x).toCharArray();
        int length = chars.length;
        for (int i = 0; i < length; i++) {
            if (chars[i] != chars[length - i - 1]) {
                return false;
            }
        }
        return is;
    }

    public static void main(String[] args) {
        boolean palindrome = PalindromeNumber.isPalindrome(1101);
        System.out.println(palindrome);
    }
}
