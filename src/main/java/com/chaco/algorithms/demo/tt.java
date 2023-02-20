package com.chaco.algorithms;
/**
 * search demo
 */
public class tt {
    public static void main(String[] args) {
        System.out.println("tt.main");
    }

    public int findV(int[] nums, int v, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (true) {
            Integer midIndex = (left + right) / 2;
            if (nums[midIndex] == v) {
                return midIndex;
            } else if (nums[midIndex] > v) {
                right = midIndex - 1;
            } else if (nums[midIndex] < v) {
                left = midIndex + 1;
            }
        }
        if (nums.length <= left || nums[left] != target) {
            return -1;
        }
        return left;
    }
}