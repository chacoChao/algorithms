package com.chaco.algorithms.listNode;

import com.chaco.algorithms.ListNode;

/**
 * author:zhaopeiyan001
 * Date:2020-04-27 11:50
 */
public class merge {
    /**
     * 输入两个单调递增的链表，输出两个链表合成后的链表，
     * 当然我们需要合成后的链表满足单调不减规则。
     */
    public ListNode Merge(ListNode list1, ListNode list2) {
        if (null == list1) {
            return list2;
        }
        if (null == list2) {
            return list1;
        }
        ListNode prev = new ListNode(-1);
        ListNode head = prev;
        while (true) {
            if (list1 == null) {
                prev.next = list2;
                return head.next;
            }
            if (list2 == null) {
                prev.next = list1;
                return head.next;
            }
            if (list1.val > list2.val) {
                prev.next = list2;
                prev = list2;
                list2 = list2.next;
            } else {
                prev.next = list1;
                prev = list1;
                list1 = list1.next;
            }
        }
    }

    public ListNode Merge1(ListNode list1, ListNode list2) {
        if (null == list1) {
            return list2;
        }
        if (null == list2) {
            return list1;
        }
        if (list1.val > list2.val) {
            list2.next = this.Merge1(list1, list2.next);
            return list2;
        } else {
            list1.next = this.Merge1(list1.next, list2);
            return list1;
        }
    }
}
