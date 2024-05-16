package com.chaco.algorithms.array;

import java.util.*;

public class combineStr {
    public static void main(String[] args) {
        combineStr combineStr = new combineStr();
        String[] input = {"Infinity", "8", "Ball", "Pool", "King"};
//        String[] strings = combineStr.permutation(input);
//        int count = 0;
//        for (String combination : strings) {
//            count++;
//            System.out.println(combination);
//        }
//        System.out.println(count);
//
        for (int i = 0; i < input.length; i++) {
            String[] strs1 = swapStrings(input, i);
            String[] strings = combineStr.permutation(strs1);
            int count = 0;
            for (String combination : strings) {
                count++;
                System.out.println(combination);
            }
            System.out.println("==================================" + count);
        }
    }

    private static String[] swapStrings(String[] input, int i) {
        String[] strs = new String[input.length - 1];
        for (int j = 0; j < input.length; j++) {
            if (i == j) {
                j++;
            }
            strs[j] = input[j];
        }
        return strs;
    }

    List<String> list = new ArrayList<>();

    public String[] permutation(String[] S) {
        permutate(S, 0);
        String[] res = new String[list.size()];
        for (int i = 0; i < res.length; i++) {
            res[i] = list.get(i);
        }
        return res;
    }

    public void permutate(String[] arr, int first) {
        if (first == arr.length - 1) {
            list.add(Arrays.stream(arr).map(Object::toString).reduce("", String::concat));
            return;
        }
        for (int i = first; i < arr.length; i++) {
            swap(arr, first, i);
            permutate(arr, first + 1);
            swap(arr, first, i);
        }
    }

    public void swap(String[] arr, int i, int j) {
        String temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void fizzBuzz(int n) {
// Write your code here
        for (int i = 1; i <= n; i++) {
            if (i % 3 == 0 && i % 5 == 0) {
                System.out.println("FizzBuzz");
            } else if (i % 3 == 0) {
                System.out.println("Fizz");
            } else if (i % 5 == 0) {
                System.out.println("Buzz");
            } else {
                System.out.println(i);
            }
        }
    }

}