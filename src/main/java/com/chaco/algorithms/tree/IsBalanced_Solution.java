package com.chaco.algorithms.tree;

import com.chaco.algorithms.TreeNode;

import java.util.Objects;

/**
 * https://www.nowcoder.com/practice/8b3b95850edb4115918ecebdf1b4d222
 * https://leetcode.cn/problems/balanced-binary-tree/
 * https://leetcode.cn/problems/ping-heng-er-cha-shu-lcof/
 * 输入一棵节点数为 n 二叉树，判断该二叉树是否是平衡二叉树。
 * 在这里，我们只需要考虑其平衡性，不需要考虑其是不是排序二叉树
 * 平衡二叉树（Balanced Binary Tree），
 * 具有以下性质：
 * 它是一棵空树或它的左右两个子树的高度差的绝对值不超过1，并且左右两个子树都是一棵平衡二叉树。
 */
public class IsBalanced_Solution {
    public static void main(String[] args) {
        System.out.println("IsBalanced_Solution.main");
    }

    public boolean IsBalanced_Solution(TreeNode root) {
        return deep(root) != -1;
    }

    private int deep(TreeNode root) {
        if (null == root) {
            return 0;
        }
        int left = deep(root.left);
        if (Objects.equals(-1, left)) {
            return -1;
        }
        int right = deep(root.right);
        if (Objects.equals(-1, right)) {
            return -1;
        }
        return Math.abs(left - right) < 2 ? Math.max(left, right) + 1 : -1;
    }
}