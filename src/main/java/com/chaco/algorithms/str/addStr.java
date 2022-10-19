package com.chaco.algorithms.str;

/**
 * https://leetcode.cn/problems/add-strings/
 */
public class addStr {
    public static void main(String[] args) {
        String sum = addStr.addStrings("123", "11");
        System.out.println("========" + sum);
    }

    public static String addStrings(String num1, String num2) {
        int i = num1.length() - 1, j = num2.length() - 1;
        int needPlus = 0;
        StringBuilder sb = new StringBuilder();
        while (i >= 0 || j >= 0) {
            int tmp1 = i >= 0 ? num1.charAt(i) - '0' : 0;
            int tmp2 = j >= 0 ? num2.charAt(j) - '0' : 0;
            int tmp = tmp1 + tmp2 + needPlus;
            sb.append(tmp % 10);
            needPlus = tmp / 10;
            i--;
            j--;
        }
        if (needPlus > 0) {
            sb.append(1);
        }
        return sb.reverse().toString();
    }
}
