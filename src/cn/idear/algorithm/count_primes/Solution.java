package cn.idear.algorithm.count_primes;

/**
 * Created by wangdongwei on 10/7/15.
 */
public class Solution {
    public int countPrimes(int n) {
        if(n <= 1) return 0;
        boolean[] f = new boolean[n];
        int m = (int)Math.sqrt(n);
        for(int i = 2; i <= m; i++){
            if(!f[i]){
                for(int j = 2; i * j < n; j++)
                    f[i * j] = true;
            }
        }
        int count = 0;
        for(int i = 2; i < n; i++)
            if(!f[i])
                count++;
        return count;
    }
}
