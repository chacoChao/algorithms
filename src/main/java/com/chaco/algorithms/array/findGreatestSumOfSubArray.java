package com.chaco.algorithms.array;

/**
 * {@link <a href="https://www.nowcoder.com/practice/459bd355da1549fa8a49e350bf3df484">...</a>?}
 * 输入一个长度为n的整型数组array，数组中的一个或连续多个整数组成一个子数组，子数组最小长度为1。
 * 求所有子数组的和的最大值。
 */
public class findGreatestSumOfSubArray {
    public static int FindGreatestSumOfSubArray(int[] array) {
        int maxSum = array[0], sum = 0;
        for (int i = 0; i < array.length; i++) {
            sum = 0;
            for (int j = i; j < array.length; j++) {
                sum += array[j];
                maxSum = Math.max(maxSum, sum);
            }
        }
        return maxSum;
    }

    public static int FindGreatestSumOfSubArray1(int[] array) {
        int[] dp = new int[array.length];
        dp[0] = array[0];
        int maxSum = array[0];
        for (int i = 0; i < array.length; i++) {
            dp[i] = Math.max(dp[i], dp[i - 1] + dp[i]);
            maxSum = Math.max(dp[i], maxSum);
        }
        return maxSum;
    }

    public static int FindGreatestSumOfSubArray2(int[] array) {
        int maxSum = array[0];
        int sum = 0;
        for (int i = 0; i < array.length; i++) {
            sum = Math.max(array[i], sum + array[i]);
            maxSum = Math.max(sum, maxSum);
        }
        return maxSum;
    }


    public static void main(String[] args) {
        int[] arr = new int[]{1, -2, 3, 10, -4, 7, 2, -5};
        int sum = findGreatestSumOfSubArray.FindGreatestSumOfSubArray2(arr);
        System.out.println("FindGreatestSumOfSubArray.main" + sum);
    }
}