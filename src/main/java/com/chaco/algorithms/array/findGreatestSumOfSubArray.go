package array

import "math"

func FindGreatestSumOfSubArray(array []int) int {
	max := array[0]
	sum := 0
	for i := 0; i < len(array); i++ {
		sum = int(math.Max(float64(array[i]), float64(sum+array[i])))
		max = int(math.Max(float64(sum), float64(max)))
	}
	return max
}
