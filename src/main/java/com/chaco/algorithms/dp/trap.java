package com.chaco.algorithms.dp;

/**
 * https://leetcode.cn/problems/trapping-rain-water/
 * 给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。
 * 
 * height = [0,1,0,2,1,0,1,3,2,1,2,1]
 * 输出：6
 * 解释：上面是由数组 [0,1,0,2,1,0,1,3,2,1,2,1] 表示的高度图，在这种情况下，可以接 6 个单位的雨水（蓝色部分表示雨水）。
 * 
 * height = [4,2,0,3,2,5]
 * 输出：9
 */
public class trap {
    public static void main(String[] args) {
        int[] arr = new int[] { 0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1 };
        int result = trap.trap(arr);
        System.out.println("trap.trap:" + result);
    }

    // 双指针
    public static int trap(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int result = 0;

        int leftMax = 0;
        int rightMax = 0;
        while (left < right) {
            if (height[left] < height[right]) {
                if (height[left] < leftMax) {
                    result += leftMax - height[left];
                } else {
                    leftMax = height[left];
                }
                left++;
            } else {
                if (height[right] < rightMax) {
                    result += rightMax - height[right];
                } else {
                    rightMax = height[right];
                }
                right--;
            }
        }
        return result;
    }

    // DP
    public static int trapDp(int[] height) {
        int result = 0;
        int n = height.length;
        if (0 == n) {
            return result;
        }

        int[] leftArr = new int[n + 1];
        leftArr[0] = height[0];
        for (int i = 1; i < n; i++) {
            leftArr[i] = Math.max(leftArr[i - 1], height[i]);
        }
        int[] rightArr = new int[n + 1];
        rightArr[n - 1] = height[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            rightArr[i] = Math.max(rightArr[i + 1], height[i]);
        }

        for (int i = 0; i < n; i++) {
            result += Math.min(leftArr[i], rightArr[i]) - height[i];
        }
        return result;
    }
}
