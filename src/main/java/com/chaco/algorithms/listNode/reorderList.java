package com.chaco.algorithms.listNode;

import com.chaco.algorithms.ListNode;

/**
 * https://leetcode.cn/problems/reorder-list/description/
 * 给定一个单链表 L 的头节点 head ，单链表 L 表示为：
 * 
 * L0 → L1 → … → Ln - 1 → Ln
 * 请将其重新排列后变为：
 * 
 * L0 → Ln → L1 → Ln - 1 → L2 → Ln - 2 → …
 * 不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
 * 
 * 输入：head = [1,2,3,4]
 * 输出：[1,4,2,3]
 * 
 * 输入：head = [1,2,3,4,5]
 * 输出：[1,5,2,4,3]
 */
public class reorderList {
    public static void main(String[] args) {
        ListNode l1 = new ListNode(1, null);
        ListNode l2 = new ListNode(2, null);
        l1.next = l2;
        ListNode l3 = new ListNode(3, null);
        l2.next = l3;
        ListNode l4 = new ListNode(4, null);
        l3.next = l4;

        // reorderList.reorderList(l1);
        System.out.println("reorderList" + l1.toString());
    }

    public void reorderList(ListNode head) {
        if (null == head || null == head.next) {
            return;
        }
        // 中节点拆分链表
        ListNode mid = this.getMidNode(head);
        ListNode l1 = head;
        ListNode l2 = mid.next;
        mid.next = null;
        // 反转第二段链表
        l2 = this.reverseNode(l2);
        // 合并链表
        merge(l1, l2);
    }

    // 递归
    private void merge(ListNode l1, ListNode l2) {
        ListNode l1Tmp, l2Tmp;
        while (null != l1 && null != l2) {
            l1Tmp = l1.next;
            l2Tmp = l2.next;

            l1.next = l2;
            l1 = l1Tmp;

            l2.next = l1;
            l2 = l2Tmp;
        }
    }

    // 递归 最后节点出来，倒数第二层节点互换指向，再断开原始指向
    private ListNode reverseNode(ListNode l2) {
        if (null == l2 || null == l2.next) {
            return l2;
        }
        ListNode tmp = reverseNode(l2.next);
        l2.next.next = l2;
        l2.next = null;
        return tmp;
    }

    // 快慢指针
    private ListNode getMidNode(ListNode head) {
        ListNode slow = head, fast = head;
        while (null != fast.next && null != fast.next.next) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }
}
