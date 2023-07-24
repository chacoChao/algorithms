package com.chaco.algorithms.newcoder;

import java.util.Arrays;

/**
 * <a href="https://www.nowcoder.com/practice/0c1b486d987b4269b398fee374584fc8?tpId=13">question</a>
 * 输入一个长度为 n 整数数组，数组里面可能含有相同的元素，实现一个函数来调整该数组中数字的顺序，使得所有的奇数位于数组的前面部分，所有的偶数位于数组的后面部分，对奇数和奇数，偶数和偶数之间的相对位置不做要求，但是时间复杂度和空间复杂度必须如下要求。
 * <p>
 * 数据范围：0 \le n \le 500000≤n≤50000，数组中每个数的值 0 \le val \le 100000≤val≤10000
 * 要求：时间复杂度 O(n)O(n)，空间复杂度 O(1)O(1)
 * <p>
 * 输入：[1,2,3,4]
 * <p>
 * 返回值：[1,3,2,4]
 * 说明：[3,1,2,4]或者[3,1,4,2]也是正确答案
 * <p>
 * 输入：[1,3,5,6,7]
 * 返回值：[1,3,5,7,6]
 * 说明：[3,1,5,7,6]等也是正确答案
 * <p>
 * 输入：[1,4,4,3]
 * 返回值：[1,3,4,4]
 */
public class reOrderArrayTwo {
    public static void main(String[] args) {
        int[] arr = new int[]{1, 4, 4, 3};
        int[] arrayTwo = reOrderArrayTwo.reOrderArrayTwo(arr);
        System.out.println("reOrderArrayTwo.main:" + Arrays.toString(arrayTwo));
    }

    public static int[] reOrderArrayTwo(int[] array) {
        int i = 0, j = array.length - 1;
        while (i < j) {
            if (array[i] % 2 == 1) {
                i++;
                continue;
            }
            if (array[j] % 2 == 0) {
                j--;
                continue;
            }

            int tmp = array[i];
            array[i] = array[j];
            array[j] = tmp;
        }
        return array;
    }
}