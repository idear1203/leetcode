package cn.idear.algorithm.n_queens_ii;

import java.util.Arrays;

/**
 * Created by wangdongwei on 8/29/15.
 */
public class Solution {

    private int count = 0;

    public int totalNQueens(int n) {
        if(n == 0 || n == 2 || n == 3)
            return 0;
        else if(n == 1)
            return 1;
        else {
            char[][] board = new char[n][n];
            for(int i = 0; i < n; i++)
                Arrays.fill(board[i], '.');
            return totalNQueensHelper(board, n, 0);
        }
    }

    private int totalNQueensHelper(char[][] board, int n, int i) {
        if(i == n)
            count++;
        else{
            for(int j = 0; j < n; j++){
                if(check(board, i, j, n)) {
                    /**
                     * 如果某个格子可以放皇后则放之。
                     */
                    board[i][j] = 'Q';
                    totalNQueensHelper(board, n, i + 1);
                    board[i][j] = '.';
                }
            }
        }
        return count;
    }

    private boolean check(char[][] board, int i, int j, int n) {
        /**
         * 程序保证同一行无其他皇后。
         */
        /**
         * 检查同列没有其他皇后。
         */
        for(int k = 0; k < i; k++){
            if(board[k][j] == 'Q')
                return false;
        }
        /**
         * 检查主对角线没有其他皇后。
         * 直线方程为：y = -x + i + j;
         */
        for(int k = 0; k < i; k++){
            int y = -k + i + j;
            if(y < n && board[k][y] == 'Q')
                return false;
        }
        /**
         * 检查副对角线没有其他皇后。
         * 直线方程为: y = x + j - i;
         */
        for(int k = 0; k < i; k++){
            int y = k + j - i;
            if(y >= 0 && board[k][y] == 'Q')
                return false;
        }
        return true;
    }
}
