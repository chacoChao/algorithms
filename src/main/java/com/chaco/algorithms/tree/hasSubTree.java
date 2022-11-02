package com.chaco.algorithms.tree;


import com.chaco.algorithms.TreeNode;

/**
 * author:zhaopeiyan001
 * Date:2020-04-29 20:00
 */
public class hasSubTree {
    /**
     * 输入两棵二叉树A，B，判断B是不是A的子结构。（ps：我们约定空树不是任意一个树的子结构）
     *
     * @param root1
     * @param root2
     * @return
     */
    public boolean HasSubtree(TreeNode root1, TreeNode root2) {
        if (root1 == null || root2 == null) {
            return false;
        }
        return DoesHasSonTree(root1, root2) || HasSubtree(root1.left, root2) || HasSubtree(root1.right, root2);
    }

    private Boolean DoesHasSonTree(TreeNode root1, TreeNode root2) {
        if (root2 == null) {
            return true;
        }
        if (root1 == null) {
            return false;
        }
        return (root1.val == root2.val) && DoesHasSonTree(root1.left, root2.left) && DoesHasSonTree(root1.right, root2.right);
    }
}
