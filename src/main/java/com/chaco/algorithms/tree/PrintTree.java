package com.chaco.algorithms.tree;

import com.chaco.algorithms.TreeNode;

import java.util.*;

public class PrintTree {
    public static void main(String[] args) {
        System.out.println("PrintTree.main");
    }

    ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        if (null == pRoot) {
            return res;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(pRoot);
        while (!queue.isEmpty()) {
            int l = queue.size();
            ArrayList<Integer> tmp = new ArrayList<>();
            for (int i = 0; i < l; i++) {
                TreeNode node = queue.poll();
                tmp.add(node.val);
                if (null != node.left) {
                    queue.add(node.left);
                }
                if (null != node.right) {
                    queue.add(node.right);
                }
            }
            res.add(tmp);
        }
        return res;
    }
}