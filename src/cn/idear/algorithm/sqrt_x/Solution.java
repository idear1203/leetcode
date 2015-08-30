package cn.idear.algorithm.sqrt_x;

/**
 * Created by wangdongwei on 8/30/15.
 * Implement int sqrt(int x).

 Compute and return the square root of x.
 */
//TODO:二分不出来。。。
public class Solution {
    public int mySqrt(int x) {
        if(x == 0 || x == 1)
            return x;
       return mySqrtHelper(x, 1, x - 1);
    }

    private int mySqrtHelper(int x, int s, int e) {
        if(s == e)
            return s;
        else if(s < e){
            int mid = (s + e) / 2;
            int tmp = x / mid;
            if(tmp == mid)
                return mid;
            else if(tmp > mid) {
                if(mid + 1 == e)
                    return mid;
                return mySqrtHelper(x, mid + 1, e);
            }
            else if(tmp < mid) {
                if(s == mid)
                    return s;
                return mySqrtHelper(x, s, mid - 1);
            }
        }
        throw new RuntimeException();
    }

    public int sqrt2(int x) {
        if(x < 0) return -1;
        if(x == 0) return 0;

        // x/t + t = 2t
        double t = (double)x;
        double tt = 0;
        while( (int)tt - (int)t != 0 ){
            tt = t;
            t = (x/t + t) /2;

        }

        return (int)tt;
    }
    /**
     * Accepted. ^_^
     * @param x
     * @return
     */
    public int mySqrt1(int x) {
        return (int) Math.sqrt(x);
    }
}
