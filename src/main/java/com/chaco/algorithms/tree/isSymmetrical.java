package com.chaco.algorithms.tree;

import com.chaco.algorithms.TreeNode;

/**
 * https://www.nowcoder.com/practice/ff05d44dfdb04e1d83bdbdab320efbcb
 * https://leetcode.cn/problems/symmetric-tree/
 * 给定一棵二叉树，判断其是否是自身的镜像（即：是否对称
 */
public class isSymmetrical {
    public static void main(String[] args) {
        System.out.println("isSymmetrical.main");
    }

    boolean isSymmetrical(TreeNode pRoot) {
        if (null == pRoot) {
            return true;
        }
        return check(pRoot, pRoot);
    }

    private boolean check(TreeNode left, TreeNode right) {
        if (null == left && null == right) {
            return true;
        }
        if (null == left || null == right) {
            return false;
        }
        return left.val == right.val && check(left.left, right.right) && check(left.right, right.left);
    }
}