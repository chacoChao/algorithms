package com.chaco.algorithms.leetcode;

import com.chaco.algorithms.ListNode;

/**
 * author:zhaopeiyan001
 * Date:2020-04-24 17:34
 */
public class reverseList {
    /**
     * 输入一个链表，反转链表后，输出新链表的表头。
     */
    public ListNode ReverseList(ListNode head) {
        if (null == head) {
            return null;
        }
        ListNode newHead = null;
        ListNode pNode = head;
        ListNode pPrev = null;
        while (null != pNode) {
            ListNode pNext = pNode.next;
            if (null == pNext) {
                newHead = pNode;
            }
            pNode.next = pPrev;
            pPrev = pNode;
            pNode = pNext;
        }
        return newHead;
    }

    /**
     * 三指针法
     */
    public ListNode ReverseList1(ListNode head) {
        ListNode p1 = new ListNode(-1);
        p1.next = head;
        if (head == null || head.next == null) {
            return head;
        }
        ListNode p2 = head.next;
        ListNode p3 = head.next.next;
        while (p3 != null) {
            p2.next = p3.next;
            p3.next = p1.next;
            p1.next = p3;
            p3 = p2.next;
        }
        return p1.next;
    }

    /**
     * 三节点法
     */
    public ListNode ReverseList2(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode prev, cur, end;
        prev = null;
        cur = head;
        end = head.next;

        while (cur != null) {
            cur.next = prev;
            prev = cur;
            cur = end;
            if (end != null) {
                end = end.next;
            }
        }
        return prev;
    }

    /**
     * 递归
     */
    public static ListNode ReverseList3(ListNode head) {
        if (null == head || null == head.next) {
            return head;
        }
        /*
         第一轮出栈，head为5，head.next为空，返回5
         第二轮出栈，head为4，head.next为5，执行head.next.next=head也就是5.next=4，
         把当前节点的子节点的子节点指向当前节点
         此时链表为1->2->3->4<->5，由于4与5互相指向，所以此处要断开4.next=null
         此时链表为1->2->3->4<-5
         返回节点5
         第三轮出栈，head为3，head.next为4，执行head.next.next=head也就是4.next=3，
         此时链表为1->2->3<->4<-5，由于3与4互相指向，所以此处要断开3.next=null
         此时链表为1->2->3<-4<-5
         返回节点5
         第四轮出栈，head为2，head.next为3，执行head.next.next=head也就是3.next=2，
         此时链表为1->2<->3<-4<-5，由于2与3互相指向，所以此处要断开2.next=null
         此时链表为1->2<-3<-4<-5
         返回节点5
         第五轮出栈，head为1，head.next为2，执行head.next.next=head也就是2.next=1，
         此时链表为1<->2<-3<-4<-5，由于1与2互相指向，所以此处要断开1.next=null
         此时链表为1<-2<-3<-4<-5
         返回节点5
         出栈完成，最终头节点5->4->3->2->1
         */
        ListNode newHead = ReverseList3(head.next);
        head.next.next = head;
        head.next = null;
        return newHead;
    }

    /**
     * 链表复制方式
     */
    public ListNode ReverseList4(ListNode head) {
        ListNode newHead = null;
        ListNode node;
        while (head != null) {
            //对原链表进行头删
            node = head;
            head = head.next;

            //新链表头插
            node.next = newHead;
            newHead = node;
        }
        return newHead;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(3);
        ListNode l4 = new ListNode(4);
        ListNode l5 = new ListNode(5);
        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        l4.next = l5;
        ListNode cycle = reverseList.ReverseList3(l1);
        System.out.println("========" + cycle.val);
    }
}


