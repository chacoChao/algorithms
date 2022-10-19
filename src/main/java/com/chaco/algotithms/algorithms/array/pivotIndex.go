package array

func pivotIndex(nums []int) int {
	total := 0
	sum := 0
	for _, i := range nums {
		total += i
	}

	for i := 0; i < len(nums); i++ {
		if 2*sum+nums[i] == total {
			return i
		}
		sum += nums[i]
	}
	return -1
}
