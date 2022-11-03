package com.chaco.algorithms.tree;

import com.chaco.algorithms.TreeNode;

/**
 * <a href="https://leetcode.cn/problems/er-cha-shu-de-jing-xiang-lcof/">leetcode</a>
 * <a href="https://www.nowcoder.com/practice/a9d0ecbacef9410ca97463e4a5c83be7">nowcoder</a>
 * 请完成一个函数，输入一个二叉树，该函数输出它的镜像。
 */
public class mirrorTree {
    public static void main(String[] args) {
        System.out.println("mirrorTree.main");
    }

    public TreeNode mirrorTree(TreeNode root) {
        if (null == root) {
            return root;
        }
        TreeNode res = new TreeNode(root.val);
        res.val = root.val;
        if (null != root.left) {
            res.right = mirrorTree(root.left);
        }
        if (null != root.right) {
            res.left = mirrorTree(root.right);
        }
        return res;
    }
}