package com.chaco.algorithms.tree;

import com.chaco.algorithms.TreeNode;

/**
 * author:zhaopeiyan001
 * Date:2020-04-30 17:49
 */
public class Mirror {
    /**
     * 操作给定的二叉树，将其变换为源二叉树的镜像。
     */
    public void Mirror(TreeNode root) {
        if (null == root) {
            return;
        }
        if (root.left != null) {
            Mirror(root.left);
        }
        if (root.right != null) {
            Mirror(root.right);
        }
        TreeNode tmp;
        tmp = root.left;
        root.left = root.right;
        root.right = tmp;
    }
}
