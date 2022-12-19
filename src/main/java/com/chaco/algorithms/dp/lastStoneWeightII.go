package dp

func lastStoneWeightII(stones []int) int {
	sum := 0
	for _, v := range stones {
		sum += v
	}
	m := sum / 2
	dp := make([]bool, m+1)
	for _, weight := range stones {
		for i := m; i >= weight; i-- {
			dp[i] = dp[i] || dp[i-weight]
		}
	}
	for j := m; ; j-- {
		if dp[j] {
			return sum - 2*j
		}
	}
}
