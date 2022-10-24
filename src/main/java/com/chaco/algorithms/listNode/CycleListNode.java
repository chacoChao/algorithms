package com.chaco.algorithms.listNode;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

public class CycleListNode {
    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(3);
        ListNode l4 = new ListNode(4);
        ListNode l5 = new ListNode(5);
        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        l4.next = l2;
        ListNode cycle = CycleListNode.cycle(l1);
        System.out.println("========" + cycle.val);
    }

    public static ListNode cycle(ListNode head) {
        ListNode p1 = head, p2 = head;
        while (null != p2.next && null != p2.next.next) {
            p1 = p1.next;
            p2 = p2.next.next;
            if (p1 == p2) {
                break;
            }
        }
        if (null == p2 || null == p2.next) {
            return null;
        }
        p1 = head;
        while (p1 != p2) {
            p1 = p1.next;
            p2 = p2.next;
        }
        return p1;
    }


    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class ListNode {
        int val;
        ListNode next;

        public ListNode(int val) {
            this.val = val;
        }
    }

}
