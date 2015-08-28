package cn.idear.algorithm.pow_x_n;

/**
 * Created by wangdongwei on 8/28/15.
 */
public class Solution {
    public double myPow(double x, int n) {
        if(n == Integer.MIN_VALUE)
            return 1 / (myPow(x, Integer.MAX_VALUE) * x);
        else if(n < 0)
            return 1 / myPow(x, -n);
        else if(n == 0)
            return 1;
        else if(n == 1)
            return x;
        else{
            double pow = myPow(x, n / 2);
            pow *= pow;
            return ((n & 0x01) > 0 ? pow * x : pow);
        }
    }
}
