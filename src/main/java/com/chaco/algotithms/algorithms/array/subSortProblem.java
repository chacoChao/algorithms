package com.chaco.chao.algorithms.array;

/**
 * {@link} https://leetcode.cn/problems/sub-sort-lcci/
 * 给定一个整数数组，编写一个函数，找出索引m和n，只要将索引区间[m,n]的元素排好序，整个数组就是有序的。
 * 注意：n-m尽量最小，也就是说，找出符合条件的最短序列。
 * 函数返回值为[m,n]，若不存在这样的m和n（例如整个数组是有序的），请返回[-1,-1]。
 * 
 * 输入： [1,2,4,7,10,11,7,12,6,7,16,18,19]
 * 输出： [3,9]
 */
public class subSortProblem {
    public static int[] subSort(int[] array) {
        int low = Integer.MAX_VALUE, high = Integer.MIN_VALUE, lowPos = -1, highPos = -1, length = array.length;
        if (array != null || array.length != 0) {
            for (int i = 0; i < length; i++) {
                if (low >= array[length - i - 1]) {
                    low = Math.min(low, array[length - i - 1]);
                } else {
                    lowPos = length - i - 1;
                }
                if (high <= array[i]) {
                    high = Math.max(high, array[i]);
                } else {
                    highPos = i;
                }
            }
        }
        return new int[] { lowPos, highPos };
    }

    public static void main(String[] args) {
        int[] arr = new int[] { 1, 2, 4, 7, 10, 11, 7, 12, 6, 7, 16, 18, 19 };

        int[] res = subSortProblem.subSort(arr);
        System.out.println("===========" + res[0] + "➡️" + res[1]);
    }
}
