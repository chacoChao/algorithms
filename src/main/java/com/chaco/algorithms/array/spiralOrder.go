package array

import "fmt"

func spiralOrder(matrix [][]int) []int {
	if nil == matrix || 0 == len(matrix) || 0 == len(matrix[0]) {
		return []int{}
	}
	var (
		left   = 0
		top    = 0
		right  = len(matrix[0]) - 1
		bottom = len(matrix) - 1
		index  = 0
		res    = make([]int, len(matrix)*len(matrix[0]))
	)
	for left <= right && top <= bottom {
		for i := left; i <= right; i++ {
			res[index] = matrix[top][i]
			index++
		}
		for i := top + 1; i <= bottom; i++ {
			res[index] = matrix[i][right]
			index++
		}
		if left < right && top < bottom {
			for i := right - 1; i >= left; i-- {
				res[index] = matrix[bottom][i]
				index++
			}
			for i := bottom - 1; i > top; i-- {
				res[index] = matrix[i][left]
				index++
			}
		}
		left++
		right--
		top++
		bottom--
	}
	return res
}

func main() {
	var arr = [][]int{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}}
	order := spiralOrder(arr)
	fmt.Println(order)
}
