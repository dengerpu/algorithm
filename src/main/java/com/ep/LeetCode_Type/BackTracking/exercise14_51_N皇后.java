package com.ep.LeetCode_Type.BackTracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/***
 * @author dep
 * @version 1.0
 * @date 2023-04-20 10:16
 */
public class exercise14_51_N皇后 {
    static List<List<String>> res = new LinkedList<>();
    public static List<List<String>> solveNQueens(int n) {
        char[][] chessboard = new char[n][n];
        for (char[] c :chessboard) {
            Arrays.fill(c, '.');
        }
        backTracking(0, n, chessboard);
        return res;
    }
    public static void backTracking(int row, int n, char[][] chessboard) {
        if (row == n) {
            res.add(ArrayToList(chessboard));
            return;
        }
        for (int col = 0; col < n; col++) { // 代表列
            if (isValid(row, col, n, chessboard)) {
                chessboard[row][col] = 'Q';
                backTracking(row + 1, n, chessboard);
                chessboard[row][col] = '.';
            }
        }
    }

    public static List ArrayToList(char[][] chessboard) {
        ArrayList<String> list = new ArrayList<>();
        for (char[] c: chessboard) {
            list.add(String.valueOf(c));
        }
        return list;
    }

    // 检查是否合法
    public static boolean isValid(int row, int col, int n, char[][] chessboard) {
        // 检查列
        for (int i = 0; i < row; i++) {
            if (chessboard[i][col] == 'Q') {
                return false;
            }
        }
        // 检查45度对角线
        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0 ; i--, j--) {
            if (chessboard[i][j] == 'Q') {
                return false;
            }
        }
        // 检查135度对角线
        for (int i = row - 1, j = col + 1; i >= 0 && j <= n - 1; i--, j++) {
            if (chessboard[i][j] == 'Q') {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(solveNQueens(1));
    }
}
