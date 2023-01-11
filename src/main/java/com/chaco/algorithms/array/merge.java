package com.chaco.algorithms.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://leetcode.cn/problems/merge-intervals/
 * 以数组 intervals 表示若干个区间的集合，其中单个区间为 intervals[i] = [starti, endi] 。
 * 请你合并所有重叠的区间，并返回 一个不重叠的区间数组，该数组需恰好覆盖输入中的所有区间 。
 * 示例 1：
 * 输入：intervals = [[1,3],[2,6],[8,10],[15,18]]
 * 输出：[[1,6],[8,10],[15,18]]
 * 解释：区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
 * 示例 2：
 * 输入：intervals = [[1,4],[4,5]]
 * 输出：[[1,5]]
 * 解释：区间 [1,4] 和 [4,5] 可被视为重叠区间。
 */
public class merge {
    public static void main(String[] args) {
        int[][] intervals = new int[][]{{1, 3}, {2, 6}, {8, 10}, {15, 18}};
        int[][] ints = com.chaco.algorithms.array.merge.mergeArr(intervals);
        System.out.println("merge.main:" + Arrays.deepToString(ints));

        int[][] intervals2 = new int[][]{{1, 4}, {4, 5}};
        int[][] ints2 = com.chaco.algorithms.array.merge.mergeArr(intervals2);
        System.out.println("merge.main:" + Arrays.deepToString(ints2));

        int[][] intervals3 = new int[][]{{1, 4}, {5, 6}};
        int[][] ints3 = com.chaco.algorithms.array.merge.mergeArr(intervals3);
        System.out.println("merge.main:" + Arrays.deepToString(ints3));
    }

    public static int[][] mergeArr(int[][] intervals) {
        if (null == intervals || intervals.length == 1) {
            return intervals;
        }
        Arrays.sort(intervals, (v1, v2) -> v1[0] - v2[0]);
        int[][] res = new int[intervals.length][2];
        int c = -1;
        for (int[] arr : intervals) {
            if (c == -1 || arr[0] > res[c][1]) {
                res[++c] = arr;
            } else {
                res[c][1] = Math.max(res[c][1], arr[1]);
            }
        }
        return Arrays.copyOf(res, c + 1);
    }
}