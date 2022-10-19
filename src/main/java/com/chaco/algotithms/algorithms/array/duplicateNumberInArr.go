package array

import "sort"

func duplicate(numbers []int) int {
	tmp := -1
	sort.Ints(numbers)
	for _, i := range numbers {
		if tmp == i {
			return tmp
		}
		tmp = i
	}
	return -1
}
