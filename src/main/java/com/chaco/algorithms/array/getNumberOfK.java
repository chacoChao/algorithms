package com.chaco.algorithms.array;

import java.util.Arrays;

/**
 * <a href="https://www.nowcoder.com/practice/70610bf967994b22bb1c26f9ae901fa2">...</a>
 * 给定一个长度为 n 的非降序数组和一个非负数整数 k ，要求统计 k 在数组中出现的次数
 */
public class getNumberOfK {
    public static void main(String[] args) {
        System.out.println("getNumberOfK.main");
    }

    public int GetNumberOfK(int[] array, int k) {
        int count = 0;
        for (int j : array) {
            if (j == k) {
                count++;
            }
        }
        return count;
    }
}