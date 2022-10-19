package com.chaco.algorithms.listNode;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author zhaopeiyan
 * @date 2022/1/6 6:00 PM
 */
public class ListNode_aazhaolei {

    public static ListNode replace(ListNode root, int index1, int index2) {
        ListNode hair = new ListNode(0);
        hair.next = root;
        ListNode pre1 = hair;
        ListNode pre2 = hair;
        ListNode cur = hair;
        // 节点计数
        int cnt = 0;

        while (cur.next != null) {
            cur = cur.next;
            cnt++;

            if (cnt < index1) {
                pre1 = pre1.next;
            }

            if (cnt < index2) {
                pre2 = pre2.next;
            }
        }

        // 节点index不存在
        if (cnt < index2) {
            System.out.println("节点不存在");
            return null;
        }

        ListNode temp1 = pre1.next;
        ListNode temp2 = pre2.next;

        ListNode post1 = temp1.next;
        ListNode post2 = temp2.next;

        pre1.next = temp2;
        temp2.next = post1;
        pre2.next = temp1;
        temp1.next = post2;

        return hair.next;
    }

    public static void main(String[] args) {
        ListNode root = ListNodeUtile.create(new int[]{1, 2, 3, 4, 5});
        System.out.println(replace(root, 2, 4));

        ListNode root1 = ListNodeUtile.create(new int[]{1, 2, 3});
        System.out.println(replace(root, 2, 4));

        ListNode root2 = ListNodeUtile.create(new int[]{1, 2, 3, 4});
        System.out.println(replace(root, 1, 4));
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


    static class ListNodeUtile {
        /**
         * 根据数组创建listnode
         *
         * @param arr
         * @return 2021年12月14日
         */
        public static ListNode create(int[] arr) {
            ListNode hair = new ListNode(-1);
            ListNode pos = hair;
            for (int n : arr) {
                pos.next = new ListNode(n);
                pos = pos.next;
            }
            return hair.next;
        }
    }
}
