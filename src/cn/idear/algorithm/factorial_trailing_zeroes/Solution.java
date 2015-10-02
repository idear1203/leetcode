package cn.idear.algorithm.factorial_trailing_zeroes;

/**
 * Created by wangdongwei on 10/3/15.
 */
public class Solution {
    /**
     * O(1)
     * @param n
     * @return
     */
    public int trailingZeroes(int n) {
        int rst = 0;
        for(long i = 5; i <= n ; i *= 5)
            rst += n / i;
        return rst;
    }
}
