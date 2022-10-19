package com.chaco.chao.algorithms.leetcode;

/**
 * https://leetcode-cn.com/problems/reverse-integer/
 *
 * @author zhaopeiyan
 * @date 2021/12/14 4:07 PM
 */
public class ReverseInt {
    public static int reverse(int x) {
        int reverse = 0;
        while (x != 0) {
            if (reverse > Integer.MAX_VALUE / 10 || reverse < Integer.MIN_VALUE / 10) {
                return 0;
            }
            reverse = (reverse * 10) + (x % 10);
            x /= 10;
        }
        return reverse;
    }

    public static void main(String[] args) {
        int reverse = ReverseInt.reverse(1534236469);
        System.out.println(reverse);
    }
}
