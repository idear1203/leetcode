package cn.idear.algorithm.interleaving_string;

/**
 * Created by idear on 15-11-4.
 */
public class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        if(s1.length() + s2.length() != s3.length())
            return false;
        if(s3.length() == 0)
            return true;
        char[] ss1 = s1.toCharArray();
        char[] ss2 = s2.toCharArray();
        char[] ss3 = s3.toCharArray();
        boolean f[][] = new boolean[ss1.length + 1][ss2.length + 1];
        f[0][0] = true;
        for(int i = 0; i <= ss1.length; i++){
            for(int j = 0; j <= ss2.length; j++){
                if(i + j > 0){
                    f[i][j] = (i > 0 && ss1[i - 1] == ss3[i + j - 1] && f[i - 1][j])
                            || (j > 0 && ss2[j - 1] == ss3[i + j - 1] && f[i][j - 1]);
                }
            }
        }
        return f[ss1.length][ss2.length];
    }
}
