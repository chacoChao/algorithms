package com.chaco.algorithms.listNode;

import com.chaco.algorithms.ListNode;

/**
 * author:zhaopeiyan001
 * Date:2020-04-24 16:53
 */
public class findKthToTail {
    /**
     * 输入一个链表，输出该链表中倒数第k个结点。
     */
    public ListNode FindKthToTail(ListNode head, int k) {
        int total = 0;
        ListNode l = head;
        while (null != l) {
            total++;
            l = l.next;
        }
        int order = total - k + 1;
        int count = 0;
        while (null != head) {
            count++;
            if (order == count) {
                return head;
            }
            head = head.next;
        }
        return null;
    }

    public ListNode FindKthToTail1(ListNode head, int k) {
        ListNode former = head, latter = head;
        for (int i = 0; i < k; i++) {
            former = former.next;
        }
        while (former != null) {
            latter = latter.next;
            former = former.next;
        }
        return latter;
    }
}
