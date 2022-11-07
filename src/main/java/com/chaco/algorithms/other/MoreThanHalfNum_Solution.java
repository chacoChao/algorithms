package com.chaco.algorithms.other;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * https://www.nowcoder.com/practice/e8a1b01a2df14cb2b228b30ee6a92163
 * https://leetcode.cn/problems/shu-zu-zhong-chu-xian-ci-shu-chao-guo-yi-ban-de-shu-zi-lcof/
 * 给一个长度为 n 的数组，数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。
 * 例如输入一个长度为9的数组[1,2,3,2,2,2,5,4,2]。由于数字2在数组中出现了5次，超过数组长度的一半，因此输出2。
 */
public class MoreThanHalfNum_Solution {
    public static void main(String[] args) {
        System.out.println("MoreThanHalfNum_Solution.main");
    }

    public int MoreThanHalfNum_Solution(int[] array) {
        if (null == array || array.length == 0) {
            return 0;
        }
        if (1 == array.length || 2 == array.length) {
            return array[0];
        }
        Map<Integer, Integer> map = new HashMap<>();
        for (int j : array) {
            map.put(j, map.getOrDefault(j, 0) + 1);
        }
        for (Integer key : map.keySet()) {
            if (map.get(key) >= array.length / 2 + 1) {
                return key;
            }
        }
        return array[0];
    }

    public int MoreThanHalfNum_Solution1(int[] array) {
      Arrays.sort(array);
      return array[array.length];
    }
}