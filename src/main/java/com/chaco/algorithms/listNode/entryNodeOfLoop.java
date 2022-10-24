package com.chaco.algorithms.listNode;

import com.chaco.algorithms.ListNode;

/**
 * @link <a href="https://www.nowcoder.com/practice/253d2c59ec3e4bc68da16833f79a38e4">...</a>
 * 给一个长度为n链表，若其中包含环，请找出该链表的环的入口结点，否则，返回null。
 */
public class entryNodeOfLoop {
    public static ListNode EntryNodeOfLoop(ListNode pHead) {
        ListNode fir = pHead, sec = pHead;
        while (null != sec.next && null != sec.next.next) {
            fir = fir.next;
            sec = sec.next.next;
            if (fir == sec) {
                break;
            }
        }
        if (null == sec.next || null == sec.next.next) {
            return null;
        }
        fir = pHead;
        while (fir != sec) {
            fir = fir.next;
            sec = sec.next;
        }
        return fir;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        l1.next = l2;
        ListNode l3 = new ListNode(3);
        l2.next = l3;
        ListNode l4 = new ListNode(4);
        l3.next = l4;
        ListNode l5 = new ListNode(5);
        l4.next = l5;
        l5.next = l3;
        ListNode listNode = entryNodeOfLoop.EntryNodeOfLoop(l1);
        System.out.println("entryNodeOfLoop.main");
    }
}