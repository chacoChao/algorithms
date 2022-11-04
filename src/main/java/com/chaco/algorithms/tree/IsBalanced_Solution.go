package tree

import "math"

func IsBalanced_Solution(pRoot *TreeNode) bool {
	return deep(pRoot) != -1
}

func deep(root *TreeNode) int {
	if nil == root {
		return 0
	}
	left := deep(root.Left)
	if -1 == left {
		return -1
	}
	right := deep(root.Right)
	if -1 == right {
		return -1
	}
	if math.Abs(float64(right-left)) < 2 {
		return int(math.Max(float64(right), float64(left)) + 1)
	} else {
		return -1
	}
}
