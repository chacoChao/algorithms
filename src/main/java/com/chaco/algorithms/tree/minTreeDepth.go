package tree

import "math"

func minDepth(root *TreeNode) int {
	if nil == root {
		return 0
	}
	if nil == root.Left && nil == root.Right {
		return 1
	}
	if nil == root.Left {
		return minDepth(root.Right) + 1
	}
	if nil == root.Right {
		return minDepth(root.Left) + 1
	}
	return int(math.Min(float64(minDepth(root.Left)), float64(minDepth(root.Right))) + 1)
}
