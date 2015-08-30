package cn.idear.algorithm.climbing_stairs;

import java.util.Arrays;

/**
 * Created by wangdongwei on 8/30/15.
 */
public class Solution {
    public int climbStairs(int n) {
        if(n == 0 || n == 1)
            return 1;
        int[] cache = new int[n + 1];
        Arrays.fill(cache, -1);
        cache[0] = cache[1] = 1;
        return climbStairsHelper(n, cache);
    }

    private int climbStairsHelper(int n, int[] cache) {
        if(cache[n] != -1)
            return cache[n];
        return cache[n] = climbStairsHelper(n - 1, cache) + climbStairsHelper(n - 2, cache);
    }
}
