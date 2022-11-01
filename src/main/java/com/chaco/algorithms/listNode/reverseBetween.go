package listNode

func reverseBetween(head *ListNode, left int, right int) *ListNode {
	res := &ListNode{}
	res.Next = head
	pre := res
	for i := 0; i < left-1; i++ {
		pre = pre.Next
	}
	cur := pre.Next
	for i := 0; i < right-left; i++ {
		next := cur.Next
		cur.Next = next.Next
		next.Next = pre.Next
		pre.Next = next
	}
	return res.Next
}
