package cn.idear.algorithm.unique_paths;

/**
 * Created by wangdongwei on 8/29/15.
 */
public class Solution {
    public int uniquePaths(int m, int n) {
        int[][] f = new int[m + 1][n + 1];
        /**
         * 如果只有一列，则只有一种走法。
         */
        for(int i = 1; i <= m; i++)
            f[i][1] = 1;
        /**
         * 如果只有一行，则只有一种走法。
         */
        for(int i = 1; i <= n; i++)
            f[1][i] = 1;
        for(int i = 2; i <= m; i++)
            for(int j = 2; j <= n; j++)
                f[i][j] = f[i - 1][j] + f[i][j - 1];
        return f[m][n];
    }
}
