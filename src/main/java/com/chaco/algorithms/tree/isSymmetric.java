package com.chaco.algorithms.tree;

import com.chaco.algorithms.TreeNode;

public class isSymmetric {
    public static void main(String[] args) {
        System.out.println("isSymmetric.main");
    }

    public boolean isSymmetric(TreeNode root) {
        return check(root, root);
    }

    public boolean check(TreeNode left, TreeNode right) {
        if (null == left && null == right) {
            return true;
        }
        if (null == left || null == right) {
            return false;
        }
        return left.val == right.val && check(left.left, right.right) && check(left.right, right.left);
    }
}