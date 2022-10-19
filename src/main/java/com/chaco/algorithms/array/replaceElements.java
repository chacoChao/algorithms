package com.chaco.chao.algorithms.array;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static java.util.Arrays.*;
import static java.util.Collections.*;

/**
 * @link https://leetcode.cn/problems/replace-elements-with-greatest-element-on-right-side/
 * <p>
 * 给你一个数组 arr ，请你将每个元素用它右边最大的元素替换，如果是最后一个元素，用 -1 替换。
 * 完成所有替换操作后，请你返回这个数组。
 * <p>
 * example:
 * 输入：arr = [17,18,5,4,6,1]
 * 输出：[18,6,6,6,1,-1]
 */
public class replaceElements {
    public static void main(String[] args) {
        int[] arr = new int[]{17, 18, 5, 4, 6, 1};
        int[] res = replaceElements.replaceElements(arr);
        System.out.println("du" + Arrays.toString(res));
    }

    public static int[] replaceElements(int[] arr) {
        if (null == arr || arr.length == 0) {
            return new int[]{-1};
        }
        for (int i = 0; i < arr.length; i++) {
            if (i == arr.length - 1) {
                arr[i] = -1;
                break;
            }
            arr[i] = Arrays.stream(Arrays.copyOfRange(arr, i + 1, arr.length)).max().getAsInt();
        }
        return arr;
    }
}
