package tree

func lowestCommonAncestor(root *TreeNode, p int, q int) int {
	if nil == root {
		return -1
	}
	if p <= root.Val && q >= root.Val || p >= root.Val && q <= root.Val {
		return root.Val
	} else if q <= root.Val && q <= root.Val {
		return lowestCommonAncestor(root.Left, p, q)
	} else {
		return lowestCommonAncestor(root.Right, p, q)
	}
}
