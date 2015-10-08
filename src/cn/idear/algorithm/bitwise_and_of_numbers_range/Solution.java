package cn.idear.algorithm.bitwise_and_of_numbers_range;

/**
 * Created by idear on 15-10-8.
 */
public class Solution {
    public int rangeBitwiseAnd(int m, int n) {
        int diffBits = 0;
        for(; m != n ; m >>= 1, n >>= 1)
            diffBits++;
        return m <<diffBits;
    }

//    /**
//     * wrong answer
//     */
//    public int rangeBitwiseAnd(int m, int n) {
//        if(m == 0 && n == Integer.MAX_VALUE) return 0;
//        if(m == n) return m;
//        int len = n - m + 1;
//        /**
//         * 注意mask的初值，必须前面都是1。开始写的0是不对的。
//         */
//        int mask = Integer.MAX_VALUE;
//        while(len > 0){
//            mask<<=1;
//            len>>=1;
//        }
//        return (m & mask);
//    }
}
