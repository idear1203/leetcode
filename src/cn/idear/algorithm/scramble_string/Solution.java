package cn.idear.algorithm.scramble_string;

/**
 * Created by idear on 15-11-5.
 */
public class Solution {

    public boolean isScramble(String s1, String s2) {
        int n = s1.length();
        if(n == 0) return true;
        boolean[][][] f = new boolean[n + 1][n][n];
        for(int i = 0; i < n; i++)
            for(int j = 0; j < n; j++)
                f[1][i][j] = (s1.charAt(i) == s2.charAt(j));
        for(int l = 2; l <= n; l++){
            /**
             * 注意i,j的边界，要满足i + k < n, j + k < n， k \in [1, l - 1]，因此 i + l - 1 < n, j + l - 1 < n
             */
            for(int i = 0; i <= n - l; i++)
                for(int j = 0; j <= n - l; j++)
                    for(int k = 1; k < l; k++){
                        f[l][i][j] = (f[k][i][j] && f[l - k][i + k][j + k])
                                || (f[k][i][j + l - k] && f[l - k][i + k][j]);
                        if(f[l][i][j]) break;
                    }
        }
        return f[n][0][0];
    }

    // /**
    //  * TLE
    //  */
    // public boolean isScramble(String s1, String s2) {
    //     if(s1.length() == 0) return true;
    //     char[] ss1 = s1.toCharArray();
    //     char[] ss2 = s2.toCharArray();
    //     Arrays.sort(ss1);
    //     Arrays.sort(ss2);
    //     return Arrays.equals(ss1, ss2) && isScrambleHelper(s1.toCharArray(), s2.toCharArray(), s1.length(), 0, 0);
    // }

    // public boolean isScrambleHelper(char[] s1, char[] s2, int l, int i, int j){
    //     if(l == 1) return s1[i] == s2[j];
    //     for(int k = 1; k < l; k++){
    //         if((isScrambleHelper(s1, s2, k, i, j)
    //              && isScrambleHelper(s1, s2, l - k, i + k, j + k))
    //              || (isScrambleHelper(s1, s2, k, i, j + l - k)
    //                 && isScrambleHelper(s1, s2, l - k, i + k, j)))
    //                 return true;
    //     }
    //     return false;
    // }
}
