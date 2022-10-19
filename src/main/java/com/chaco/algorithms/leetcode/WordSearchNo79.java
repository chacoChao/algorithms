package com.chaco.algorithms.leetcode;

import java.math.BigDecimal;
import java.util.Arrays;

/**
 * 给定一个m x n 二维字符网格board 和一个字符串单词word 。
 * 如果word 存在于网格中，返回 true ；否则，返回 false 。
 * <p>
 * 单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。
 * 同一个单元格内的字母不允许被重复使用。
 *
 * @author zhaopeiyan
 * @date 2022/3/4 11:42 AM
 */
public class WordSearchNo79 {

    public static boolean exist(char[][] board, String word) {
        boolean exist = false;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                char[][] used = new char[board.length][board[i].length];
                exist = dfs(board, word, i, j, used);
                if (exist) {
                    System.out.println("i={" + i + "},j={" + j + "}");
                    return exist;
                }
            }
        }
        System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++");
        return exist;
    }

    public static boolean dfs(char[][] board, String words, int n, int m, char[][] used) {
        boolean exist = false;
        if (0 == words.toCharArray().length) {
            return true;
        }
        if (n < 0 || n == board.length) {
            return false;
        }
        if (m < 0 || m == board[n].length) {
            return false;
        }
        if (used[n][m] == 1) {
            return false;
        }
        if (board[n][m] == words.charAt(0)) {
            used[n][m] = 1;
            System.out.println("dfs=====>>n=" + n + ",m=" + m + "word=" + words + "used=" + Arrays.deepToString(used));
            exist = dfs(board, words.substring(1), n - 1, m, used) || dfs(board, words.substring(1), n, m + 1, used)
                    || dfs(board, words.substring(1), n, m - 1, used) || dfs(board, words.substring(1), n + 1, m, used);
            used[n][m] = 0;
        }
        return exist;
    }

    public static void main(String[] args) {
        BigDecimal bigDecimal = new BigDecimal("639247270024785261");
        BigDecimal divide = bigDecimal.divide(new BigDecimal("1024"));
        System.out.println(divide);
        char[][] board = {
                {'a', 'b', 'c', 'd', 'e'},
                {'b', 'g', 'h', 'i', 'j'},
                {'b', 'p', 'q', 'r', 's'},
                {'t', 'u', 'v', 'w', 'x'}};
        String word = "cdijsrwv";
        boolean exist = WordSearchNo79.exist(board, word);
        System.out.println(exist);

        String word1 = "c";
        boolean exist1 = WordSearchNo79.exist(board, word1);
        System.out.println(exist1);

        String word2 = "dijscrwv";
        boolean exist2 = WordSearchNo79.exist(board, word2);
        System.out.println(exist2);

        String word3 = "did";
        boolean exist3 = WordSearchNo79.exist(board, word3);
        System.out.println(exist3);

        String word4 = "bgb";
        boolean exist4 = WordSearchNo79.exist(board, word4);
        System.out.println(exist4);

        char[][] aab = {
                {'C', 'A', 'A'},
                {'A', 'A', 'A'},
                {'B', 'C', 'D'}};
        String w = "AAB";
        boolean exist5 = WordSearchNo79.exist(aab, w);
        System.out.println(exist5);

        char[][] bba = {
                {'A', 'B', 'C', 'E'},
                {'S', 'F', 'E', 'S'},
                {'A', 'D', 'E', 'E'}};
        String w1 = "ABCESEEEFS";
        boolean exist6 = WordSearchNo79.exist(bba, w1);
        System.out.println(exist6);

        char[][] aaa = {
                {'a', 'a', 'a', 'a'},
                {'a', 'a', 'a', 'a'},
                {'a', 'a', 'a', 'a'}};
        String w2 = "aaaaaaaaaaaaa";
        boolean exist7 = WordSearchNo79.exist(aaa, w2);
        System.out.println(exist7);
    }


    /**
     * DFS模板
     * int check(参数)
     *     {
     *         if(满足条件)
     *             return 1;
     *         return 0;
     *     }
     *
     *     void dfs(int step)
     *     {
     *         判断边界
     *         {
     *             相应操作
     *         }
     *         尝试每一种可能
     *         {
     *             满足check条件
     *                     标记
     *             继续下一步dfs(step+1)
     *             恢复初始状态（回溯的时候要用到）
     *         }
     *     }
     */

}
