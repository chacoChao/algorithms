package com.chaco.algorithms.dp;

import com.chaco.algorithms.TreeNode;

import java.util.*;

/**
 * 二叉树中的最大路径和
 * https://www.nowcoder.com/practice/8fda1d22554f4824b0ef9c26f35e54dd?tpId=230&tqId=39756&ru=/exam/oj
 * https://leetcode.cn/problems/binary-tree-maximum-path-sum/
 * 路径 被定义为一条从树中任意节点出发，沿父节点-子节点连接，达到任意节点的序列。
 * 同一个节点在一条路径序列中 至多出现一次 。该路径 至少包含一个 节点，且不一定经过根节点。
 * <p>
 * 路径和 是路径中各节点值的总和。
 * <p>
 * 给你一个二叉树的根节点 root ，返回其 最大路径和 。
 * <p>
 * 输入：root = [1,2,3]
 * 输出：6
 * 解释：最优路径是 2 -> 1 -> 3 ，路径和为 2 + 1 + 3 = 6
 * <p>
 * 输入：root = [-10,9,20,null,null,15,7]
 * 输出：42
 * 解释：最优路径是 15 -> 20 -> 7 ，路径和为 15 + 20 + 7 = 42
 */
public class maxPathSum {
    public static void main(String[] args) {
        System.out.println("maxPathSum.main");
    }

    int maxSum = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        maxGain(root);
        return maxSum;
    }

    //递归
    private int maxGain(TreeNode root) {
        if (null == root) {
            return 0;
        }
        int leftGain = Math.max(maxGain(root.left), 0);
        int rightGain = Math.max(maxGain(root.right), 0);
        // 节点的最大路径和取决于该节点的值与该节点的左右子节点的最大贡献值
        int priceNewpath = root.val + leftGain + rightGain;
        maxSum = Math.max(maxSum, priceNewpath);
        return root.getVal() + Math.max(leftGain, rightGain);
    }
}