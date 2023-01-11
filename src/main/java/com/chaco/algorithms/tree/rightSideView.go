package tree

import list "container/list"

func rightSideView(root *TreeNode) []int {
	var res []int
	if nil == root {
		return res
	}
	l := list.New()
	l.PushFront(root)
	for level := 0; l.Len() > 0; level++ {
		var (
			levelNode = &TreeNode{}
			curLen    = l.Len()
		)
		for i := 0; i < curLen; i++ {
			node := l.Remove(l.Back()).(*TreeNode)
			levelNode = node
			if nil != node.Left {
				l.PushFront(node.Left)
			}
			if nil != node.Right {
				l.PushFront(node.Right)
			}
		}
		res = append(res, levelNode.Val)
	}
	return res
}
