package cn.idear.algorithm.edit_distance;

/**
 * Created by wangdongwei on 9/4/15.
 * Given two words word1 and word2, find the minimum number of steps required to convert word1 to word2. (each operation is counted as 1 step.)

 You have the following 3 operations permitted on a word:

 a) Insert a character
 b) Delete a character
 c) Replace a character
 */
public class Solution {
    public int minDistance(String word1, String word2){
        int n = word1.length();
        int m = word2.length();
        int[][] f = new int[n + 1][m + 1];
        /**
         * 初始化表示了空串编导A[0...i]或B[0...i]的编辑距离。
         * 不停添加/删除字符即可。
         */
        for(int i = 0; i <= n; i++)
            f[i][0] = i;
        for(int i = 0; i <= m; i++)
            f[0][i] = i;
        for(int i = 1; i <= n; i++)
            for(int j = 1; j <= m; j++){
                char ch1 = word1.charAt(i - 1);
                char ch2 = word2.charAt(j - 1);
                if(ch1 == ch2){
                    f[i][j] = f[i - 1][j - 1];
                }else{
                    int tmp = Math.min(f[i - 1][j], f[i][j - 1]);
                    f[i][j] = Math.min(tmp, f[i - 1][j - 1]) + 1;
                }
            }
        return f[n][m];
    }
}
