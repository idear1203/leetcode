package cn.idear.algorithm.edit_distance;

/**
 * Created by wangdongwei on 9/4/15.
 */
//TODO:没有理解算法内涵
public class Solution {
    public int minDistance(String word1, String word2){
        int n = word1.length();
        int m = word2.length();
        /**
         * 为什么要+1?
         */
        int[][] f = new int[n + 1][m + 1];
        /**
         * 初始化？
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
