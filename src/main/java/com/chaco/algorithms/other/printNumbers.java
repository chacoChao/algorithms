package com.chaco.algorithms.other;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * https://www.nowcoder.com/practice/4436c93e568c48f6b28ff436173b997f
 * https://leetcode.cn/problems/da-yin-cong-1dao-zui-da-de-nwei-shu-lcof/
 * 输入数字 n，按顺序打印出从 1 到最大的 n 位十进制数。比如输入3，则打印出 1、2、3 一直到最大的 3 位数 999。
 * 1. 用返回一个整数列表来代替打印
 */
public class printNumbers {
    public static int[] printNumbers(int n) {
        if (n <= 0 || n > 5) {
            return null;
        }
        int top = 0, count = 1;
        while (n > 0) {
            top = (9 * count) + top;
            n--;
            count *= 10;
        }
        int[] res = new int[top];
        for (int i = 1; i <= top; i++) {
            res[i - 1] = i;
        }
        return res;
    }

    public static void main(String[] args) {
        int[] res = printNumbers(3);
        System.out.println("printNumbers.main" + Arrays.toString(res));
    }
}