package com.chaco.algorithms.array;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * https://www.nowcoder.com/practice/389fc1c3d3be4479a154f63f495abff8
 * 一个整型数组里除了两个数字只出现一次，其他的数字都出现了两次。请写程序找出这两个只出现一次的数字。
 */
public class FindNumsAppearOnce {
    public static void main(String[] args) {
      int[] ints = FindNumsAppearOnce.FindNumsAppearOnce(new int[]{1, 4, 1, 6});
      System.out.println("FindNumsAppearOnce.main"+Arrays.toString(ints));
    }

    public static int[] FindNumsAppearOnce(int[] array) {
        Set<Integer> set = new HashSet<>();
        for (Integer i : array) {
            if (set.contains(i)) {
                set.remove(i);
                continue;
            }
            set.add(i);
        }
        int[] res = new int[2];
        int i = 0;
        for (Integer item : set) {
            res[i++] = item;
        }
        return res;
    }
}