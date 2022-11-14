package com.chaco.algorithms.sort;

/**
 * https://www.nowcoder.com/practice/7a0da8fc483247ff8800059e12d7caf1
 * 求1+2+3+...+n，要求不能使用乘除法、for、while、if、else、switch、case等关键字及条件判断语句（A?B:C）。
 */
public class Sum_Solution {
    public static void main(String[] args) {
        System.out.println("Sum_Solution.main");
    }

    public static int Sum_Solution(int n) {
        if (n == 0) {
            return n;
        }
        int c = 0;
        c += n;
        return c + Sum_Solution(n - 1);
    }
}