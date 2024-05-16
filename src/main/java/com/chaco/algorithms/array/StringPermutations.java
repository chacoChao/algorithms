package com.chaco.algorithms.array;

import java.util.ArrayList;
import java.util.List;

public class StringPermutations {
    public static void main(String[] args) {
        String input = "Infinity 8 Ball Pool King";
        List<String> permutations = generatePermutations(input);

        for (String permutation : permutations) {
            System.out.println(permutation);
        }
    }

    public static List<String> generatePermutations(String input) {
        List<String> result = new ArrayList<>();
        generate("", input, result);
        return result;
    }

    public static void generate(String prefix, String remaining, List<String> result) {
        int n = remaining.length();
        if (n == 0) {
            result.add(prefix);
        } else {
            for (int i = 0; i < n; i++) {
                generate(prefix + remaining.charAt(i), remaining.substring(0, i) + remaining.substring(i + 1, n), result);
            }
        }
    }
}
