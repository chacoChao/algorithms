package com.chaco.algorithms.listNode;

import com.chaco.algorithms.ListNode;

import java.util.HashSet;
import java.util.Set;

/**
 * 在一个排序的链表中，存在重复的结点，请删除该链表中重复的结点，重复的结点不保留，返回链表头指针。
 * 例如，链表 1->2->3->3->4->4->5  处理后为 1->2->5
 * 进阶：空间复杂度 O(n)\O(n)  ，时间复杂度 O(n) \O(n)
 * 例如输入{1,2,3,3,4,4,5}时，对应的输出为{1,2,5}
 */
public class deleteDuplicationListNode {
    public static ListNode deleteDuplication(ListNode pHead) {
        if (null == pHead) {
            return null;
        }
        ListNode cyc = pHead;
        //获取重复val
        Set<Integer> elment = new HashSet<>();
        Set<Integer> dup = new HashSet<>();
        while (null != cyc) {
            if (!elment.contains(cyc.val)) {
                elment.add(cyc.val);
            } else {
                dup.add(cyc.val);
            }
            cyc = cyc.next;
        }
        //结果集
        ListNode res = new ListNode(-1);
        res.next = pHead;
        //前驱节点
        ListNode pre = new ListNode(-1);
        pre = res;
        //当前节点
        ListNode cur = pHead;
        //del dump val
        while (null != pre.next) {
            if (dup.contains(pre.next.val)) {
                pre.next = cur.next;
            } else {
                pre = pre.next;
            }
            cur = cur.next;
        }
        return res.next;
    }

    public static void main(String[] args) {
        //1,2,3,3,4,4,5
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        l1.next = l2;
        ListNode l3 = new ListNode(3);
        l2.next = l3;
        ListNode l33 = new ListNode(3);
        l3.next = l33;
        ListNode l4 = new ListNode(4);
        l33.next = l4;
        ListNode l44 = new ListNode(4);
        l4.next = l44;
        l44.next = new ListNode(5);
        ListNode res = deleteDuplication1(l1);
        System.out.println("deleteDuplicationListNode.main" + res);

        //{1,1}
        ListNode ll1 = new ListNode(1);
        ll1.next = new ListNode(1);
        ListNode res1 = deleteDuplication1(ll1);
        System.out.println("deleteDuplicationListNode.main" + res1);
    }

    public static ListNode deleteDuplication1(ListNode pHead) {
        if (null == pHead) {
            return null;
        }
        //结果集
        ListNode res = new ListNode(-1);
        res.next = pHead;
        //前驱节点
        ListNode pre = res;
        //del dump val
        while (null != pre.next && null != pre.next.next) {
            if (pre.next.val == pre.next.next.val) {
                int tmp = pre.next.val;
                while (null != pre.next && tmp == pre.next.val) {
                    pre.next = pre.next.next;
                }
            } else {
                pre = pre.next;
            }
        }
        return res.next;
    }
}