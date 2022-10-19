package com.chaco.algorithms.array;

import java.util.Arrays;
import java.util.Objects;

/**
 * @link <a href="https://leetcode.cn/problems/find-pivot-index/">...</a>
 * 给你一个整数数组 nums ，请计算数组的 中心下标 。
 * 数组 中心下标 是数组的一个下标，其左侧所有元素相加的和等于右侧所有元素相加的和。
 * 如果中心下标位于数组最左端，那么左侧数之和视为 0 ，因为在下标的左侧不存在元素。这一点对于中心下标位于数组最右端同样适用。
 * 如果数组有多个中心下标，应该返回 最靠近左边 的那一个。如果数组不存在中心下标，返回 -1 。
 * <p>
 * example:
 * 输入：nums = [1, 7, 3, 6, 5, 6]
 * 输出：3
 * <p>
 * 输入：nums = [1, 2, 3]
 * 输出：-1
 * <p>
 * 输入：nums = [2, 1, -1]
 * 输出：0
 */
public class pivotIndex {
    public static void main(String[] args) {
        int[] arr = new int[]{1, 7, 3, 6, 5, 6};
        int index = pivotIndex.pivotIndex(arr);
        System.out.println("pivotIndex" + index);

        int[] arr1 = new int[]{1, 2, 3};
        int index1 = pivotIndex.pivotIndex(arr1);
        System.out.println("pivotIndex" + index1);

        int[] arr2 = new int[]{2, 1, -1};
        int index2 = pivotIndex.pivotIndex(arr2);
        System.out.println("pivotIndex" + index2);
    }

    public static int pivotIndex(int[] nums) {
        if (null == nums || nums.length == 0) {
            return -1;
        }
        for (int i = 0; i < nums.length; i++) {
            int perSum = Arrays.stream(Arrays.copyOfRange(nums, 0, i)).sum();
            int backSum = Arrays.stream(Arrays.copyOfRange(nums, i + 1, nums.length)).sum();
            if (Objects.equals(perSum, backSum)) {
                return i;
            }
        }
        return -1;
    }

    public static int pivotIndex1(int[] nums) {
        if (null == nums || nums.length == 0) {
            return -1;
        }
        int total = Arrays.stream(nums).sum();
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            if (2 * sum + nums[i] == total) {
                return i;
            }
            sum += nums[i];
        }
        return -1;
    }

}