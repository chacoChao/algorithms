package com.chaco.algorithms.tree;

import java.util.Stack;

/**
 * https://www.nowcoder.com/practice/a861533d45854474ac791d90e447bafd
 * 输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历的结果。如果是则返回 true ,否则返回 false 。
 * 假设输入的数组的任意两个数字都互不相同。
 * 要求：空间复杂度 O(n)O(n) ，时间时间复杂度 O(n^2)O(n)
 * 提示：
 * 1.二叉搜索树是指父亲节点大于左子树中的全部节点，但是小于右子树中的全部节点的树。
 * 2.该题我们约定空树不是二叉搜索树
 * 3.后序遍历是指按照 “左子树-右子树-根节点” 的顺序遍历
 */
public class VerifySquenceOfBST {
    public static void main(String[] args) {
        int[] s = new int[]{1, 3, 2};
        boolean ofBST = VerifySquenceOfBST.VerifySquenceOfBST(s);
        System.out.println("VerifySquenceOfBST.main:" + ofBST);
    }

    public static boolean VerifySquenceOfBST(int[] sequence) {
        if (null == sequence || sequence.length == 0) {
            return false;
        }
        Stack<Integer> stack = new Stack<>();
        int max = Integer.MAX_VALUE;
        for (int i = sequence.length - 1; i >= 0; i--) {
            if (max < sequence[i]) {
                return false;
            }
            while (!stack.isEmpty() && stack.peek() > sequence[i]) {
                max = stack.pop();
            }
            stack.add(sequence[i]);
        }
        return true;
    }
}