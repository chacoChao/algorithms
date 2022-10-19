package com.chaco.algorithms.leetcode;

/**
 * @author zhaopeiyan
 * @link https://leetcode-cn.com/problems/add-two-numbers/
 * 给你两个非空 的链表，表示两个非负的整数。它们每位数字都是按照逆序的方式存储的，并且每个节点只能存储一位数字。
 * <p>
 * 请你将两个数相加，并以相同形式返回一个表示和的链表。
 * <p>
 * 你可以假设除了数字 0 之外，这两个数都不会以 0开头。
 * @date 2021/12/17 11:25 AM
 */
public class AddTwoNumbers {
    public static void main(String[] args) {
        ListNode l1 = new ListNode(2);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(3);
        ListNode l2 = new ListNode(5);
        l2.next = new ListNode(6);
        l2.next.next = new ListNode(4);
        ListNode listNode = AddTwoNumbers.addTwoNumbers(l1, l2);
        System.out.println(listNode);
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode l3 = new ListNode();
        ListNode lTmp = l3;
        int a = 0;
        while (null != l1 || null != l2) {
            int tmp =
                    (l1 == null ? 0 : l1.val)
                            + (null == l2 ? 0 : l2.val)
                            + a;
            a = tmp / 10;
            tmp = tmp % 10;
            lTmp.next = new ListNode(tmp);
            lTmp = lTmp.next;
            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }
        }
        if (a == 1) {
            lTmp.next = new ListNode(a);
        }
        return l3.next;
    }

    static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}
