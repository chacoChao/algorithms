package com.chaco.chao.algorithms.array;

import java.util.LinkedList;
import java.util.List;

/**
 * @link https://leetcode.cn/problems/pascals-triangle/
 * 给定一个非负整数 numRows，生成「杨辉三角」的前 numRows 行。
 * 在「杨辉三角」中，每个数是它左上方和右上方的数的和。
 * <p>
 * example:
 * 输入: numRows = 5
 * 输出: [[1],[1,1],[1,2,1],[1,3,3,1],[1,4,6,4,1]]
 * <p>
 * example:
 * 输入: numRows = 1x
 * 输出: [[1]]
 */
public class PascalTriangle {
    public static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new LinkedList<>();
        for (int i = 0; i < numRows; i++) {
            List<Integer> tmp = new LinkedList<>();
            for (int j = 0; j <= i; j++) {
                if (j == 0 || j == i) {
                    tmp.add(1);
                } else {
                    tmp.add(res.get(i - 1).get(j) + res.get(i - 1).get(j - 1));
                }
            }
            res.add(tmp);
        }
        return res;
    }

    public static void main(String[] args) {
        List<List<Integer>> lists = PascalTriangle.generate(5);
        System.out.printf(lists.toString());
    }
}