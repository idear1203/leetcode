package cn.idear.algorithm.unique_paths_ii;

import java.util.Arrays;

/**
 * Created by wangdongwei on 8/30/15.
 */
public class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        if(m == 0)
            return 0;
        int n = obstacleGrid[0].length;
        boolean meetObstacle = false;
        int[][] f = new int[m][n];
        for(int i = 0; i < m; i++)
            Arrays.fill(f[i], 0);
        /**
         * 如果只有一列，则只有一种走法。
         */
        for(int i = 0; i < m; i++) {
            if(!meetObstacle && obstacleGrid[m - 1 - i][n - 1] == 1)
                meetObstacle = true;
            f[i][0] = meetObstacle ? 0 : 1;
        }
        /**
         * 如果只有一行，则只有一种走法。
         */
        meetObstacle = false;
        for(int i = 0; i < n; i++) {
            if(!meetObstacle && obstacleGrid[m - 1][n - 1 - i] == 1)
                meetObstacle = true;
            f[0][i] = meetObstacle ? 0 : 1;
        }
        for(int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                /**
                 * 自身是坑。
                 */
                if(obstacleGrid[m - i - 1][n - j - 1] == 1)
                    f[i][j] = 0;
                /**
                 * 右侧下侧都是坑。
                 */
                else if(obstacleGrid[m - 1 - i + 1][n - 1 - j] == 1
                        && obstacleGrid[m - 1 - i][n - 1 - j + 1] == 1)
                    f[i][j] = 0;
                /**
                 * 下侧是坑。
                 */
                else if(obstacleGrid[m - 1 - i + 1][n - 1 - j] == 1)
                    f[i][j] = f[i][j - 1];
                /**
                 * 右侧是坑。
                 */
                else if(obstacleGrid[m - 1 - i][n - 1 - j + 1] == 1)
                    f[i][j] = f[i - 1][j];
                /**
                 * 没有坑。
                 */
                else
                    f[i][j] = f[i - 1][j] + f[i][j - 1];
            }
        }
        return f[m - 1][n - 1];
    }
}
