package algorithms

func FindKthToTail(pHead *ListNode, k int) *ListNode {
	pre := pHead
	form := pHead
	for i := 0; i < k; i++ {
		if nil == form {
			return nil
		}
		form = form.Next
	}

	for tmp := form; nil != tmp; tmp = tmp.Next {
		pre = pre.Next
	}
	return pre
}
