package com.chaco.algorithms.array;

import java.util.Arrays;

import static java.util.Arrays.*;

/**
 * 给你一个整数数组 arr ，请你删除最小5%的数字和最大5%的数字后，剩余数字的平均值。
 */
public class trimMean {
    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 3};
        int[] arr1 = new int[]{6, 0, 7, 0, 7, 5, 7, 8, 3, 4, 0, 7, 8, 1, 6, 8, 1, 1, 2, 4, 8, 1, 9, 5, 4, 3, 8, 5, 10, 8, 6, 6, 1, 0, 6, 10, 8, 2, 3, 4};
        int[] arr2 = new int[]{6,2,7,5,1,2,0,3,10,2,5,0,5,5,0,8,7,6,8,0};
        double d = trimMean(arr2);
        System.out.println("trimMean.main" + d);
    }

    public static double trimMean(int[] arr) {
        Arrays.sort(arr);
        int pre = arr.length / 20;
        double res = (double) Arrays.stream(Arrays.copyOfRange(arr, pre - 1, arr.length - pre)).sum() / (arr.length - (2 * pre));
        return res;
    }
}