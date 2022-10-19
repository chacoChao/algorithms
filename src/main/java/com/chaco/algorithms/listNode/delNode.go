package listNode

func deleteNode(head *ListNode, val int) *ListNode {
	res := &ListNode{}
	res.Next = head
	cur := head
	for p := res; nil != p.Next; p = p.Next {
		if val == p.Next.Val {
			p.Next = cur.Next
			break
		}
		p = cur
		cur = cur.Next
	}
	return res.Next
}
