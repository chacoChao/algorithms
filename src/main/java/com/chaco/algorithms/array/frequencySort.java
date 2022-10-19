package com.chaco.algorithms.array;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @link https://leetcode.cn/problems/sort-array-by-increasing-frequency/
 * 给你一个整数数组 nums
 * 请你将数组按照每个值的频率 升序 排序。如果有多个值的频率相同
 * 请你按照数值本身将它们 降序 排序。
 * 请你返回排序后的数组。
 * example1
 * 输入：nums = [1,1,2,2,2,3]
 * 输出：[3,1,1,2,2,2]
 * 解释：'3' 频率为 1，'1' 频率为 2，'2' 频率为 3 。
 * example2
 * 输入：nums = [2,3,1,3,2]
 * 输出：[1,3,3,2,2]
 * 解释：'2' 和 '3' 频率都为 2 ，所以它们之间按照数值本身降序排序.
 * example3
 * 输入：nums = [-1,1,-6,4,5,-6,1,4,1]
 * 输出：[5,-1,4,4,-6,-6,1,1,1]
 */
public class frequencySort {
    public int[] frequencySort(int[] nums) {
        Map<Integer, Integer> map = new LinkedHashMap<>();
        // key count mapping
        for (int num : nums) {
            Integer count = map.getOrDefault(num, 0);
            map.put(num, ++count);
        }
        //sort count
        List<Integer> list = new LinkedList<>();
        for (int num : nums) {
            list.add(num);
        }
        list.sort((a, b) -> {
            int m1 = map.get(a), m2 = map.get(b);
            return m1 != m2 ? m1 - m2 : b - a;
        });
        int length = nums.length;
        for (int i = 0; i < length; i++) {
            nums[i] = list.get(i);
        }
        return nums;
    }

    public static void main(String[] args) {
        System.out.println("frequencySort.main");
    }
}