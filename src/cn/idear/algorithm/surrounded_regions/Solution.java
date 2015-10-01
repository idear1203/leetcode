package cn.idear.algorithm.surrounded_regions;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * Created by wangdongwei on 10/1/15.
 */
public class Solution {

    private int m, n;

    /**
     * 深度优先遍历
     * @param board
     */
    public void solve(char[][] board) {
        if(board.length == 0)
            return;
        m = board.length;
        n = board[0].length;
        /**
         * 由外向内进行深度优先遍历
         */
        for(int i = 0; i < m; i++){
            dfs(board, i, 0);
            dfs(board, i, n - 1);
        }
        for(int i = 1; i < n - 1; i++){
            dfs(board, 0, i);
            dfs(board, m - 1, i);
        }
        for(int i = 0; i < m; i++)
            for(int j = 0; j < n; j++)
                if(board[i][j] == 'W')
                    board[i][j] = 'O';
                else if(board[i][j] == 'O')
                    board[i][j] = 'X';
    }

    private void dfs(char[][] board, int x, int y) {
        if(isPointO(board, x, y)){
            Stack<Point> stack = new Stack<>();
            stack.push(new Point(x, y));
            while (!stack.isEmpty()){
                Point point = stack.pop();
                int i = point.x;
                int j = point.y;
                if(isPointO(board, i, j)){
                    board[i][j] = 'W';
                    for(int[] ij: new int[][]{{i, j + 1}, {i, j - 1}, {i + 1, j}, {i - 1, j}})
                        stack.push(new Point(ij[0], ij[1]));
                }
            }
        }
    }

    /**
     * 广度优先遍历
     * @param board
     */
    public void solve1(char[][] board) {
        if(board.length == 0)
            return;
        m = board.length;
        n = board[0].length;
        /**
         * 由外向内进行广度优先遍历
         */
        for(int i = 0; i < m; i++){
            bfs(board, i, 0);
            bfs(board, i, n - 1);
        }
        for(int i = 1; i < n - 1; i++){
            bfs(board, 0, i);
            bfs(board, m - 1, i);
        }
        for(int i = 0; i < m; i++)
            for(int j = 0; j < n; j++)
                if(board[i][j] == 'W')
                    board[i][j] = 'O';
                else if(board[i][j] == 'O')
                    board[i][j] = 'X';
    }

    private void bfs(char[][] board, int x, int y) {
        if(!isPointO(board, x, y))
            return;
        Queue<Point> queue = new LinkedList<>();
        queue.add(new Point(x, y));
        while(!queue.isEmpty()){
            Point point = queue.poll();
            int i = point.x;
            int j = point.y;
            if(isPointO(board, i, j)) {
                /**
                 * 学习这种trick。将元素改为某个不可能的值，既作为标记，又用于去除重复路径
                 */
                board[i][j] = 'W';
                for(int[] ij: new int[][]{{i, j + 1}, {i, j - 1}, {i + 1, j}, {i - 1, j}})
                    queue.add(new Point(ij[0], ij[1]));
            }
        }
    }

    private boolean isPointO(char[][] board, int x, int y){
        if(x < 0 || x > m - 1 || y < 0 || y > n - 1 || board[x][y] != 'O')
            return false;
        return true;
    }

    private class Point{
        int x, y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
