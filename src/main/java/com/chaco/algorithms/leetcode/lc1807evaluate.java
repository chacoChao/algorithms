package com.chaco.algorithms.leetcode;

import java.util.*;

/**
 * @link https://leetcode.cn/problems/evaluate-the-bracket-pairs-of-a-string/
 * 给你一个字符串 s ，它包含一些括号对，每个括号中包含一个非空的键。
 * 比方说，字符串 "(name)is(age)yearsold" 中，有 两个 括号对，分别包含键 "name" 和 "age" 。
 * 你知道许多键对应的值，这些关系由二维字符串数组 knowledge 表示，
 * 其中 knowledge[i] = [keyi, valuei] ，表示键 keyi 对应的值为 valuei 。
 * 你需要替换所有的括号对。当你替换一个括号对，且它包含的键为 keyi 时，你需要：
 * 将 keyi 和括号用对应的值 valuei 替换。
 * 如果从 knowledge 中无法得知某个键对应的值，你需要将 keyi 和括号用问号 "?" 替换（不需要引号）。
 * knowledge 中每个键最多只会出现一次。s中不会有嵌套的括号。
 * 请你返回替换所有括号对后的结果字符串。
 * <p>
 * example
 * 输入：s = "(name)is(age)yearsold", knowledge = [["name","bob"],["age","two"]]
 * 输出："bobistwoyearsold"
 */
public class lc1807evaluate {
    public static String evaluate(String s, List<List<String>> knowledge) {
        Map<String, String> matched = new LinkedHashMap<>();
        for (List<String> l : knowledge) {
            matched.put(l.get(0), l.get(1));
        }
        StringBuilder res = new StringBuilder();
        StringBuilder key = new StringBuilder();
        int keyCount = 0;

        char[] chars = s.toCharArray();
        for (Character c : chars) {
            if ('(' == c) {
                keyCount++;
            } else if (')' == c) {
                keyCount--;
                res.append(matched.getOrDefault(key.toString(), "?"));
                key = new StringBuilder();
            } else if (keyCount > 0) {
                key.append(c);
            } else {
                res.append(c);
            }
        }
        return res.toString();
    }

    public static void main(String[] args) {
        String s = "(name)is(age)yearsold";
        List<List<String>> list = new LinkedList<>();
        List<String> inList = new LinkedList<>();
        inList.add("name");
        inList.add("bob");
        list.add(inList);
        List<String> inList2 = new LinkedList<>();
        inList2.add("age");
        inList2.add("two");
        list.add(inList2);
        String evaluate = lc1807evaluate.evaluate(s, list);
        System.out.println("lc1807evaluate.main" + evaluate);
    }
}