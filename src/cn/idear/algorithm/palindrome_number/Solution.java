package cn.idear.algorithm.palindrome_number;

/**
 * Created by wangdongwei on 8/25/15.
 * Determine whether an integer is a palindrome. Do this without extra space.
 */
public class Solution {
    public boolean isPalindrome(int x) {
//        /**
//         * 做这种涉及到相反数的题要考虑最小值！
//         */
//        if(x == Integer.MIN_VALUE)
//            return false;
        /**
         * 负数不是回文数。
         * */
        if(x < 0)
            return false;
        else if(x == 0)
            return true;
        int length = getLength4NonNegative(x);
        return  isPalindrome(x, length);
    }

    private int getLength4NonNegative(int x) {
        if(x == 0)
            return 1;
        int length = 0;
        do{
            x /= 10;
            length ++;
        }while (x > 0);
        return length;
//        /**
//         * 学习求非负整数位数的方法！此方法虽然简单，但效率低。
//         */
//        return (int)Math.log10(x) + 1;
    }

    private  boolean isPalindrome(int x, int length){
        /**
         * 所有个位数都是回文数及\epsilon是回文数
         */
        if(length == 0 || length == 1)
            return true;
        /**
         * x是回文数当且仅当x个数与最高位相同，并且中间的数是回文数
         */
        else{
            int base = (int)Math.pow(10, length - 1);
            int highestDigit = x / base;
            int lowestDigit = x % 10;
            return lowestDigit == highestDigit && isPalindrome((x % base) / 10, length - 2);
        }
    }
}
