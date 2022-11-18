package com.chaco.algorithms.tree;

import com.chaco.algorithms.TreeNode;

/**
 * https://www.nowcoder.com/practice/57aa0bab91884a10b5136ca2c087f8ff?tpId=13&tqId=2305268&ru=/exam/oj/ta&qru=/ta/coding-interviews/question-ranking&sourceUrl=%2Fexam%2Foj%2Fta%3Fpage%3D1%26tpId%3D13%26type%3D13
 * https://leetcode.cn/problems/er-cha-sou-suo-shu-de-di-kda-jie-dian-lcof/description/
 * 给定一棵结点数为n 二叉搜索树，请找出其中的第 k 小的TreeNode结点值。
 * 1.返回第k小的节点值即可
 * 2.不能查找的情况，如二叉树为空，则返回-1，或者k大于n等等，也返回-1
 * 3.保证n个节点的值不一样
 * 进阶：空间复杂度 O(n)O(n)，时间复杂度 O(n)O(n)
 * 如输入{5,3,7,2,4,6,8},3时，二叉树{5,3,7,2,4,6,8}如下图所示：
 * 该二叉树所有节点按结点值升序排列后可得[2,3,4,5,6,7,8]，所以第3个结点的结点值为4，故返回对应结点值为4的结点即可。
 */
public class KthNode {
    public static void main(String[] args) {
        //[3,1,4,null,2]
        TreeNode t4 = new TreeNode(4);
        TreeNode t3 = new TreeNode(3);
        TreeNode t2 = new TreeNode(2);
        TreeNode t1 = new TreeNode(1);
        t3.left = t1;
        t1.right = t2;
        t3.right = t4;
        int i = KthNode.KthNode(t3, 4);
        System.out.println("KthNode.main:" + i);

        int i1 = kthLargest(t3, 4);
        System.out.println("KthNode.main:" + i1);
    }

    static int res = -1;
    static int count = 0;

    //找到第k小的节点
    public static int KthNode(TreeNode proot, int k) {
        if (null == proot || k < 0) {
            return -1;
        }
        KthNode(proot.left, k);
        count++;
        if (count == k) {
            return res = proot.val;
        }
        KthNode(proot.right, k);
        return res;
    }


    //找到第k大的节点,中序遍历倒叙
    public static int kthLargest(TreeNode proot, int k) {
        if (null == proot || 0 > k) {
            return -1;
        }
        kthLargest(proot.right, k);
        count++;
        if (k == count) {
            return proot.val;
        }
        kthLargest(proot.left, k);
        return -1;
    }
}