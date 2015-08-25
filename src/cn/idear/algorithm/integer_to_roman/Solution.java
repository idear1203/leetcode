package cn.idear.algorithm.integer_to_roman;

/**
 * Created by wangdongwei on 8/25/15.
 Given an integer, convert it to a roman numeral.

 Input is guaranteed to be within the range from 1 to 3999.
 */

/**
 *
 http://en.wikipedia.org/wiki/Roman_numerals
 I	1
 V	5
 X	10
 L	50
 C	100
 D	500
 M	1,000

 to avoid four characters being repeated in succession
 */
public class Solution {
    private static final int radix[] = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};

    private static final String symbol[] = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};

    public String intToRoman(int num) {
        /**
         * 尝试了stringBuffer/StringBuilder/String类，事实证明StringBuffer最快。
         */
        StringBuffer sb = new StringBuffer();
        for(int i = 0; i < radix.length; i++){
            int count = num / radix[i];
            for(; count > 0; count--)
                sb.append(symbol[i]);
            num = num % radix[i];
        }
        return sb.toString();
    }
}
