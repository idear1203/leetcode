package cn.idear.algorithm.longest_palindromic_substring;

import java.util.Arrays;

/**
 * Created by wangdongwei on 8/25/15.
 */
public class Solution {
    private static final int MAX_LENGTH = 1000;

    /**
     * 动态规划法。时间复杂度：O(N^2)，空间复杂度O(N^2)。
     * 用f(i,j)表示i,j之间是否是回文串。
     * 递归方程：
     * f(i,j) = true, j == i
     *          s[i] == s[j], j == i + 1
     *          s[i] = s[j] && f(i + 1, j - 1), j > i + 1
     * @param s
     * @return
     */
    public String longestPalindrome(String s) {
        int maxLen = 1;
        int start = 0;
        boolean [][]f = new boolean[MAX_LENGTH][MAX_LENGTH];
        Arrays.fill(f,false);
        /**
         * 第一步，初始化f(i,i) = true.
         */
        for(int i = 0; i < s.length(); i++)
            f[i][i] = true;
        /**
         * 第二步，s[i] == s[j], j == i + 1
         */
        for(int i = 0 ; i < s.length() - 1; i++) {
            if (s.charAt(i) == s.charAt(i + 1)) {
                f[i][i + 1] = true;
                start = i;
                maxLen = 2;
            }
        }
        /**
         * 第三步，s[i] = s[j] && f(i + 1, j - 1), j > i + 1
         */
        for(int j = 2; j < s.length(); j++){
            for(int i = 0; i < j - 1; i++){
                if(s.charAt(i) == s.charAt(j) && f[i+1][j-1]){
                    f[i][j] = true;
                    start = i;
                    maxLen = j - i + 1;
                }
            }
        }
        return s.substring(start, start + maxLen);
    }
}
