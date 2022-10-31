package com.chaco.algorithms.array;

import java.util.*;

import static java.util.Arrays.*;

/**
 * <a href="https://leetcode.cn/problems/zui-xiao-de-kge-shu-lcof/solutions/">...</a>
 * <a href="https://www.nowcoder.com/practice/6a296eb82cf844ca8539b57c23e6e9bf">...</a>
 * 给定一个长度为 n 的可能有重复值的数组，找出其中不去重的最小的 k 个数。
 * 例如数组元素是4,5,1,6,2,7,3,8这8个数字，则最小的4个数字是1,2,3,4(任意顺序皆可)。
 */
public class GetLeastNumbers_Solution {
    public static void main(String[] args) {
        System.out.println();
    }

    public List<Integer> GetLeastNumbers_Solution(int[] input, int k) {
        ArrayList<Integer> res = new ArrayList<>();
        sort(input);
        for (int i = 0; i < k; i++) {
            res.add(input[i]);
        }
        return res;
    }

    public List<Integer> GetLeastNumbers_Solution1(int[] input, int k) {
        ArrayList<Integer> res = new ArrayList<>();
        if (Objects.equals(0, k)) {
            return res;
        }
        PriorityQueue<Integer> q = new PriorityQueue<>((o1, o2) -> o2.compareTo(o1));
        for (int i = 0; i < k; i++) {
            q.offer(input[i]);
        }
        for (int i = k; i < input.length; i++) {
            //较小元素入堆
            if (q.peek() > input[i]) {
                q.poll();
                q.offer(input[i]);
            }
        }
        for (int i = 0; i < k; i++) {
            res.add(q.poll());
        }
        return res;
    }

    //PriorityQueue<Integer> q = new PriorityQueue<>((o1, o2) -> o2.compareTo(o1));
    //PriorityQueue<Integer> q = new PriorityQueue<Integer>((a, b) -> (b - a));
    public int[] getLeastNumbers2(int[] arr, int k) {
        int[] res = new int[k];
        if (Objects.equals(0, k)) {
            return res;
        }
        PriorityQueue<Integer> q = new PriorityQueue<>((o1, o2) -> o2.compareTo(o1));
        for (int i = 0; i < k; i++) {
            q.offer(arr[i]);
        }
        for (int i = k; i < arr.length; i++) {
            //较小元素入堆
            if (q.peek() > arr[i]) {
                q.poll();
                q.offer(arr[i]);
            }
        }
        for (int i = 0; i < k; i++) {
            res[i] = q.poll();
        }
        return res;
    }
}