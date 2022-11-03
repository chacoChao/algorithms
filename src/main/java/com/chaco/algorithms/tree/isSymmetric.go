package tree

type TreeNode struct {
	Val   int
	Left  *TreeNode
	Right *TreeNode
}

func isSymmetric(root *TreeNode) bool {
	return check(root, root)
}

func check(left *TreeNode, right *TreeNode) bool {
	if nil == left && nil == right {
		return true
	}
	if nil == left || nil == right {
		return false
	}
	return left.Val == right.Val && check(left.Left, right.Right) && check(left.Right, right.Left)
}
