package com.chaco.algorithms.dp;

/**
 * https://leetcode.cn/problems/min-cost-climbing-stairs/description/
 * 给你一个整数数组 cost ，其中 cost[i] 是从楼梯第 i 个台阶向上爬需要支付的费用。一旦你支付此费用，即可选择向上爬一个或者两个台阶。
 * <p>
 * 你可以选择从下标为 0 或下标为 1 的台阶开始爬楼梯。
 * <p>
 * 请你计算并返回达到楼梯顶部的最低花费。
 */
public class minCostClimbingStairs {
    public static void main(String[] args) {
        int[] cost = new int[]{10, 15, 20};
        int minCost = minCostClimbingStairs.minCostClimbingStairs(cost);
        System.out.println("minCostClimbingStairs.main:" + minCost);
        int[] cost1 = new int[]{1, 100, 1, 1, 1, 100, 1, 1, 100, 1};
        int minCost1 = minCostClimbingStairs.minCostClimbingStairs(cost1);
        System.out.println("minCostClimbingStairs.main:" + minCost1);
    }

    public static int minCostClimbingStairs(int[] cost) {
        int[] dp = new int[cost.length + 1];
        dp[0] = 0;
        dp[1] = 0;
        for (int i = 2; i <= cost.length; i++) {
            dp[i] = Math.min(dp[i - 1] + cost[i - 1], dp[i - 2] + cost[i - 2]);
        }
        return dp[cost.length];
    }
}