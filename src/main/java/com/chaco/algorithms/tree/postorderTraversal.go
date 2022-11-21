package tree

func postorderTraversal(root *TreeNode) (res []int) {
	var postorder func(*TreeNode)
	postorder = func(root *TreeNode) {
		if nil == root {
			return
		}
		postorder(root.Left)
		postorder(root.Right)
		res = append(res, root.Val)
	}
	postorder(root)
	return res
}
