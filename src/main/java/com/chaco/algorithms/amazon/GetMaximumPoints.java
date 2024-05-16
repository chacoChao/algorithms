package com.chaco.algorithms.amazon;

import java.util.ArrayList;
import java.util.List;

/**
 * https://zhuanlan.zhihu.com/p/697473736
 */
public class GetMaximumPoints {
    public static long getMaximumPoints(List<Integer> days, int k) {
        int totalDays = days.stream().mapToInt(Integer::intValue).sum(); // 计算所有天数的总和
        long maxPoints = 0;

        // 用于存储前 k 天的点数的数组，用于计算重叠的总和
        int[] kDaysSum = new int[k];
        int currentDaySum = 0; // 当前 k 天的点数总和
        int count = 0; // 当前已经计算的天数
        int arrayIndex = 0; // 用于循环使用数组 kDaysSum 的索引

        // 第一遍：重复计算前 k 天的点数和
        for (int dayValue : days) {
            for (int day = 1; day <= dayValue && count < k; day++) {
                currentDaySum += day;
                kDaysSum[arrayIndex++] = day;
                if (arrayIndex == k) arrayIndex = 0;
                count++;
            }
        }
        maxPoints = currentDaySum; // 初始化最大点数

        // 处理剩余的天数，通过滑动窗口
        int startIndex = 0, endIndex = k - 1;
        for (int i = 0; i < totalDays - k; i++) {
            currentDaySum -= kDaysSum[startIndex]; // 减去窗口最前面一天的点数
            kDaysSum[startIndex] = kDaysSum[endIndex] + 1; // 更新窗口最后一天的点数
            currentDaySum += kDaysSum[startIndex]; // 加上更新后的点数
            maxPoints = Math.max(maxPoints, currentDaySum); // 更新最大点数

            startIndex++; // 滑动窗口起点后移
            endIndex++; // 滑动窗口终点后移
            if (startIndex == k) startIndex = 0;
            if (endIndex == k) endIndex = 0;
        }

        return maxPoints;
    }

    public static void main(String[] args) {
        int size = 10000; // 测试天数为1万天
        List<Integer> days = new ArrayList<>(size);
        for (int i = 1; i <= size; i++) {
            days.add(i);
        }
        int k = 500; // 选择连续的500天

        long startTime = System.currentTimeMillis();
        long maxPoints = getMaximumPoints(days, k);
        long endTime = System.currentTimeMillis();

        System.out.println("Maximum Points: " + maxPoints);
        System.out.println("Time Taken: " + (endTime - startTime) + " ms");
    }

}
