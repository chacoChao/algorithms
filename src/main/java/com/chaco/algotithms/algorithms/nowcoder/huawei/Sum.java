package com.chaco.chao.algorithms.nowcoder.huawei;

import java.util.Scanner;

public class Sum {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = Integer.parseInt(in.nextLine());
        int[][] dp = new int[n][3];
        int i = 0;
        while (i < n && in.hasNextLine()) {
            String s = in.nextLine();
            String[] split = s.split(" ");
            for (int j = 0; j < split.length; j++) {
                dp[i][j] = Integer.parseInt(split[j]);
            }
            i++;
        }
        int[][] res = new int[n][3];
        //初始化数组
        for (int l = 0; l < n; l++) {
            for (int j = 0; j < dp[l].length; j++) {
                res[l][j] = Math.min(dp[l][j], res[l][j] + dp[l][j]);
            }
        }
        System.out.println(res[n][3]);
    }
}
