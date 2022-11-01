package array

func FindGreatestSumOfSubArray2(array []int) []int {
	var (
		dp     = make([]int, len(array))
		max    = 0
		left   = 0
		right  = 0
		indexL = 0
		indexR = 0
	)
	dp[0] = array[0]
	max = dp[0]
	for i := 1; i < len(array); i++ {
		right++
		if dp[i-1]+array[i] < array[i] {
			dp[i] = array[i]
			left = right
		} else {
			dp[i] = dp[i-1] + array[i]
		}
		if dp[i] > max || dp[i] == max && (right-left+1) > (indexR-indexL+1) {
			max = dp[i]
			indexR = right
			indexL = left
		}
	}
	return array[indexL : indexR+1]
}
