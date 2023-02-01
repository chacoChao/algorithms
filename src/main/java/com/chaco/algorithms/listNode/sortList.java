package com.chaco.algorithms.listNode;

import com.chaco.algorithms.ListNode;

/**
 * https://leetcode.cn/problems/sort-list/
 * 给你链表的头结点 head ，请将其按 升序 排列并返回 排序后的链表 。
 */
public class sortList {
    public static void main(String[] args) {
        System.out.println("sortList.main");
    }

    public ListNode sortList(ListNode head) {
        return sortList(head, null);
    }

    public ListNode sortList(ListNode head, ListNode tail) {
        if (null == head) {
            return head;
        }
        if (head.next == tail) {
            head.next = null;
            return head;
        }
        ListNode slow = head, fast = head;
        while (fast != tail) {
            fast = fast.next;
            slow = slow.next;
            if (fast != tail) {
                fast = fast.next;
            }
        }
        return mergeList(sortList(head, slow), sortList(slow, tail));
    }

    private ListNode mergeList(ListNode list1, ListNode list2) {
        ListNode res = new ListNode(0);
        ListNode tmp1 = list1, tmp2 = list2, tmp = res;
        while (null != tmp1 && null != tmp2) {
            if (tmp1.val > tmp2.val) {
                tmp.next = tmp2;
                tmp2 = tmp2.next;
            } else {
                tmp.next = tmp1;
                tmp1 = tmp1.next;
            }
            tmp = tmp.next;
        }
        if (null != tmp1) {
            tmp.next = tmp1;
        }
        if (null != tmp2) {
            tmp.next = tmp2;
        }
        return res.next;
    }
}