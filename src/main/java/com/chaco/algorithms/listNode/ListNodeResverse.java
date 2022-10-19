package com.chaco.algorithms.listNode;

import com.chaco.algorithms.ListNode;

/**
 * 20220519 蓝湖二面   反转特定位置的链表
 * 输入：head = [1,2,3,4,5], left = 2, right = 4
 * 输出：[1,4,3,2,5]
 * <p>
 * <p>
 * <p>
 * struct ListNode {
 * int val;
 * ListNode *next;
 * };
 * <p>
 * <p>
 * ListNode* reverseBetween(ListNode* head, int left, int right) {
 * <p>
 * }
 */
public class ListNodeResverse {
    public static void main(String[] args) {

    }

    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode dump = head, p1 = dump;
        ListNode aimListNode = new ListNode(-1);
        ListNode leftNode = new ListNode(-2);
        ListNode rightNode = new ListNode(-3);
        int position = 1;
        while (null != p1) {
            if (position >= left && position <= right) {
                aimListNode.next = p1;
                aimListNode = aimListNode.next;
            } else if (position > right) {
                rightNode.next = p1;
                rightNode = rightNode.next;
            } else if (position < left) {
                leftNode.next = p1;
                leftNode = leftNode.next;
            }
            position++;
            p1 = p1.next;
        }
        ListNode reverse = reverse(aimListNode.next);
        return combain(leftNode, reverse, rightNode);
    }

    private ListNode combain(ListNode leftNode, ListNode reverse, ListNode right) {
        ListNode dump = new ListNode(0);
        ListNode p1 = leftNode;
        while (p1 != null) {
            p1 = p1.next;
            if (p1.next == null) {
                p1.next = reverse;
            }
        }
        dump.next = p1;

        ListNode p2 = reverse;
        while (p2 != null) {
            p2 = p2.next;
            if (p2.next == null) {
                p2.next = right;
            }
        }
        p1.next = p2;
        return dump.next;
    }

    // 1,2,3,4
    public ListNode reverse(ListNode head) {
        if (null == head || null == head.next) {
            return head;
        }
        ListNode last = reverse(head.next);
        head.next.next = head.next;
        head.next = null;
        return last;
    }
}


