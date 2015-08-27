package cn.idear.algorithm.sudoku_solver;

import java.util.Arrays;

/**
 * Created by wangdongwei on 8/27/15.
 * Write a program to solve a Sudoku puzzle by filling the empty cells.

 Empty cells are indicated by the character '.'.

 You may assume that there will be only one unique solution.
 */
public class Solution {
    public void solveSudoku(char[][] board) {
        solveSudokuHelper(board);
    }
    private boolean solveSudokuHelper(char[][] board) {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] == '.') {
                    for (char k = '1'; k <= '9'; k++) {
                        board[i][j] = k;
                        if (isValid(board, i, j) && solveSudokuHelper(board))
                            return true;
                    }
                    board[i][j] = '.';
                    return false;
                }
            }
        }
        return true;
    }

    private boolean isValid(char[][] board, int i, int j) {
        if(!check(board[i], board[i][j]))
            return false;
        char[] array = new char[9];
        for(int k = 0; k < 9; k++)
            array[k] = board[k][j];
        if(!check(array, board[i][j]))
            return false;
        int x = i / 3;
        int y = j / 3;
        int s = 0;
        for(int k = 0; k < 3; k++){
            for(int l = 0; l < 3; l++){
                array[s++] = board[3 * x + k][3 * y + l];
            }
        }
        if(!check(array, board[i][j]))
            return false;
        return true;
    }

    private boolean check(char[] array, char pivot) {
        int cnt = 0;
        for(int i = 0; i < 9; i++)
            if(array[i] == pivot)
                cnt ++;
//        boolean[] isUsed = new boolean[10];
//        Arrays.fill(isUsed, false);
//        for(int i = 0; i < 9; i++){
//           if(Character.isDigit(array[i])) {
//               if(isUsed[array[i] - '0'])
//                   return false;
//               isUsed[array[i] - '0'] = true;
//           }
//        }
        return cnt == 1;
    }
}
