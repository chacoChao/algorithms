package tree

import "math"

func VerifySquenceOfBST(sequence []int) bool {
	if nil == sequence {
		return false
	}
	stack := make([]int, len(sequence)+1)
	max := math.MaxInt
	for i := len(sequence) - 1; i >= 0; i-- {
		if max < sequence[i] {
			return false
		}
		for 0 != len(stack) && stack[len(stack)-1] > sequence[i] {
			max = stack[len(stack)-1]
			stack = stack[:len(stack)-1]
		}
		stack = append(stack, sequence[i])
	}
	return true
}
