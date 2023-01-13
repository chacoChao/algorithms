package com.chaco.algorithms.array;

/**
 * 给定两个大小分别为 m 和 n 的正序（从小到大）数组nums1 和nums2。请你找出并返回这两个正序数组的 中位数 。
 * <p>
 * 算法的时间复杂度应该为 O(log (m+n)) 。
 *
 * @author zhaopeiyan
 * @link <a href="https://leetcode-cn.com/problems/median-of-two-sorted-arrays/">...</a>
 * {@code @date} 2021/12/20 4:51 PM
 * <p>
 * 输入：nums1 = [1,3], nums2 = [2]
 * 输出：2.00000
 * 解释：合并数组 = [1,2,3] ，中位数 2
 * 示例 2：
 * <p>
 * 输入：nums1 = [1,2], nums2 = [3,4]
 * 输出：2.50000
 * 解释：合并数组 = [1,2,3,4] ，中位数 (2 + 3) / 2 = 2.5
 */
public class FindMedianSortedArrays {
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int l1 = nums1.length, l2 = nums2.length;
        //处理奇偶数
        boolean isTwo = (l1 + l2) % 2 == 0;
        int lMid = (l1 + l2) / 2;

        //单数组为空处理
        if (l1 == 0) {
            return isTwo ? (nums2[lMid] + nums2[lMid - 1]) / 2d : nums2[lMid];
        }
        if (l2 == 0) {
            return isTwo ? (nums1[lMid] + nums1[lMid - 1]) / 2d : nums1[lMid];
        }

        int[] arr = new int[l1 + l2];
        int i = 0, j = 0, positionCusor = 0;
        while (true) {
            if (lMid < positionCusor - 1) {
                break;
            }
            if (j >= l2 && i >= l1) {
                break;
            }
            if (j >= l2) {
                arr[positionCusor] = nums1[i];
                positionCusor++;
                i++;
                continue;
            }
            if (i >= l1) {
                arr[positionCusor] = nums2[j];
                positionCusor++;
                j++;
                continue;
            }
            if (nums1[i] >= nums2[j]) {
                arr[positionCusor] = nums2[j];
                j++;
            } else if (nums1[i] < nums2[j]) {
                arr[positionCusor] = nums1[i];
                i++;
            }
            positionCusor++;
        }
        return isTwo ? (arr[lMid] + arr[lMid - 1]) / 2d : arr[lMid];
    }

    public static void main(String[] args) {
        double medianSortedArrays = FindMedianSortedArrays.findMedianSortedArrays(
            new int[]{}, new int[]{2, 3});

//        double medianSortedArrays = FindMedianSortedArrays.findMedianSortedArrays(
//                new int[]{1, 3}, new int[]{2});
//
//        double medianSortedArrays1 = FindMedianSortedArrays.findMedianSortedArrays(
//                new int[]{1, 2}, new int[]{3, 4});
//
//        double medianSortedArrays2 = FindMedianSortedArrays.findMedianSortedArrays(
//                new int[]{0, 0}, new int[]{0, 0});
//
//        double medianSortedArrays3 = FindMedianSortedArrays.findMedianSortedArrays(
//                new int[]{}, new int[]{1});
//
//        double medianSortedArrays4 = FindMedianSortedArrays.findMedianSortedArrays(
//                new int[]{2}, new int[]{});

        System.out.println(medianSortedArrays);
    }
}
