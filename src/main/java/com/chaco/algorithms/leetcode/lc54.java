package com.chaco.algorithms.leetcode;

import java.util.ArrayList;
import java.util.List;

public class lc54 {

    public static void main(String[] args) {
        int[][] a = new int[][] {{1,2,3},{4,5,6},{7,8,9}};
        List<Integer> integers = spiralOrder(a);
        System.out.printf("===============" + integers);
    }

    public static List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> list = new ArrayList<>();
        if (null == matrix || matrix.length == 0
                || matrix[0].length == 0) {
            return list;
        }
        int t = 0;//横层
        int b = matrix.length - 1;
        int l = 0;//竖层
        int r = matrix[0].length - 1;
        //矩阵M*N
        int nums = matrix.length * matrix[0].length;
        while (nums > 0) {
            // 从左往右
            for (int i = l; i <= r && nums > 0; i++) {
                list.add(matrix[t][i]);
                nums--;
            }
            t++;
            //从上往下
            for (int i = t; i <= b && nums > 0; i++) {
                list.add(matrix[i][r]);
                nums--;
            }
            r--;
            //从右往左
            for (int i = r; i >= l && nums > 0; i--) {
                list.add(matrix[b][i]);
                nums--;
            }
            b--;
            //从下往上
            for (int i = b; i >= t && nums > 0; i--) {
                list.add(matrix[i][l]);
                nums--;
            }
            l++;
        }
        return list;
    }
}
