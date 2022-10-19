package com.chaco.algorithms.leetcode;

import java.util.Arrays;

/**
 * 题目介绍：
 * 一个人同一时间只能参加一场面试
 * 面试对象包含一个开始时间，一个结束时间
 * 面试结束之后可以立马参加下一场面试
 * （即1个面试结束时间和另一个面试开始时间可以相同，不算冲突）
 * <p>
 * 输入：
 * 面试列表（其中的面试时间可能冲突）
 * <p>
 * 输出：
 * 可参加的最大面试数量
 * <p>
 * <p>
 * input = [{1,2},{2,6},{3,4},{4,5},...]
 * output = 3
 */
public class MeiCan {
    public static void main(String[] args) {
        int[][] input = {{1, 2}, {2, 6}, {3, 4}, {4, 5}};
        Integer integer = MeiCan.maxNumber(input);
        System.out.println("最多可参加" + integer + "场面试。");
    }

    public static Integer maxNumber(int[][] schedule) {
        int length = schedule.length;
        int[] begin = new int[length];
        int[] end = new int[length];
        for (int i = 1; i < length; i++) {
            begin[i] = schedule[i][0];
            end[i] = schedule[i][1];
        }
        Arrays.sort(begin);
        Arrays.sort(end);

        //计数器
        int count = 0;
        //双指针
        int res = 0, i = 0, j = 0;
        while (i < length && j < length) {
            if (begin[i] <= end[j]) {
                count++;
                i++;
            } else {
                count--;
                j++;
            }
            res = Math.max(res, count);
        }
        return res;
    }
}