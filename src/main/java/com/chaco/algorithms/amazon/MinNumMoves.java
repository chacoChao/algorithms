package com.chaco.algorithms.amazon;

import java.io.*;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

import static com.chaco.algorithms.amazon.MinNumMoves.GetMinNumMoves;
import static java.util.stream.Collectors.toList;

public class MinNumMoves {
    //https://www.geeksforgeeks.org/count-minimum-number-of-moves-to-front-or-end-to-sort-an-array/
    public static int GetMinNumMoves(List<Integer> blocks) {
        // Write your code here
        int[] arr = blocks.stream().filter(integer -> integer != null).mapToInt(i -> i).toArray();
        int brr[] = new int[blocks.size()];
        for (int i = 0; i < arr.length; i++) {
            brr[i] = arr[i];
        }
        Arrays.sort(brr);
        if (arr.equals(brr)) {
            return 0;
        } else {
            return (minOperations(
                    arr, brr, 0, 0));
        }
    }

    static int minOperations(int arr1[], int arr2[], int i, int j) {
        if (arr1.equals(arr2)) {
            return 0;
        }
        if (i >= arr1.length || j >= arr2.length) {
            return 0;
        }
        if (arr1[i] < arr2[j]) {
            return 1 + minOperations(arr1, arr2, i + 1, j + 1);
        } else {
            return Math.max(
                    minOperations(arr1, arr2, i, j + 1),
                    minOperations(arr1, arr2, i + 1, j));
        }
    }

}

class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int blocksCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> blocks = IntStream.range(0, blocksCount).mapToObj(i -> {
                    try {
                        return bufferedReader.readLine().replaceAll("\\s+$", "");
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    }
                })
                .map(String::trim)
                .map(Integer::parseInt)
                .collect(toList());

        int result = GetMinNumMoves(blocks);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }


    //    https://doocs.github.io/leetcode/lc/2263/
    public static int getMinNumMoves1(List<Integer> blocks) {
        // Write your code here
        int[] nums = blocks.stream().filter(integer -> integer != null).mapToInt(i -> i).toArray();
        return Math.min(solve(nums), solve(reverse(nums)));

    }

    public static int solve(int[] nums) {
        int n = nums.length;
        int[][] f = new int[n + 1][1001];
        for (int i = 1; i <= n; ++i) {
            int mi = 1 << 30;
            for (int j = 0; j <= 1000; ++j) {
                mi = Math.min(mi, f[i - 1][j]);
                f[i][j] = mi + Math.abs(j - nums[i - 1]);
            }
        }
        int ans = 1 << 30;
        for (int x : f[n]) {
            ans = Math.min(ans, x);
        }
        return ans;
    }

    // public int covertArray(int[] nums ) {
//     return Math.min(solve(nums), sovle(reverse(nums)));
// }
    public static int[] reverse(int[] nums) {
        for (int i = 0, j = nums.length - 1; i < j; ++i, --j) {
            int t = nums[i];
            nums[i] = nums[j];
            nums[j] = t;
        }
        return nums;
    }
}


