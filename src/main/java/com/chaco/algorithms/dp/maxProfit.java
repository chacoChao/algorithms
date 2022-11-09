package com.chaco.algorithms.dp;

/**
 * https://www.nowcoder.com/practice/64b4262d4e6d4f6181cd45446a5821ec
 * https://leetcode.cn/problems/best-time-to-buy-and-sell-stock/description/
 * 假设你有一个数组prices，长度为n，其中prices[i]是股票在第i天的价格，请根据这个价格数组，返回买卖股票能获得的最大收益
 * 1.你可以买入一次股票和卖出一次股票，并非每天都可以买入或卖出一次，总共只能买入和卖出一次，且买入必须在卖出的前面的某一天
 * 2.如果不能获取到任何利润，请返回0
 * 3.假设买入卖出均无手续费
 */
public class maxProfit {
    public static void main(String[] args) {
        int[] pirces = new int[]{8, 9, 2, 5, 4, 7, 1};
        int maxProfit = maxProfit(pirces);
        System.out.println("maxProfit.main" + maxProfit);
    }

    public static int maxProfit(int[] prices) {
        if (null == prices || prices.length == 0) {
            return 0;
        }
        //1 买入 。0卖出
        int[][] dp = new int[prices.length][2];
        dp[0][0] = 0;
        dp[0][1] = -prices[0];
        for (int i = 1; i < prices.length; i++) {
            //昨天卖出
            dp[i][0] = Math.max(dp[i - 1][1] + prices[i], dp[i - 1][0]);
            //昨天买入
            dp[i][1] = Math.max(-prices[i], dp[i - 1][1]);
        }
        return dp[prices.length - 1][0];
    }
}