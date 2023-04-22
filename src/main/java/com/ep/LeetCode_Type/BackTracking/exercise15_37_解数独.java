package com.ep.LeetCode_Type.BackTracking;

/***
 * @author dep
 * @version 1.0
 * @date 2023-04-22 9:27
 */
public class exercise15_37_解数独 {

    public static void solveSudoku(char[][] board) {
        backTracking(board);
    }

    public static Boolean backTracking(char[][] board) {
        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[0].length; col++) {
                if (board[row][col] != '.') continue;
                for (char i = '1'; i <= '9'; i++) {
                    if (isValid(row,col,i,board)) {
                        board[row][col] = i;
                        Boolean aBoolean = backTracking(board);
                        if (aBoolean) {
                            return true;
                        }
                        board[row][col] = '.';
                    }
                }
                return false; // 9个数都试完了，都不行，那么就返回false
            }
        }
        return true;
    }

    /***
     * 判断棋盘是否重复：1.同行是否重复，2.同列是否重复，3.九宫格是否重复
     * @param row
     * @param col
     * @param val
     * @param board
     * @return
     */
    public static boolean isValid (int row, int col, char val, char[][] board) {
        // 同行是否重复
        for (int i = 0; i < 9; i++) {
            if (board[row][i] == val) {
                return false;
            }
        }
        // 同列是否重复
        for (int i = 0; i < 9; i++) {
            if (board[i][col] == val) {
                return false;
            }
        }
        // 9宫格是否重复
        // 第一九宫格 （0,1,2）
        // 第二九宫格 （3,4,5）
        // 第三九宫格 （6,7,8）
        int startRow = (row / 3) * 3;
        int startCol = (col / 3) * 3;
        for (int i = startRow; i < startRow + 3; i++) {
            for (int j = startCol; j < startCol + 3; j++) {
                if (board[i][j] == val) {
                    return false;
                }
            }
        }
        return true;
    }

}
