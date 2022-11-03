package com.chaco.algorithms.tree;

import com.chaco.algorithms.TreeNode;

/**
 * <a href="https://leetcode.cn/problems/minimum-depth-of-binary-tree/">...</a>
 * 给定一个二叉树，找出其最小深度。
 * <p>
 * 最小深度是从根节点到最近叶子节点的最短路径上的节点数量。
 */
public class minTreeDepth {
    public static void main(String[] args) {
        System.out.println("minTreeDepth.main");
    }

    public int minDepth(TreeNode root) {
        if (null == root) {
            return 0;
        }
        if (null == root.left && null == root.right) {
            return 1;
        }
        if (null == root.left) {
            return minDepth(root.right) + 1;
        }
        if (null == root.right) {
            return minDepth(root.left) + 1;
        }
        return Math.min(minDepth(root.right), minDepth(root.left)) + 1;
    }
}