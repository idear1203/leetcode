package cn.idear.algorithm.n_queens;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by wangdongwei on 8/29/15.
 */
public class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> result = new ArrayList<>();
        if(n == 0 || n == 2 || n == 3)
            return result;
        char[][] board = new char[n][n];
        for(int i = 0; i < n; i++)
            Arrays.fill(board[i], '.');
        solveNQueensHelper(n, board, 0, result);
        return result;
    }

    private void solveNQueensHelper(int n, char[][] board, int i, List<List<String>> result) {
        if(i == n){
            /**
             * 说明走到了最后一行，转换结果并保存。
              */
            List<String> list = new ArrayList<>();
            for(int j = 0; j < n; j++)
                list.add(new String(board[j]));
            result.add(list);
            for(String str: list)
                System.out.println(str);
            System.out.println();
        }else{
            for(int j = 0; j < n; j++){
                if(check(board, i, j, n)) {
                    /**
                     * 如果某个格子可以放皇后则放之。
                     */
                    board[i][j] = 'Q';
                    solveNQueensHelper(n, board, i + 1, result);
                    board[i][j] = '.';
                }
            }
        }
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
