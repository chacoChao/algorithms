package dp

import "math"

//DP
func trapDp(height []int) int {
	result := 0
	n := len(height)

	leftArr := make([]int, len(height)+1)
	leftArr[0] = height[0]
	for i := 1; i < n; i++ {
		leftArr[i] = int(math.Max(float64(leftArr[i-1]), float64(height[i])))
	}

	rightArr := make([]int, len(height)+1)
	rightArr[n-1] = height[n-1]
	for i := n - 2; i >= 0; i-- {
		rightArr[i] = int(math.Max(float64(rightArr[i+1]), float64(height[i])))
	}

	for i := 0; i < n; i++ {
		result += int(math.Min(float64(leftArr[i]), float64(rightArr[i]))) - height[i]
	}

	return result
}

//双指针
func trap(height []int) int {
	result := 0
	left := 0
	right := len(height) - 1

	leftMax := 0
	rightMax := 0

	for left < right {
		if height[left] < height[right] {
			if height[left] < leftMax {
				result += leftMax - height[left]
			} else {
				leftMax = height[left]
			}
			left++
		} else {
			if height[right] < rightMax {
				result += rightMax - height[right]
			} else {
				rightMax = height[right]
			}
			right--
		}
	}
	return result
}
