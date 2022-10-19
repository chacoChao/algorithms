package com.chaco.algorithms.amazon;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Result {
    /*
     * Complete the 'numberOfItems' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts following parameters:
     *  1. STRING s
     *  2. INTEGER_ARRAY startIndices
     *  3. INTEGER_ARRAY endIndices
     */

    public static List<Integer> numberOfItems(String s, List<Integer> startIndices, List<Integer> endIndices) {
        // Write your code here
        return null;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s = bufferedReader.readLine();

        int startIndicesCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> startIndices = new ArrayList<>();

        for (int i = 0; i < startIndicesCount; i++) {
            int startIndicesItem = Integer.parseInt(bufferedReader.readLine().trim());
            startIndices.add(startIndicesItem);
        }

        int endIndicesCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> endIndices = new ArrayList<>();

        for (int i = 0; i < endIndicesCount; i++) {
            int endIndicesItem = Integer.parseInt(bufferedReader.readLine().trim());
            endIndices.add(endIndicesItem);
        }

        List<Integer> result = Result.numberOfItems(s, startIndices, endIndices);

        for (int i = 0; i < result.size(); i++) {
            bufferedWriter.write(String.valueOf(result.get(i)));

            if (i != result.size() - 1) {
                bufferedWriter.write("\n");
            }
        }

        bufferedWriter.newLine();
        bufferedReader.close();
        bufferedWriter.close();
    }
}