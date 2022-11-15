package dp

import "math"

func minCostClimbingStairs(cost []int) int {
	dp := make([]int, len(cost)+1)
	dp[0] = 0
	dp[1] = 0
	for i := 2; i <= len(cost); i++ {
		dp[i] = int(math.Min(float64(dp[i-1]+cost[i-1]), float64(dp[i-2]+cost[i-2])))
	}
	return dp[len(cost)]
}
