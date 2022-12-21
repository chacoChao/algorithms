package algorithms

func reorderList(head *ListNode) {
	if nil == head || nil == head.Next {
		return
	}
	//mid
	mid := getMidNode(head)
	l1 := head
	l2 := mid.Next
	mid.Next = nil
	//revers
	l2 = revers(l2)
	//merge
	merge(l1, l2)
}

func merge(l1 *ListNode, l2 *ListNode) {
	for nil != l1 && nil != l2 {
		l1Tmp := l1.Next
		l2Tmp := l2.Next

		l1.Next = l2
		l1 = l1Tmp

		l2.Next = l1
		l2 = l2Tmp
	}

}

func revers(l2 *ListNode) *ListNode {
	if nil == l2 || nil == l2.Next {
		return l2
	}
	tmp := revers(l2.Next)
	l2.Next.Next = l2
	l2.Next = nil
	return tmp
}

func getMidNode(head *ListNode) *ListNode {
	var (
		slow = head
		fast = head
	)
	for nil != fast.Next && nil != fast.Next.Next {
		slow = slow.Next
		fast = fast.Next.Next
	}
	return slow
}
