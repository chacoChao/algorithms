package com.chaco.algorithms.tree;

import com.chaco.algorithms.TreeNode;

/**
 * <a href="https://www.nowcoder.com/practice/435fb86331474282a3499955f0a41e8b">...</a>
 * 输入一棵二叉树，求该树的深度。
 * 从根结点到叶结点依次经过的结点（含根、叶结点）形成树的一条路径，最长路径的长度为树的深度，根节点的深度视为 1 。
 * <p>
 * 进阶：空间复杂度 O(1)O(1) ，时间复杂度 O(n)O(n)
 */
public class treeDepth {
    public static void main(String[] args) {
        System.out.println("treeDepth.main");
    }

    public int TreeDepth(TreeNode root) {
        if (null == root) {
            return 0;
        }
        int deep = Math.max(TreeDepth(root.left), TreeDepth(root.right));
        return deep + 1;
    }
}