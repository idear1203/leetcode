package cn.idear.algorithm.spiral_matrix;

import java.util.ArrayList;
import java.util.List;

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

    public List<Integer> spiralOrder(int[][] matrix) {
        Direction[] directions = new Direction[]{Direction.EAST, Direction.SOUTH, Direction.WEST, Direction.NORTH};
        List<Integer> result = new ArrayList<>();
        int n = matrix.length;
        if(n == 0)
            return result;
        int m = matrix[0].length;
        Direction direction = directions[0];
        int index = 0;
        int sx = 0, ex = n - 1;
        int sy = 0, ey = m - 1;
        while(sx <= ex && sy <= ey) {
            switch (direction) {
                case EAST:
                    for (int i = sy; i <= ey; i++)
                        result.add(matrix[sx][i]);
                    sx++;
                    break;

                case SOUTH:
                    for (int i = sx; i <= ex; i++)
                        result.add(matrix[i][ey]);
                    ey--;
                    break;

                case WEST:
                    for(int i = ey; i >= sy; i--)
                        result.add(matrix[ex][i]);
                    ex--;
                    break;

                case NORTH:
                    for(int i = ex; i >= sx; i--)
                        result.add(matrix[i][sy]);
                    sy++;
                    break;
            }
            index = (index + 1) % 4;
            direction = directions[index];
        }
        return result;
    }
}
