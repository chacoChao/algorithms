package algorithms

func EntryNodeOfLoop(pHead *ListNode) *ListNode {
	fir := pHead
	sec := pHead
	for nil != sec.Next && nil != sec.Next.Next {
		fir = fir.Next
		sec = sec.Next.Next
		if fir == sec {
			break
		}
	}
	if nil == sec.Next || nil == sec.Next.Next {
		return nil
	}
	fir = pHead
	for fir != sec {
		fir = fir.Next
		sec = sec.Next
	}
	return fir
}
