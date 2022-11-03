package tree

import "math"

func TreeDepth(pRoot *TreeNode) int {
	if nil == pRoot {
		return 0
	}
	deep := math.Max(float64(TreeDepth(pRoot.Left)), float64(TreeDepth(pRoot.Right)))
	return int(deep + 1)
}
