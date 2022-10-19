package com.chaco.chao.algorithms.listNode;

import com.chaco.chao.algorithms.ListNode;

/**
 * @link https://www.nowcoder.com/practice/886370fe658f41b498d40fb34ae76ff9
 * 输入一个长度为 n 的链表，设链表中的元素的值为 ai ，返回该链表中倒数第k个节点。
 * 如果该链表长度小于k，请返回一个长度为 0 的链表。
 */
public class findBackwardKthNode {

    public static void main(String[] args) {
        //{0,2,3,4,5},5
        ListNode l0 = new ListNode(0, null);
        ListNode l1 = new ListNode(2, null);
        l0.next = l1;
        ListNode l2 = new ListNode(3, null);
        l1.next = l2;
        ListNode l3 = new ListNode(4, null);
        l2.next = l3;
        ListNode l4 = new ListNode(5, null);
        l3.next = l4;
        ListNode node = findBackwardKthNode.FindKthToTail(l0, 5);
        System.out.println("findBackwardKthNode" + node.toString());
    }

    public static ListNode FindKthToTail(ListNode pHead, int k) {
        if (0 == k || null == pHead) {
            return null;
        }
        if (1 == k) {
            return pHead;
        }
        ListNode pre = pHead, head = pHead;
        int length = 1;
        while (null != head.next) {
            head = head.next;
            ++length;
        }
        if (length < k) {
            return null;
        }
        if (length == k) {
            return pHead;
        }
        for (int i = 0; i < length - k; i++) {
            pre = pre.next;
        }
        return pre;
    }
}