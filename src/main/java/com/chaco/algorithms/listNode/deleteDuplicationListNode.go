package algorithms

func deleteDuplication(pHead *ListNode) *ListNode {
	if nil == pHead {
		return nil
	}
	res := &ListNode{}
	res.Next = pHead
	for pre := res; nil != pre.Next && nil != pre.Next.Next; {
		if pre.Next.Val == pre.Next.Next.Val {
			tmp := pre.Next.Val
			for ; nil != pre.Next && tmp == pre.Next.Val; pre.Next = pre.Next.Next {
			}
		} else {
			pre = pre.Next
		}
	}
	return res.Next
}
