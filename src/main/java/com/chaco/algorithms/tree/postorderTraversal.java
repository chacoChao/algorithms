package com.chaco.algorithms.tree;

import com.chaco.algorithms.TreeNode;

import java.util.LinkedList;
import java.util.List;

/**
 * https://leetcode.cn/problems/binary-tree-postorder-traversal/description/
 * 给你一棵二叉树的根节点 root ，返回其节点值的 后序遍历 。
 */
public class postorderTraversal {
    public static void main(String[] args) {
        System.out.println("postorderTraversal.main");
    }

    List<Integer> res = new LinkedList<>();

    public List<Integer> postorderTraversal(TreeNode root) {
        if (null == root) {
            return res;
        }
        postorderTraversal(root.left);
        postorderTraversal(root.right);
        res.add(root.val);
        return res;
    }
}