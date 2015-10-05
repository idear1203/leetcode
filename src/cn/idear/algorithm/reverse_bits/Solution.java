package cn.idear.algorithm.reverse_bits;

/**
 * Created by wangdongwei on 10/4/15.
 */
public class Solution {
    // you need treat n as an unsigned value
    public int reverseBits(int n) {
        if(n == 0) return 0;
        long nn = n;
        int rst = 0;
        for(int i = 0; i < Integer.SIZE; i++){
            rst = (int) ((rst << 1) | (nn & 0x01));
            nn >>= 1;
        }
        return rst;
    }
}
