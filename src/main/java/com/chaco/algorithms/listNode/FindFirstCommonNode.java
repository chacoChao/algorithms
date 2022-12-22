package com.chaco.algorithms.listNode;

/**
 * @author zhaopeiyan
 * @link https://www.nowcoder.com/ta/coding-interviews
 * @subject JZ52 两个链表的第一个公共结点
 * @desc
 * @date 2022/3/9 7:28 PM
 */
public class FindFirstCommonNode {
    public static ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
        ListNode tmp1 = pHead1;
        ListNode tmp2 = pHead2;

        while (tmp1.val != tmp2.val) {
            tmp1 = null == tmp1.next ? pHead2 : tmp1.next;
            tmp2 = null == tmp2.next ? pHead1 : tmp2.next;
        }
        return tmp1;
    }

    static class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    public static void main(String[] args) {
        ListNode listNode = new ListNode(1);
        ListNode listNode1 = new ListNode(2);
        ListNode listNode2 = new ListNode(3);
        ListNode listNode4 = new ListNode(4);
        ListNode listNode5 = new ListNode(5);
        ListNode listNode6 = new ListNode(6);
        ListNode listNode7 = new ListNode(7);

        listNode.next = listNode1;
        listNode1.next = listNode2;
        listNode2.next = listNode6;

        listNode4.next = listNode5;
        listNode5.next = listNode6;

        listNode6.next = listNode7;

        ListNode node = FindFirstCommonNode.FindFirstCommonNode(listNode, listNode4);
        System.out.println(node);
    }


    /**
     * 描述
     * 输入两个无环的单向链表，找出它们的第一个公共结点，如果没有公共节点则返回空。（注意因为传入数据是链表，所以错误测试数据的提示是用其他方式显示的，保证传入数据是正确的）
     *
     * 数据范围： n \le 1000n≤1000
     * 要求：空间复杂度 O(1)O(1)，时间复杂度 O(n)O(n)
     *
     * 例如，输入{1,2,3},{4,5},{6,7}时，两个无环的单向链表的结构如下图所示：
     *
     * 可以看到它们的第一个公共结点的结点值为6，所以返回结点值为6的结点。
     * 输入描述：
     * 输入分为是3段，第一段是第一个链表的非公共部分，第二段是第二个链表的非公共部分，第三段是第一个链表和第二个链表的公共部分。 后台会将这3个参数组装为两个链表，并将这两个链表对应的头节点传入到函数FindFirstCommonNode里面，用户得到的输入只有pHead1和pHead2。
     * 返回值描述：
     * 返回传入的pHead1和pHead2的第一个公共结点，后台会打印以该节点为头节点的链表。
     * 示例1
     * 输入：
     * {1,2,3},{4,5},{6,7}
     * 复制
     * 返回值：
     * {6,7}
     * 复制
     * 说明：
     * 第一个参数{1,2,3}代表是第一个链表非公共部分，第二个参数{4,5}代表是第二个链表非公共部分，最后的{6,7}表示的是2个链表的公共部分
     * 这3个参数最后在后台会组装成为2个两个无环的单链表，且是有公共节点的
     * 示例2
     * 输入：
     * {1},{2,3},{}
     * 复制
     * 返回值：
     * {}
     * 复制
     * 说明：
     * 2个链表没有公共节点 ,返回null，后台打印{}
     */
}
