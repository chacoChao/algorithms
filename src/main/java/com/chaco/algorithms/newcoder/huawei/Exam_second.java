package com.chaco.algorithms.newcoder.huawei;

import java.util.Scanner;

public class Exam_second {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String[] split = in.nextLine().split(" ");
        int[] vals = new int[split.length];
        for (int i = 0; i < split.length; i++) {
            vals[i] = Integer.parseInt(split[i]);
        }
        Integer target = in.nextInt();
        Integer max = Exam_second.pVal(split.length, vals, target);
        System.out.print(max);
    }

    public static int pVal(int n, int[] values, int target) {
        int[][] dp = new int[n+1][2];
        //1拿0不拿
        for (int i = 1; i <= n; i++) {
            if (dp[i][1] + values[i-1] < target) {
                dp[i][1] = Math.max(dp[i][1], dp[i-1][1] + values[i-1]);
            }
        }
        return dp[n][1];
    }
}
