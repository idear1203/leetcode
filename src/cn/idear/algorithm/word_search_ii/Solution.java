package cn.idear.algorithm.word_search_ii;

import java.util.*;

/**
 * Created by idear on 15-11-2.
 */
public class Solution {

    TrieNode root = new TrieNode();

    Set<String> set = new HashSet<>();

    class TrieNode{

        TrieNode[] children = new TrieNode[26];

        boolean isEnd = false;

        TrieNode getChildByKey(int i){
            if(children[i] == null)
                children[i] = new TrieNode();
            return children[i];
        }

        void insert(char[] words, int start, int length){
            if(length > 0){
                TrieNode child = getChildByKey(index(words[start]));
                child.insert(words, start + 1, length - 1);
            }else
                isEnd = true;
        }

        boolean hasChild(char ch){
            return children[index(ch)] != null;
        }

        TrieNode getChild(char ch){
            return children[index(ch)];
        }

        private int index(char ch) {
            return ch - 'a';
        }

        boolean startWith(char[] words, int start, int length){
            return search(words, start, length, true);
        }

        private boolean search(char[] words, int start, int length) {
            return search(words, start, length, false);
        }

        private boolean search(char[] words, int start, int length, boolean isStartWith) {
            if(length == 0)
                return isStartWith || isEnd;
            TrieNode child = getChild(words[start]);
            if(child == null) return false;
            return child.search(words, start + 1, length - 1, isStartWith);
        }
    }

    public List<String> findWords(char[][] board, String[] words) {
        int m = board.length;
        if(m == 0) return Collections.emptyList();
        int n = board[0].length;
        for(String word : words)
            root.insert(word.toCharArray(), 0, word.length());
        List<String> result = new ArrayList<>();
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++) {
                if(root.hasChild(board[i][j])) {
                    boolean[][] visited = new boolean[m][n];
                    findWordsHelper(board, m, n, i, j, visited, "");
                }
            }
        }
        result.addAll(set);
        return result;
    }

    private void findWordsHelper(char[][] board, int m, int n, int i, int j, boolean[][] visited,
                                 String str) {
        /**
         * 已经被访问过
         */
        if(visited[i][j])
            return;
        /**
         * 更新str
         */
        str += board[i][j];
        /**
         * 没有以此前缀的。
         */
        if(!root.startWith(str.toCharArray(), 0, str.length()))
            return;
        /**
         * 如果找到
         */
        if(root.search(str.toCharArray(), 0, str.length())){
            set.add(str);
        }
        visited[i][j] = true;
        for(int[] xy : new int[][]{
                {i, j + 1},
                {i, j - 1},
                {i - 1, j},
                {i + 1, j}
        }){
            int x = xy[0];
            int y = xy[1];
            if(isValid(x, y, m, n)){
                findWordsHelper(board, m, n, x, y, visited, str);
            }
        }
        visited[i][j] = false;
    }

    private boolean isValid(int i, int j, int m, int n) {
        return i >= 0 && i < m && j >= 0 && j < n;
    }
}
