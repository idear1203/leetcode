package cn.idear.algorithm.number_of_digit_one;

/**
 * Created by wangdongwei on 10/3/15.
 */
public class Solution {
    public int countDigitOne(int n) {
        int rst = 0;
        for(long i = 1; i <= n; i *= 10){
            int ii = (int) i;
            int high = n / ii;
            int low = n % ii;
            // int highLowest = high % 10;
            // rst += (high / 10) * ii;
            // if(highLowest > 1)
            //     rst += ii;
            // else if(highLowest == 1)
            //     rst += low + 1;
            /**
             * 学习式子中加8这种思路。
             */
            rst += ((high + 8) / 10 * ii) + ((high % 10 == 1) ? (low + 1) : 0);
        }
        return rst;
    }
}
