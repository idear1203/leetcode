package cn.idear.algorithm.word_search;

import java.util.*;

/**
 * Created by idear on 15-9-6.
 * Given a 2D board and a word, find if the word exists in the grid.

 The word can be constructed from letters of sequentially adjacent cell, where "adjacent" cells are those horizontally or vertically neighboring. The same letter cell may not be used more than once.

 For example,
 Given board =

 [
 ["ABCE"],
 ["SFCS"],
 ["ADEE"]
 ]
 word = "ABCCED", -> returns true,
 word = "SEE", -> returns true,
 word = "ABCB", -> returns false.
 */
public class Solution {

    public boolean exist(char[][] board, String word) {
        if(word.length() == 0)
            return false;
        if(board.length == 0)
            return false;
        int m = board.length;
        int n = board[0].length;
        char[] words = word.toCharArray();
        boolean[][] visits = new boolean[m][n];
        for(int i = 0; i < m; i++)
            Arrays.fill(visits[i], false);
        for(int i = 0; i < m; i++)
            for(int j = 0; j < n; j++){
                if(board[i][j] == words[0]){
                    if(dfs(board, m, n, words, 0, visits, i, j))
                        return true;
                }
            }
        return false;
    }

    private boolean dfs(char[][] board, int m, int n, char[] words, int index, boolean[][] visits, int i, int j) {
        if(index == words.length)
            return true;
        if(i >= 0 && i < m && j >= 0 && j < n) {
            if (!visits[i][j]) {
                char target = words[index];
                if (target == board[i][j]){
                    visits[i][j] = true;
                    boolean ret = dfs(board, m, n, words, index + 1, visits, i, j + 1)
                            || dfs(board, m, n, words, index + 1, visits, i, j - 1)
                            || dfs(board, m, n, words, index + 1, visits, i + 1, j )
                            || dfs(board, m, n, words, index + 1, visits, i - 1, j );
                    visits[i][j] = false;
                    return ret;
                }
            }
        }
        return false;
    }

    class Point{
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    class PointSet {
       Map<Integer, Set<Integer>>  map = new HashMap<>();
        void addPoint(int from, int to){
            Set<Integer> set = map.get(from);
            if(set == null){
                set = new HashSet<>();
                map.put(from, set);
            }
            set.add(to);
        }

        boolean containsPoint(int from, int to){
            Set<Integer> set = map.get(from);
            return set != null && set.contains(to);
        }

        void removePoint(int from, int to){
            Set<Integer> set = map.get(from);
            if(set != null)
                set.remove(to);
        }
    }

    public boolean exist1(char[][] board, String word) {
        if(word.length() == 0)
            return true;
        if(board.length == 0)
            return false;
        int m = board.length;
        int n = board[0].length;
        char[] chars = word.toCharArray();
        for(int i = 0; i < m; i++)
            for(int j = 0; j < n; j++)
                if(board[i][j] == chars[0]){
                    PointSet pointSet = new PointSet();
                    pointSet.addPoint(i, j);
                    if(existHelper(board, chars, 1, pointSet, i, j, m , n))
                        return true;
                }
        return false;
    }

    private boolean existHelper(char[][] board, char[] word, int index, PointSet pointSet, int row, int col,
                                int m, int n) {
        if(index == word.length)
            return true;
        char ch = word[index];
        for(Point p : new Point[]{new Point(row + 1, col), new Point(row -1, col), new Point(row, col + 1),
                new Point(row, col - 1)}){
            int x = p.x;
            int y = p.y;
            if(!isLegalPoint(p, m, n))
                continue;
            if(ch == board[x][y]) {
                if (!pointSet.containsPoint(x, y)){
                    pointSet.addPoint(x, y);
                    if(existHelper(board, word, index + 1, pointSet, x, y, m, n))
                        return true;
                    pointSet.removePoint(x, y);
                }
            }
        }
        return false;
    }

    private boolean isLegalPoint(Point p, int m, int n) {
        int x = p.x;
        int y = p.y;
        return x >= 0 && x < m && y >= 0 && y < n;
    }
}
