package com.chaco.algorithms.array;

import java.util.*;

public class LongestSonList {
    /**
     * 找出目标（乱序）队列中，最长（连续）降序子队列，并返回
     * 例如：[3,5,2,35,35,23,21,22,16,16,11,8,6,5,3,2,4,2,1]
     * 返回：[22,16,16,11,8,6,5,3,2]
     * 要求：时间复杂度O(n)
     *
     * @param targetList
     * @return
     */
    private static List<Integer> find(List<Integer> targetList) {
        List<Integer> res = new LinkedList<>();
        if (targetList.size() <= 2) {
            if (targetList.size() == 2 && targetList.get(0) < targetList.get(1)) {
                res.add(targetList.get(1));
                return res;
            } else {
                return targetList;
            }
        }

        for (int j = 0; j < targetList.size() - 1; j++) {
            List<Integer> tmp = new LinkedList<>();
            int i = j;
            while (i++ < targetList.size() - 1) {
                if (targetList.get(i) >= targetList.get(j)) {
                    tmp.add(targetList.get(i));
                }
            }
            res = res.size() > tmp.size() ? res : tmp;
            tmp = new LinkedList<>();
        }
        Collections.sort(res);
        Collections.reverse(res);
        return res;
    }

    public static void main(String[] args) {
        List<Integer> targetList1 = Arrays.asList(3, 5, 2, 35, 35, 23, 21, 22, 16, 16, 11, 8, 6, 5, 3, 2, 4, 2, 1);
        System.out.println(find(targetList1));
        List<Integer> targetList2 = Arrays.asList(3);
        System.out.println(find(targetList2));
        List<Integer> targetList3 = Arrays.asList(3, 5);
        System.out.println(find(targetList3));
        List<Integer> targetList6 = Arrays.asList(5, 3);
        System.out.println(find(targetList6));
        List<Integer> targetList4 = Arrays.asList(2, 1);
        System.out.println(find(targetList4));
        List<Integer> targetList5 = Arrays.asList(3, 5, 5);
        System.out.println(find(targetList5));
    }
}