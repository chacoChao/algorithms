package com.chaco.chao.algorithms.fibonacci;

import org.junit.jupiter.api.Test;

/**
 * author:zhaopeiyan001
 * Date:2020-04-21 18:23
 */
public class jumpFloor {
    /**
     * 一只青蛙一次可以跳上1级台阶，也可以跳上2级。
     * 求该青蛙跳上一个n级的台阶总共有多少种跳法（先后次序不同算不同的结果）。
     */
    /**
     * 1、递归思想
     * 2、fibonacci数列思路
     */
    public int JumpFloor(int target) {
        if (target == 1) {
            return 1;
        }
        if (target == 2) {
            return 2;
        }
        if (target > 2) {
            return JumpFloor(target - 2) + JumpFloor(target - 1);
        }
        return 0;
    }

    @Test
    public void testJumpFloor() {
        int i = this.JumpFloor(39);
        System.out.println(i);
    }

    /**
     * 一只青蛙一次可以跳上1级台阶，也可以跳上2级……它也可以跳上n级。求该青蛙跳上一个n级的台阶总共有多少种跳法。
     * 变态跳台阶
     * 动态规划思路
     */
    public int JumpFloor1(int target) {
        if (target < 0) {
            return 0;
        }
        if (target == 1) {
            return 1;
        }
        return 2<<(target - 2);
    }

}
