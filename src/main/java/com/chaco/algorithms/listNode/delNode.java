package com.chaco.algorithms.listNode;

import com.chaco.algorithms.ListNode;

/**
 * @link <a href="https://www.nowcoder.com/practice/f9f78ca89ad643c99701a7142bd59f5d">...</a>
 * 给定单向链表的头指针和一个要删除的节点的值，定义一个函数删除该节点。返回删除后的链表的头节点。
 * <p>
 * 1.此题对比原题有改动
 * 2.题目保证链表中节点的值互不相同
 * 3.该题只会输出返回的链表和结果做对比，所以若使用 C 或 C++ 语言，你不需要 free 或 delete 被删除的节点
 * <p>
 * example:
 * 输入：{2,5,1,9},5
 * 返回值：{2,1,9}
 * <p>
 * 输入：{2,5,1,9},1
 * 返回值：{2,5,9}
 */
public class delNode {

    public static ListNode deleteNode(ListNode head, int val) {
        if (null == head) {
            return head;
        }
        ListNode res = new ListNode();
        res.next = head;
        //前驱节点
        ListNode p = new ListNode();
        p = res;
        //当前节点
        ListNode cur = new ListNode();
        cur = head;
        while (null != p.next) {
            if (p.next.val == val) {
                p.next = cur.next;
                break;
            }
            p = cur;
            cur = cur.next;
        }
        return res.next;
    }


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
        ListNode listNode = delNode.deleteNode(l0, 2);
        System.out.println("delNode.main" + listNode.toString());

        //{2, 0, 3, 1}, 2

        ListNode ll2 = new ListNode(2, null);
        ListNode ll0 = new ListNode(0, null);
        ll2.next = ll0;
        ListNode ll3 = new ListNode(3, null);
        ll0.next = ll3;
        ListNode ll1 = new ListNode(1, null);
        ll3.next = ll1;
        ListNode listNode1 = delNode.deleteNode(ll2, 2);
        System.out.println("delNode.main" + listNode1.toString());
    }
}