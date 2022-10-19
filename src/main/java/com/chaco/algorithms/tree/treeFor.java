package com.chaco.algorithms.tree;
//   1
// 2   3
//4 5 6 7

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.*;

/**
 * [[1][23][7654]]
 * 跟节点0层为偶数层
 * 奇数层左到右
 * 偶数层右到左
 */
public class treeFor {
    static List<List<Integer>> res = new ArrayList<>();

    public static void main(String[] args) {
        TreeNode t7 = new TreeNode(7);
        TreeNode t6 = new TreeNode(6);
        TreeNode t5 = new TreeNode(5);
        TreeNode t4 = new TreeNode(4);
        TreeNode t3 = new TreeNode(3);
        TreeNode t2 = new TreeNode(2);
        TreeNode t1 = new TreeNode(1);
        t1.right = t3;
        t1.left = t2;

        t2.left = t4;
        t2.right = t5;

        t3.left = t6;
        t3.right = t7;

        List<List<Integer>> lists = treeFor.treeNodeLevel(t1);
        System.out.println("hello world!" + lists.toString());
    }

    public static List<List<Integer>> treeNodeLevel(TreeNode root) {
        if (null == root) {
            return res;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int level = 0;
        while (!queue.isEmpty()) {
            level++;
            Deque<Integer> levelList = new LinkedList<>();
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (level % 2 == 1) {
                    //奇数 左到右
                    levelList.offerFirst(node.val);
                } else {
                    //偶数
                    levelList.offerLast(node.val);
                }
                if (null != node.right) {
                    queue.offer(node.right);
                }
                if (null != node.left) {
                    queue.offer(node.right);
                }
            }
            res.add(new LinkedList(levelList));
        }
        return res;
    }

    @Data
    @ToString
    @NoArgsConstructor
    @AllArgsConstructor
    static
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }

        @Override
        public String toString() {
            return "val=" + this.val;
        }
    }
}
