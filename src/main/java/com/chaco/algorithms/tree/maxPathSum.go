package tree

import "math"

func maxPathSum(root *TreeNode) int {
	MaxSum := math.MinInt32
	var maxGain func(*TreeNode) int
	maxGain = func(node *TreeNode) int {
		if nil == node {
			return 0
		}
		leftMax := int(math.Max(float64(maxGain(node.Left)), 0))
		rightMax := int(math.Max(float64(maxGain(node.Right)), 0))
		priceNewpath := leftMax + rightMax + node.Val
		MaxSum = int(math.Max(float64(MaxSum), float64(priceNewpath)))
		return node.Val + int(math.Max(float64(leftMax), float64(rightMax)))
	}
	maxGain(root)
	return MaxSum
}
