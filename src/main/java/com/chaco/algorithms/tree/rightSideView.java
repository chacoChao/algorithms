package com.chaco.algorithms.tree;

import com.chaco.algorithms.TreeNode;

import java.util.*;

/**
 * https://leetcode.cn/problems/binary-tree-right-side-view/
 * 给定一个二叉树的 根节点 root，想象自己站在它的右侧，按照从顶部到底部的顺序，返回从右侧所能看到的节点值。
 * 输入: [1,2,3,null,5,null,4]
 * 输出: [1,3,4]
 * 示例 2:
 * <p>
 * 输入: [1,null,3]
 * 输出: [1,3]
 * 示例 3:
 * <p>
 * 输入: []
 * 输出: []
 */
public class rightSideView {
    public static void main(String[] args) {
        TreeNode t5 = new TreeNode(5);
        TreeNode t4 = new TreeNode(4);
        TreeNode t3 = new TreeNode(3);
        TreeNode t2 = new TreeNode(2);
        TreeNode t1 = new TreeNode(1);
        t1.left = t2;
        t2.right = t5;
        t1.right = t3;
        t3.left = t4;
        List<Integer> sideView = rightSideView.rightSideView(t1);
        System.out.println("rightSideView.main:" + Arrays.toString(sideView.toArray()));
    }

    //reverse层序遍历
    public static List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (null == root) {
            return res;
        }
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while (!q.isEmpty()) {
            int l = q.size();
            TreeNode levelNode = null;
            for (int i = 0; i < l; i++) {
                TreeNode n = q.poll();
                levelNode = n;
                if (null != n.left) {
                    q.offer(n.left);
                }
                if (null != n.right) {
                    q.offer(n.right);
                }
            }
            res.add(levelNode.val);
        }
        return res;
    }
}