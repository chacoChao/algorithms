package array

import "sort"

func getMaximumConsecutive(coins []int) int {
	sort.Ints(coins)
	cur := 0
	for _, i := range coins {
		if i <= cur+1 {
			cur += i
		} else {
			break
		}
	}
	return cur
}
