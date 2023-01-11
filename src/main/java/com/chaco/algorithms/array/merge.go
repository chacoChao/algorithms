package array

import (
	"math"
	"sort"
)

func merge1(intervals [][]int) [][]int {
	if nil == intervals || len(intervals) == 1 {
		return intervals
	}
	sort.Slice(intervals, func(i, j int) bool {
		return intervals[i][0] < intervals[j][0]
	})
	var (
		res = [][]int{}
		c   = -1
	)
	for _, arr := range intervals {
		if c == -1 || arr[0] > res[c][1] {
			c++
			res = append(res, arr)
		} else {
			res[c][1] = int(math.Max(float64(res[c][1]), float64(arr[1])))
		}
	}
	return res
}
