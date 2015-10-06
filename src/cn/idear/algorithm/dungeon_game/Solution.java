package cn.idear.algorithm.dungeon_game;

/**
 * Created by wangdongwei on 10/6/15.
 */
public class Solution {
    public int calculateMinimumHP(int[][] dungeon) {
        int m = dungeon.length;
        int n = dungeon[0].length;
        int[][] f = new int[m][n];
        f[m - 1][n - 1] = Math.max(1 - dungeon[m - 1][n - 1], 1);
        for(int i = n - 2; i >= 0; i--)
            f[m - 1][i] = Math.max(f[m - 1][i + 1] - dungeon[m - 1][i], 1);
        for(int i = m - 2; i >= 0; i--)
            f[i][n - 1] = Math.max(f[i + 1][n - 1] - dungeon[i][n - 1], 1);
        for(int i = m - 2; i >= 0; i--)
            for(int j = n - 2; j >= 0; j--)
                f[i][j] = Math.max(Math.min(f[i + 1][j], f[i][j + 1]) - dungeon[i][j], 1);
        return Math.max(f[0][0], 1);
    }
}
