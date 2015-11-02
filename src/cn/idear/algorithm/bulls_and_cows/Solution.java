package cn.idear.algorithm.bulls_and_cows;

/**
 * Created by idear on 15-11-2.
 */
public class Solution {
    public String getHint(String secret, String guess) {
        int[] dict = new int[10];
        int a = 0, b = 0;
        char[] s = secret.toCharArray();
        char[] g = guess.toCharArray();
        for(int i = 0; i < s.length; i++){
            /**
             * a是两者一样的情况
             */
            if(s[i] == g[i]) a++;
            else{
                /**
                 * 注意此问题需要保证字符一定在secret中。
                 */
                /**
                 * 说明之前有不匹配的g[j]，0<=j<i
                 */
                if(++dict[s[i] - '0'] <= 0) b++;
                /**
                 * 说明之前有不匹配的s[j]
                 */
                if(--dict[g[i] - '0'] >= 0) b++;
            }
        }
        return a + "A" + b + "B";
    }
}
