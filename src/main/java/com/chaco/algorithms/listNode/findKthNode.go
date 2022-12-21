package algorithms

func getKthFromEnd(head *ListNode, k int) *ListNode {
	total := 0
	for node := head; node != nil; node = node.Next {
		total++
	}
	order := total - k + 1
	count := 0
	for node := head; node != nil; node = node.Next {
		count++
		if count == order {
			return head
		}
		head = head.Next
	}
	return nil
}

func getKthFromEnd1(head *ListNode, k int) *ListNode {
	former := head
	latter := head
	for i := 0; i < k; i++ {
		former = former.Next
	}
	for tmp := former; tmp != nil; tmp = tmp.Next {
		latter = latter.Next
	}
	return latter
}
