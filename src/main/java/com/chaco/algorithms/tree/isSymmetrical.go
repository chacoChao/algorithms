package tree

func isSymmetrical( pRoot *TreeNode ) bool {
	return check(pRoot,pRoot)
}