package com.chaco.algorithms.array;

import java.util.Arrays;

/**
 * https://www.nowcoder.com/practice/11662ff51a714bbd8de809a89c481e21
 * 输入一个长度为n的整型数组array，数组中的一个或连续多个整数组成一个子数组，找到一个具有最大和的连续子数组。
 * 1.子数组是连续的，比如[1,3,5,7,9]的子数组有[1,3]，[3,5,7]等等，但是[1,3,7]不是子数组
 * 2.如果存在多个最大和的连续子数组，那么返回其中长度最长的，该题数据保证这个最长的只存在一个
 * 3.该题定义的子数组的最小长度为1，不存在为空的子数组，即不存在[]是某个数组的子数组
 * 4.返回的数组不计入空间复杂度计算
 * <p>
 * 输入：[1,-2,3,10,-4,7,2,-5]
 * 返回值：[3,10,-4,7,2]
 * <p>
 * 输入：[1,2,-3,4,-1,1,-3,2]
 * 返回值：[1,2,-3,4,-1,1]
 * 说明：
 * 经分析可知，最大子数组的和为4，有[4],[4,-1,1],[1,2,-3,4],[1,2,-3,4,-1,1]，故返回其中长度最长的[1,2,-3,4,-1,1]
 */
public class FindGreatestSumOfSubArray2 {
    public static int[] FindGreatestSumOfSubArray(int[] array) {
        int[] dp = new int[array.length];
        dp[0] = array[0];
        int max = dp[0], left = 0, right = 0, indexLeft = 0, indexRight = 0;
        for (int i = 1; i < array.length; i++) {
            right++;
            dp[i] = Math.max(dp[i - 1] + array[i], array[i]);
            if (dp[i - 1] + array[i] < array[i]) {
                left = right;
            }
            //最大值转移&最大涉及区间转移
            if (dp[i] > max || dp[i] == max && (right - left + 1) > (indexRight - indexLeft + 1)) {
                max = dp[i];
                indexLeft = left;
                indexRight = right;
            }
        }
        return Arrays.copyOfRange(array, indexLeft, indexRight + 1);
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1, -2, 3, 10, -4, 7, 2, -5};
        int[] subArray = FindGreatestSumOfSubArray2.FindGreatestSumOfSubArray(arr);
        System.out.println("FindGreatestSumOfSubArray2.main" + Arrays.toString(subArray));
        int[] arr1 = new int[]{1, 2, -3, 4, -1, 1, -3, 2};
        int[] subArray1 = FindGreatestSumOfSubArray2.FindGreatestSumOfSubArray(arr1);
        System.out.println("FindGreatestSumOfSubArray2.main" + Arrays.toString(subArray1));
    }
}