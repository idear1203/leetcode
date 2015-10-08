package cn.idear.algorithm.number_of_islands;

import java.util.Stack;

/**
 * Created by wangdongwei on 10/1/15.
 */
public class Solution {

    private int m , n;

    private class Point{
        int x, y;
        Point(int x, int y){
            this.x = x;
            this.y = y;
        }
    }

    public int numIslands(char[][] grid) {
        if(grid.length == 0)
            return 0;
        m = grid.length;
        n = grid[0].length;
        int count = 0;
        Stack<Point> stack = new Stack<>();
        for(int i = 0; i < m; i++)
            for(int j = 0; j < n; j++)
                if(grid[i][j] == '1')
                    stack.push(new Point(i, j));
        while(!stack.isEmpty()){
            Point p = stack.pop();
            int x = p.x;
            int y = p.y;
            if(grid[x][y] == '1'){
                count++;
                /**
                 * 获取与之连成片的'1'，并改为'0'
                 */
                Stack<Point> s = new Stack<>();
                s.push(p);
                while(!s.isEmpty()){
                    Point point = s.pop();
                    int i = point.x;
                    int j = point.y;
                    if(isValidIsland(grid, i, j)){
                        grid[i][j] = '0';
                        /**
                         * 学习这种迭代方式
                         */
//                        for(Point pt : new Point[]{new Point(i, j + 1), new Point(i, j - 1),
//                            new Point(i + 1, j), new Point(i - 1, j)}){
                        for(int[] ij : new int[][]{{i, j + 1}, {i, j - 1}, {i + 1, j}, {i - 1, j}}){
                            s.push(new Point(ij[0], ij[1]));
                        }
                    }
                }
            }
        }
        return count;
    }

    private boolean isValidIsland(char[][] grid, int i, int j) {
        if(i < 0 || i > m - 1 || j < 0 || j > n - 1 || grid[i][j] != '1')
            return false;
        return true;
    }
}
