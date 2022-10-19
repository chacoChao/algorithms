package com.chaco.chao.algorithms.leetcode;

import java.util.PriorityQueue;

public class lc215 {
    public static void main(String[] args) {

    }

    public int findKthLargest(int[] nums, int k) {
        //使用PriorityQueue(小顶堆实现)
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int num : nums) {
            pq.offer(num);
            if (pq.size() > k) {
                //多于K个元素，删除堆顶元素
                pq.poll();
            }
        }
        return pq.peek();
    }
}
