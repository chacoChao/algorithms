package listNode

*
type ListNode struct {
    Val  int
    Next *ListNode
}

func sortList(head *ListNode) *ListNode {
    return sortList1(head, nil)
}

func sortList1(head *ListNode, tail *ListNode) *ListNode {
    if nil == head {
        return head
    }
    if head.Next == tail {
        head.Next = nil
        return head
    }
    var (
        fast = head
        slow = head
    )
    for fast != tail {
        fast = fast.Next
        slow = slow.Next
        if fast != tail {
            fast = fast.Next
        }
    }
    return mergeList(sortList1(head, slow), sortList1(slow, tail))
}

func mergeList(list1 *ListNode, list2 *ListNode) *ListNode {
    var (
        res = new(ListNode)
        t1  = list1
        t2  = list2
        tmp = res
    )
    for nil != t1 && nil != t2 {
        if t1.Val > t2.Val {
            tmp.Next = t2
            t2 = t2.Next
        } else {
            tmp.Next = t1
            t1 = t1.Next
        }
        tmp = tmp.Next
    }
    if nil != t1 {
        tmp.Next = t1
    }
    if nil != t2 {
        tmp.Next = t2
    }
    return res.Next
}
