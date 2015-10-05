package cn.idear.algorithm.number_of_1_bits;

/**
 * Created by wangdongwei on 10/5/15.
 */
public class Solution {
    public int hammingWeight1(int n) {
        return Integer.bitCount(n);
    }

    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        long nn = (long)n;
        int count = 0;
        for(int i = 0; i < Integer.SIZE; i++){
            if((nn & 0x01) > 0)
                count++;
            nn >>= 1;
        }
        return count;
    }
}
