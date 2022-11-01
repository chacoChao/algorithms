package com.chaco.algorithms.listNode;

import com.chaco.algorithms.ListNode;

/**
 * <a href="https://leetcode.cn/problems/reverse-linked-list-ii/">...</a>
 * 给你单链表的头指针 head 和两个整数 left 和 right ，其中 left <= right 。
 * 请你反转从位置 left 到位置 right 的链表节点，返回 反转后的链表 。
 * <p>
 * 输入：head = [1,2,3,4,5], left = 2, right = 4
 * 输出：[1,4,3,2,5]
 * <p>
 * 输入：head = [5], left = 1, right = 1
 * 输出：[5]
 */
public class reverseBetween {
    public static void main(String[] args) {
        ListNode l0 = new ListNode(1, null);
        ListNode l1 = new ListNode(2, null);
        l0.next = l1;
        ListNode l2 = new ListNode(3, null);
        l1.next = l2;
        ListNode l3 = new ListNode(4, null);
        l2.next = l3;
        ListNode l4 = new ListNode(5, null);
        l3.next = l4;
        ListNode listNode = reverseBetween.reverseBetween(l0, 2, 4);
        System.out.println("delNode.main" + listNode.toString());
        System.out.println("reverseBetween.main");
    }

    public static ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode res = new ListNode();
        res.next = head;
        ListNode pre = res;
        for (int i = 0; i < left - 1; i++) {
            pre = pre.next;
        }
        ListNode cur = pre.next;
        ListNode next;
        for (int i = 0; i < right - left; i++) {
            next = cur.next;
            cur.next = next.next;
            next.next = pre.next;
            pre.next = next;
        }
        return res.next;
    }

    public static ListNode reverse(ListNode node, int count, int left, int right) {
        if (null == node || null == node.next) {
            return node;
        }
        count++;
        if (count > left && count < right) {
            //reverse
            node.next.next = node;
            node.next = null;
        }
        return reverse(node.next, count, left, right);
    }
}