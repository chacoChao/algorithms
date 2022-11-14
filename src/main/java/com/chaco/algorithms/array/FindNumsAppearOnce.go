package array

import "sort"

func FindNumsAppearOnce(array []int) []int {
	if len(array) ==2{
		return array
	}
	res := make([]int, 2)
	set := make(map[int]bool)
	for i := 0; i < len(array); i++ {
		if set[array[i]] {
			delete(set, array[i])
			continue
		}
		set[array[i]] = true
	}
	i := 0
	for k := range set {
		res[i] = k
		i++
	}
	sort.Ints(res)
	return res
}
