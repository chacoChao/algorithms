package com.chaco.algorithms.dp;

/**
 * @author zhaopeiyan
 * @link https://leetcode-cn.com/problems/stone-game/
 * Alice 和 Bob 用几堆石子在做游戏。一共有偶数堆石子，排成一行；每堆都有 正 整数颗石子，数目为 piles[i] 。
 * 游戏以谁手中的石子最多来决出胜负。石子的 总数 是 奇数 ，所以没有平局。
 * Alice 和 Bob 轮流进行，Alice 先开始 。 每回合，玩家从行的 开始 或 结束 处取走整堆石头。
 * 这种情况一直持续到没有更多的石子堆为止，此时手中 石子最多 的玩家 获胜 。
 * 假设 Alice 和 Bob 都发挥出最佳水平，当 Alice 赢得比赛时返回true，当 Bob 赢得比赛时返回false。
 * 示例1：
 * 输入：piles = [5,3,4,5]
 * 输出：true
 * 解释：
 * Alice 先开始，只能拿前 5 颗或后 5 颗石子 。
 * 假设他取了前 5 颗，这一行就变成了 [3,4,5] 。
 * 如果 Bob 拿走前 3 颗，那么剩下的是 [4,5]，Alice 拿走后 5 颗赢得 10 分。
 * 如果 Bob 拿走后 5 颗，那么剩下的是 [3,4]，Alice 拿走后 4 颗赢得 9 分。
 * 这表明，取前 5 颗石子对 Alice 来说是一个胜利的举动，所以返回 true 。
 * <p>
 * 示例2：
 * 输入：piles = [3,7,2,3]
 * 输出：true
 * @date 2021/12/15 3:08 PM
 */
public class StoneGame {

    /**
     * https://leetcode-cn.com/problems/stone-game/solution/gong-shui-san-xie-jing-dian-qu-jian-dp-j-wn31/
     *
     * @param piles
     * @return
     */
    public static boolean staoneGame1(int[] piles) {
        int n = piles.length;
        int[][] dp = new int[n + 2][n + 2];
        //枚举区间长度
        for (int len = 1; len <= n; len++) {
            //枚举左端点
            for (int l = 1; l + len - 1 <= n; l++) {
                //计算右端点
                int r = l + len - 1;
                int a = piles[l - 1] - dp[l + 1][r];
                int b = piles[r - 1] - dp[l][r - 1];
                dp[l][r] = Math.max(a, b);
            }
        }
        return dp[1][n] > 0;
    }

    public static void main(String[] args) {
        int[] arr = {5, 3, 4, 5};
//        int i = StoneGame.staoneGame(arr);
        boolean b = StoneGame.staoneGame1(arr);
        System.out.println(b);
    }

    public static int staoneGame(int[] piles) {
        int n = piles.length;
        Pair[][] dp = new Pair[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                dp[i][j] = new Pair(0, 0);
            }
        }
        //base case
        for (int i = 0; i < n; i++) {
            dp[i][i].fir = piles[i];
            dp[i][i].sec = 0;
        }

        //斜着遍历数组
        for (int l = 2; l <= n; l++) {
            for (int i = 0; i <= n - 1; i++) {
                int j = l + i - 1;
                int left = piles[i] + dp[i + 1][j].sec;
                int right = piles[j] + dp[i][j - 1].sec;
                if (left > right) {
                    dp[i][j].fir = left;
                    dp[i][j].sec = dp[i + 1][j].fir;
                } else {
                    dp[i][j].fir = right;
                    dp[i][j].sec = dp[i][j - 1].fir;
                }
            }
        }
        Pair res = dp[0][n - 1];
        return res.fir - res.sec;
    }

    static class Pair {
        int fir, sec;

        public Pair(int fir, int sec) {
            this.fir = fir;
            this.sec = sec;
        }
    }
}
