package dp

import "math"

func maxProfit2(prices []int) int {
	dp := make([][2]int, len(prices))
	dp[0][0] = 0
	dp[0][1] = -prices[0]
	for i := 1; i < len(prices); i++ {
		dp[i][0] = int(math.Max(float64(dp[i-1][1]+prices[i]), float64(dp[i-1][0])))
		dp[i][1] = int(math.Max(float64(dp[i-1][0]-prices[i]), float64(dp[i-1][1])))
	}
	return dp[len(prices)-1][0]
}
