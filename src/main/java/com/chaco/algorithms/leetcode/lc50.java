package com.chaco.algorithms.leetcode;

public class lc50 {
    public static double myPow(double x, int n) {
        double ans=1d;
        long pow=n;//指数
        if(n<0) {
            pow = -pow;
            x=1/x;//3^-1
        }
        double temp = 1d;
        while(pow>0) {
            if((pow&1)==1) {//奇数
                ans=temp*ans;
            }
            temp *= x;//累乘
            //pow / 2. 位运算速度快
            pow>>=1;
        }
        return ans;
    }

    public static void main(String[] args) {
        double v = myPow(2, 10);
        System.out.println("=================="+v);
    }
}
