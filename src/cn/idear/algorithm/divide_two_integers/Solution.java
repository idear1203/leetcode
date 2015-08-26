package cn.idear.algorithm.divide_two_integers;

/**
 * Created by wangdongwei on 8/26/15.
 * Divide two integers without using multiplication, division and mod operator.

 If it is overflow, return MAX_INT.
 */
public class Solution {
    public int divide(int dividend, int divisor) {
        if(divisor == 0)
            return Integer.MAX_VALUE;
        long rst = 0;
        long a = Math.abs((long)dividend);
        long b = Math.abs((long)divisor);
        boolean neg = ((dividend > 0 && divisor < 0) || (dividend < 0 && divisor > 0));
        while(a >= b){
            for(long i = 0, c = b; a >= c; c<<=1, i++) {
                a -= c;
                long add = 1 << i;
                rst += add;
            }
        }
        /**
         * Integer.MIN_VALUE / -1
         */
        if(!neg && rst > Integer.MAX_VALUE)
            return Integer.MAX_VALUE;
        return (int)(neg ? -rst: rst);
    }
}
