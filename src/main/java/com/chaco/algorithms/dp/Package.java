package com.chaco.algorithms.dp;

/**
 * 今天就来说一下背包问题吧，就讨论最常说的 0-1 背包问题。描述：
 * <p>
 * 给你一个可装载重量为 W 的背包和 N 个物品，每个物品有重量和价值两个属性。
 * 其中第 i 个物品的重量为 wt[i]，价值为 val[i]，现在让你用这个背包装物品，最多能装的价值是多少？
 * <p>
 * 举个简单的例子，输入如下：
 * <p>
 * N = 3, W = 4
 * wt = [2, 1, 3]
 * val = [4, 2, 3]
 * <p>
 * for 状态1 in 状态1的所有取值：
 * for 状态2 in 状态2的所有取值：
 * for ...
 * dp[状态1][状态2][...] = 择优(选择1，选择2...)
 *
 * @author zhaopeiyan
 * @date 2021/12/1 3:28 下午
 */
public class Package {
    /**
     * @param n   N个物品
     * @param w   背包总承重W
     * @param wt  第i个物品的重量wt[i]
     * @param val 第i个物品的价值val[i]
     * @return
     */
    public static int PackageValue(int n, int w, int[] wt, int[] val) {
        //表示第n个物品在背包容量为w时，总价值
        int[][] dp = new int[n + 1][w + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= w; j++) {
                if (j - wt[i - 1] < 0) {
                    //单物品超重，不装入背包
                    dp[i][j] = dp[i - 1][j];
                } else {
                    //装或不装，择优
                    dp[i][j] = Math.max(
                            dp[i - 1][j],
                            dp[i - 1][j - wt[i - 1]] + val[i - 1]);
                }
            }
        }
        return dp[n][w];
    }

    public static void main(String[] args) {
        int[] wt = new int[]{2, 1, 3};
        int[] val = new int[]{4, 2, 3};
        int i = Package.PackageValue(3, 4, wt, val);
        System.out.println(i);
    }
}
