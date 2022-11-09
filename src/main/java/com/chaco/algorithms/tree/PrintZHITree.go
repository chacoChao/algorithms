package tree

import "container/list"

func Print(pRoot *TreeNode) [][]int {
	res := [][]int{}
	if nil == pRoot {
		return res
	}
	list := list.New()
	//从头部插入root
	list.PushFront(pRoot)
	for level := 0; list.Len() > 0; level++ {
		var currentLevel []int
		curentLenth := list.Len()
		for i := 0; i < curentLenth; i++ {
			node := list.Remove(list.Back()).(*TreeNode)
			currentLevel = append(currentLevel, node.Val)

			if level%2 == 1 {
				if node.Left != nil {
					list.PushFront(node.Left)
				}
				if nil != node.Right {
					list.PushFront(node.Right)
				}
			} else {
				if nil != node.Right {
					list.PushFront(node.Right)
				}
				if node.Left != nil {
					list.PushFront(node.Left)
				}
			}
		}
		res = append(res, currentLevel)
	}
	return res
}

func Print1(pRoot *TreeNode) [][]int {
	var res [][]int
	if nil == pRoot {
		return res
	}
	queue := []*TreeNode{pRoot}

	for len(queue) > 0 {
		length := len(queue)
		tmp := make([]int, length)
		for i := 0; i < length; i++ {
			if nil == queue[i] {
				continue
			}
			if len(res)%2 == 0 {
				tmp[i] = queue[i].Val
			} else {
				tmp[length-i-1] = queue[i].Val
			}
			if nil != queue[i].Right {
				queue = append(queue, queue[i].Right)
			}
			if nil != queue[i].Left {
				queue = append(queue, queue[i].Left)
			}
		}
		queue = queue[length:]
		res = append(res, tmp)
	}
	return res
}
