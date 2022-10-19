package com.chaco.algorithms.array;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 全排列
 * 输入: [1,2,3]
 * 输出:
 * [
 * [1,2,3],
 * [1,3,2],
 * [2,1,3],
 * [2,3,1],
 * [3,1,2],
 * [3,2,1]
 * ]
 */
public class permute {

    public static void main(String[] args) {
        int[] input = new int[]{1,2,3};
        List<List<Integer>> permute = com.chaco.algorithms.array.permute.permute(input);
        System.out.println("hello world!"+ permute);
    }

    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> output = new ArrayList<>();
        for (int num : nums) {
            output.add(num);
        }
        DFS(nums.length, res, output, 0);
        return res;
    }

    public static void DFS(int n, List<List<Integer>> res, List<Integer> output, int first) {
        if (n == first) {
            res.add(new ArrayList<Integer>(output));
        } else {
            for (int i = first; i < n; i++) {
                Collections.swap(output, first, i);
                DFS(n, res, output, first + 1);
                Collections.swap(output, first, i);
            }
        }
    }
}
















