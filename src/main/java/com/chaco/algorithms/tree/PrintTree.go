package tree

import "container/list"

func PrintTree(pRoot *TreeNode) [][]int {
	res := [][]int{}
	if nil == pRoot {
		return res
	}
	l := list.New()
	l.PushFront(pRoot)
	for l.Len() > 0 {
		var tmp []int
		curL := l.Len()
		for i := 0; i < curL; i++ {
			node := l.Remove(l.Back()).(*TreeNode)
			tmp = append(tmp, node.Val)
			if nil != node.Left {
				l.PushFront(node.Left)
			}
			if nil != node.Right {
				l.PushFront(node.Right)
			}
		}
		res = append(res, tmp)
	}
	return res
}
