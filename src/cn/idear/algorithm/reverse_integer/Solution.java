package cn.idear.algorithm.reverse_integer;

/**
 * Created by wangdongwei on 8/25/15.
 Reverse digits of an integer.

 Example1: x = 123, return 321
 Example2: x = -123, return -321
 */
public class Solution {
    public int reverse(int x) {
        if(x == Integer.MIN_VALUE)
            return 0;
        else if(x < 0) {
            /**
             * 学习这种处理负数的方式。
             */
            return -reverse(-x);
        }
        int rst = 0;
        do{
            /**
             * 学习这种处理越界的方式。
             */
            if(rst > (Integer.MAX_VALUE - x % 10) / 10)
                return 0;
            rst = rst * 10 + x % 10;
            x /= 10;
        }while(x > 0);
        return rst;
    }

    public int reverse1(int x) {
        int rst = 0;
        boolean neg = x < 0;
        if(x == Integer.MIN_VALUE)
            return 0;
        x = Math.abs(x);
        do{
            long tmp = (long)rst * 10 + x % 10;
            if(tmp > Integer.MAX_VALUE)
                return 0;
            rst = (int) tmp;
            x /= 10;
        }while(x > 0);
        if(neg) rst = -rst;
        return rst;
    }
}
