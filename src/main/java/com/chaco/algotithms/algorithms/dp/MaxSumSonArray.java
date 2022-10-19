package com.chaco.chao.algorithms.dp;

/**
 * 2022-05-16字节-客服中台一面算法
 * 输出累加和最大的子串
 * 时间复杂度O(n)
 */
public class MaxSumSonArray {

    public static void main(String[] args) {
        int[] nums = new int[]{1, -2, 3, 10, -4, 7, 2, -5};
        int[] ints = MaxSumSonArray.maxSonArray(nums);
        System.out.println("++++++++++" + ints);
    }


    public static int[] maxSonArray(int[] nums) {
        int length = nums.length;
        int[][] dp = new int[length][3];
        int now = nums[length - 1], max = nums[length - 1];
        int end = length - 1;
        int flag = 0;
        for (int i = length - 1; i >= 0; i--) {
            //遍历到最后一个元素
            if (0 == i) {
                if (nums[i] <= 0) {
                    if (now > max) {
                        max = now;
                        dp[flag][0] = i + 1;
                        dp[flag][1] = end;
                        dp[flag][2] = max;
                        flag++;
                    }
                } else {
                    now = now + nums[i];
                    if (now > max) {
                        max = now;
                        dp[flag][0] = i;
                        dp[flag][1] = end;
                        dp[flag][2] = max;
                        flag++;
                    }
                }
            }

            if (nums[i] > 0) {
                now = now + nums[i];
                continue;
            } else {
                if (now > max) {
                    max = now;
                    dp[flag][0] = i + 1;
                    dp[flag][1] = end;
                    dp[flag][2] = max;
                    flag++;
                }
                now = now + nums[i];
                if (now <= 0) {
                    now = 0;
                    end = i - 1;
                } else {
                    continue;
                }
            }
        }

        int resMax = dp[0][2];
        int resFlag = 0;
        for (int i = 0; i < flag; i++) {
            if (dp[i][2] > resMax) {
                resFlag = i;
                resMax = dp[i][2];
            }
        }
        int startPos = dp[resFlag][0];
        int endPos = dp[resFlag][1];
        int maxVal = dp[resFlag][2];
        System.out.println("========" + startPos);
        System.out.println("========" + endPos);
        System.out.println("========" + maxVal);
        int[] result = new int[endPos - startPos + 1];
        for (int i = 0; i < result.length; i++) {
            result[i] = nums[i+startPos];
        }
        return result;
    }
}
