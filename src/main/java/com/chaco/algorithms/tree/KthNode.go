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
