package cn.idear.algorithm.unique_paths_ii;

import java.util.Arrays;

/**
 * Created by wangdongwei on 8/30/15.
 */
public class Solution {
    /**
     * (x1, y1) 到 (x2, y2)的距离与(x2, y2)到(x1, y1)距离相同。
     * @param obstacleGrid
     * @return
     */
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        if(m == 0)
            return 0;
        int n = obstacleGrid[0].length;
        /**
         * 起点终点有坑。
         */
        if(obstacleGrid[0][0] == 1 || obstacleGrid[m - 1][n - 1] == 1)
            return 0;
        /**
         * WA: case {{0}}
         */
        obstacleGrid[0][0] = 1;
        boolean meetObstacle = false;
        for(int i = 1; i < m; i++) {
            if (!meetObstacle && obstacleGrid[i][0] == 1)
                meetObstacle = true;
            obstacleGrid[i][0] = meetObstacle ? 0 : 1;
        }
        meetObstacle = false;
        for(int j = 1; j < n; j++){
            if(!meetObstacle && obstacleGrid[0][j] == 1)
                meetObstacle = true;
            obstacleGrid[0][j] = meetObstacle ? 0 : 1;
        }
        for(int i = 1; i < m; i++){
            for(int j = 1; j < n; j++){
                if(obstacleGrid[i][j] == 1)
                    obstacleGrid[i][j] = 0;
                else
                    obstacleGrid[i][j] = obstacleGrid[i - 1][j] + obstacleGrid[i][j - 1];
            }
        }
        return obstacleGrid[m - 1][n - 1];
    }

    public int uniquePathsWithObstacles1(int[][] obstacleGrid) {
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
