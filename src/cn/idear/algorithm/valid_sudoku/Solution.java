package cn.idear.algorithm.valid_sudoku;

import java.util.Arrays;

/**
 * Created by wangdongwei on 8/27/15.
 * Determine if a Sudoku is valid, according to: Sudoku Puzzles - The Rules.

 The Sudoku board could be partially filled, where empty cells are filled with the character '.'.
 */
public class Solution {
    public boolean isValidSudoku(char[][] board) {
        /**
         * 检查每一行
         */
        for(int i = 0; i < board.length; i++){
            if(!check(board[i])) //check every line;
                return false;
        }

        /**
         * 检查每一列
         */
        for(int i = 0; i < board.length; i++){
            char[] array = new char[board.length];
            for(int j = 0; j < board.length; j++){
                array[j] = board[j][i];
            }
            if(!check(array))
                return false;
        }

        /**
         * 检查每个格子
         */
        for(int i = 0; i < 3; i++){
            for( int j = 0; j < 3; j++){
                char[] array = new char[board.length];
                int s = 0;
                for(int k = 0; k < 3; k++){
                    for(int l = 0; l < 3; l++){
                        array[s++] = board[i * 3 + k][j * 3 + l];
                    }
                }
                if(!check(array))
                    return false;
            }
        }
        return true;
    }

    /**
     * 效率比较好。
     * @param array
     * @return
     */
    private boolean check(char[] array) {
        boolean[] used = new boolean[10];
        Arrays.fill(used, false);
        for(int i = 0; i < 9; i++){
            if(Character.isDigit(array[i])){
                if(array[i] == '0')
                    return false;
                if(used[array[i] - '0'])
                    return false;
                used[array[i] - '0'] = true;
            }
        }
        return true;
    }
    private boolean check1(char[] array) {
        /**
         * 这里出错，注意sort使用时会改变原数组内容！
         */
        char[] newArray = Arrays.copyOfRange(array, 0, array.length);
        Arrays.sort(newArray);
        for(int i = 0; i < 9; i++){
            if(Character.isDigit(newArray[i])){
                if(i > 0 && newArray[i] == newArray[i - 1])
                    return false;
                if(newArray[i] == '0')
                    return false;
            }
        }
        return true;
    }
}
