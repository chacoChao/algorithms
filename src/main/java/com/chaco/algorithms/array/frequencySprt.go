package array

import "sort"

func main() {

}

func frequencySort(nums []int) []int {
	m := map[int]int{}
	for _, i := range nums {
		m[i]++
	}
	sort.Slice(nums, func(i, j int) bool {
		a, b := nums[i], nums[j]
		return m[a] < m[b] || m[a] == m[b] && a > b
	})
	return nums
}
