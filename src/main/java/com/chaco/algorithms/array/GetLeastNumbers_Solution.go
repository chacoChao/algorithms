package array

import "sort"

func GetLeastNumbers_Solution(input []int, k int) []int {
	var (
		res = make([]int, k)
	)
	if 0 == k {
		return res
	}
	sort.Ints(input)
	for i := 0; i < k; i++ {
		res[i] = input[i]
	}
	return res
}
