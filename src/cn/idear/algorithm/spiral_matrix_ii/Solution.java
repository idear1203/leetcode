package cn.idear.algorithm.spiral_matrix_ii;

import java.util.Arrays;

/**
 * Created by wangdongwei on 8/29/15.
 */
public class Solution {
    private enum Direction{
        EAST,
        SOUTH,
        WEST,
        NORTH,
    }

    public int[][] generateMatrix(int n) {
        Direction[] directions = new Direction[]{Direction.EAST, Direction.SOUTH, Direction.WEST, Direction.NORTH};
        int[][] matrix = new int[n][n];
        int end = (int) Math.pow(n, 2);
        int num = 1;
        int sx = 0, ex = n - 1;
        int sy = 0, ey = n - 1;
        for(int index = 0; num <= end; index = (index + 1) % 4) {
            switch (directions[index]) {
                case EAST:
                    for (int i = sy; i <= ey; i++)
                        matrix[sx][i] = num++;
                    sx++;
                    break;

                case SOUTH:
                    for (int i = sx; i <= ex; i++)
                        matrix[i][ey] = num++;
                    ey--;
                    break;

                case WEST:
                    for(int i = ey; i >= sy; i--)
                        matrix[ex][i] = num++;
                    ex--;
                    break;

                case NORTH:
                    for(int i = ex; i >= sx; i--)
                        matrix[i][sy] = num++;
                    sy++;
                    break;
            }
        }
        return matrix;
    }
}
