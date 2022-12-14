package tree

var (
	res   = -1
	count = 0
)

func KthNode(proot *TreeNode, k int) int {
	if nil == proot || 0 > k {
		return res
	}
	KthNode(proot.Left, k)
	count++
	if count == k {
		res = proot.Val
		return res
	}
	KthNode(proot.Right, k)
	return res
}

func kthLargest(root *TreeNode, k int) int {
	var dfs func(*TreeNode)
	var res int
	dfs = func(node *TreeNode) {
		if node == nil {
			return
		}
		dfs(node.Right)
		if k -= 1; k == 0 {
			res = node.Val
			return
		}
		dfs(node.Left)
	}
	dfs(root)
	return res
}
