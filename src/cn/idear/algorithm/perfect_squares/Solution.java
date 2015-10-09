package cn.idear.algorithm.perfect_squares;

import java.util.Arrays;

/**
 * Created by idear on 15-10-10.
 */
public class Solution {
    /**
     * 动态规划
     * @param n
     * @return
     */
    public int numSquares(int n){
        int[] f = new int[n + 1];
        Arrays.fill(f, n);
        f[0] = 0;
        for(int i = 1; i <= n; i++){
            int min = i;
            for(int j = (int)Math.sqrt(i); j > 0; j--)
                min = Math.min(f[i - j * j] + 1, min);
            f[i] = min;
        }
        return f[n];
    }
//    public int numSquares(int n){
//        return numSquaresHelper(n, 0, n);
//    }
//
//    private int numSquaresHelper(int n, int cur, int min) {
//        if(n == 0 || cur >= min) return cur;
//        for(int i = (int)Math.sqrt(n); i > 0; i--)
//            min = Math.min(numSquaresHelper(n - i * i, cur + 1, min), min);
//        return min;
//    }
//    /**
//     * 递归
//     */
//    int[] f;
//
//    public int numSquares(int n) {
//        f = new int[n + 1];
//        Arrays.fill(f, -1);
//        return numSquaresHelper(n);
//    }
//
//    private int numSquaresHelper(int n){
//        int min = n;
//        int upper = (int)Math.sqrt(n);
//        for(int i = upper; i > 0; i--){
//            int index = n - i * i;
//            min = Math.min((f[index] == -1 ? numSquaresHelper(index) : f[index]) + 1, min);
//        }
//        return f[n] = min;
//    }
}
