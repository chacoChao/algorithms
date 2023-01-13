package dp

import "math"

func minDistance(word1 string, word2 string) int {
	var dp = make([][]int, len(word1)+1, len(word2)+1)
	for i := 1; i < len(word2); i++ {
		dp[0][i] = i
	}
	for j := 1; j < len(word1); j++ {
		dp[j][0] = j
	}
	for i := 1; i <= len(word1); i++ {
		for j := 1; j <= len(word2); j++ {
			if i == -1 {
				return i + 1
			}
			if j == -1 {
				return j + 1
			}
			if word1[i-1] == word2[j-1] {
				dp[i][j] = dp[i-1][j-1]
			} else {
				dp[i][j] = int(math.Min(float64(dp[i-1][j-1]), math.Min(float64(dp[i][j-1]), float64(dp[i-1][j])))) + 1
			}
		}
	}
	return dp[len(word1)][len(word2)]
}

func Min(args ...int) int {
	min := args[0]
	for _, item := range args {
		if item < min {
			min = item
		}
	}
	return min
}

func Max(args ...int) int {
	max := args[0]
	for _, item := range args {
		if item > max {
			max = item
		}
	}
	return max
}

func minDistance1(word1 string, word2 string) int {
	n1, n2 := len(word1), len(word2)
	dp := make([][]int, n1+1)
	for i := range dp {
		dp[i] = make([]int, n2+1)
	}
	for i := 1; i < len(word2); i++ {
		dp[0][i] = dp[0][i-1] + 1
	}
	for j := 1; j < len(word1); j++ {
		dp[j][0] = dp[j-1][0] + 1
	}
	for i := 1; i <= len(word1); i++ {
		for j := 1; j <= len(word2); j++ {
			if word1[i-1] == word2[j-1] {
				dp[i][j] = dp[i-1][j-1]
			} else {
				dp[i][j] = Min(dp[i-1][j-1], Min(dp[i][j-1], dp[i-1][j])) + 1
			}
		}
	}
	return dp[n1][n2]
}
