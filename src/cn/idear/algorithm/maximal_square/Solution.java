package cn.idear.algorithm.maximal_square;

/**
 * Created by idear on 15-11-3.
 */
public class Solution {
    public int maximalSquare(char[][] matrix) {
        int m = matrix.length;
        if(m == 0) return 0;
        int n = matrix[0].length;
        int max = 0;
        /**
         * f用来记录右下角是(i,j)的矩形的最大宽度。
         * 则f(i,j) = min{f(i - 1, j), f(i, j - 1), f(i - 1, j - 1)} + 1;
         */
        int[][] f = new int[m][n];
        for(int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if(i == 0 || j == 0)
                    f[i][j] = matrix[i][j] - '0';
                else if(matrix[i][j] == '0')
                    f[i][j] = 0;
                else
                    f[i][j] = Math.min(f[i - 1][j], Math.min(f[i][j - 1], f[i - 1][j - 1])) + 1;
                max = Math.max(f[i][j], max);
            }
        }
        return max * max;
    }
}
