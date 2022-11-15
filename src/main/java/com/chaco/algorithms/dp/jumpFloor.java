package com.chaco.algorithms.dp;

/**
 * https://www.nowcoder.com/practice/8c82a5b80378478f9484d87d1c5f12a4
 * https://leetcode.cn/problems/climbing-stairs/
 * 一只青蛙一次可以跳上1级台阶，也可以跳上2级。求该青蛙跳上一个 n 级的台阶总共有多少种跳法（先后次序不同算不同的结果）。
 */
public class jumpFloor {
    public static void main(String[] args) {
        System.out.println("jumpFloor.main");
    }

    //滚动数组 。pqr表示f(x)=f(x-1) + f(x-2)  递推可得
    public int jumpFloor(int target) {
        int p = 0, q = 0, r = 1;
        for (int i = 1; i <= target; i++) {
            p = q;
            q = r;
            r = p + q;
        }
        return r;
    }

    //通项公式
    public int jumpFloor1(int target) {
        double sqrt5 = Math.sqrt(5);
        double fibn = Math.pow((1 + sqrt5) / 2, target + 1) - Math.pow((1 - sqrt5) / 2, target + 1);
        return (int) Math.round(fibn / sqrt5);
    }
}