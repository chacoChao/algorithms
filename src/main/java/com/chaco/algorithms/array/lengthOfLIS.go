package array

import "math"

func lengthOfLIS(nums []int) int {
	dp := make([]int, len(nums))
	for i := 1; i < len(nums); i++ {
		for j := 0; j <= i; j++ {
			if nums[i] > nums[j] {
				dp[i] = int(math.Max(float64(dp[j]+1), float64(dp[i])))
			}
		}
	}
	max := 0
	for _, i := range dp {
		if max < i {
			max = i
		}
	}
	return max
}
