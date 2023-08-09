package com.chaco.algorithms.tree;

import com.chaco.algorithms.TreeNode;

import java.util.*;

/**
 * <a href="https://www.nowcoder.com/practice/91b69814117f4e8097390d107d2efbe0">...</a>
 * 给定一个二叉树，返回该二叉树的之字形层序遍历
 * （第一层从左向右，下一层从右向左，一直这样交替）
 */
public class PrintZHITree {
    public static void main(String[] args) {
        TreeNode t5 = new TreeNode(5);
        TreeNode t4 = new TreeNode(4);
        TreeNode t3 = new TreeNode(3);
        TreeNode t2 = new TreeNode(2);
        TreeNode t1 = new TreeNode(1);
        t1.right = t3;
        t1.left = t2;

        t2.left = t4;
        t2.right = t5;

        ArrayList<ArrayList<Integer>> print = PrintZHITree.Print(t1);
        System.out.println("PrintZHITree.main" + Arrays.toString(print.toArray()));
    }

    public static ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        if (null == pRoot) {
            return res;
        }
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(pRoot);
        int c = 0;
        while (!q.isEmpty()) {
            c++;
            Deque<Integer> tmp = new ArrayDeque();
            int size = q.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = q.poll();
                if (c % 2 == 0) {
                    tmp.offerLast(node.val);
                } else {
                    tmp.offerFirst(node.val);
                }
                if (null != node.left) {
                    q.offer(node.left);
                }
                if (null != node.right) {
                    q.offer(node.right);
                }
            }
            res.add(new ArrayList<>(tmp));
        }
        return res;
    }
}