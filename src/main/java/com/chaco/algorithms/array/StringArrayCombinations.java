package com.chaco.algorithms.array;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class StringArrayCombinations {
    public static void main(String[] args) {
        String[] input = {"Infinity", "8", "Ball", "Pool", "King"};
        List<String> result = new ArrayList<>();
        Set<String> set = new HashSet<>();

        generateCombinations(input, 0, new StringBuilder(), result, set);

        for (String combination : result) {
            System.out.println(combination);
        }
    }

    public static void generateCombinations(String[] input, int index, StringBuilder current, List<String> result, Set<String> set) {
        if (index == input.length) {
            String combination = current.toString();
            if (!set.contains(combination)) {
                result.add(combination);
                set.add(combination);
            }
            return;
        }

        // Include current element
        current.append(input[index]);
        generateCombinations(input, index + 1, current, result, set);
        current.delete(current.length() - input[index].length(), current.length());

        // Exclude current element
        generateCombinations(input, index + 1, current, result, set);
    }
}
