package tree

func mirrorTree(root *TreeNode) *TreeNode {
	if nil == root {
		return root
	}
	res := &TreeNode{Val: root.Val}
	if nil != root.Left {
		res.Right = mirrorTree(root.Left)
	}
	if nil != root.Right {
		res.Left = mirrorTree(root.Right)
	}
	return res
}
