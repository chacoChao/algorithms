package com.chaco.algorithms.other;

/**
 * https://www.nowcoder.com/practice/59ac416b4b944300b617d4f7f111b215
 * 写一个函数，求两个整数之和，要求在函数体内不得使用+、-、*、/四则运算符号。
 */
public class Add {
    public static void main(String[] args) {
        System.out.println("Add.main");
    }

    public int Add(int num1, int num2) {
        while (num2 != 0) {
            //进位。即二进制与，再左移
            int carry = (num1 & num2) << 1;
            //直接相加，不考虑进位。即二进制异或操作
            num1 = num1 ^ num2;
            //num2作为进位
            num2 = carry;
        }
        return num1;
    }
}