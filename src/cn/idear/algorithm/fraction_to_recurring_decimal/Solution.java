package cn.idear.algorithm.fraction_to_recurring_decimal;


import java.util.HashMap;
import java.util.Map;

/**
 * Created by wangdongwei on 10/3/15.
 */
public class Solution {
    public String fractionToDecimal(int numerator, int denominator) {
        StringBuffer sb = new StringBuffer();
        if(Math.signum(numerator) * Math.signum(denominator) < 0)
            sb.append('-');
        long _numerator = Math.abs((long)numerator);
        long _denominator = Math.abs((long)denominator);
        long quotient = _numerator / _denominator;
        long remain = _numerator % _denominator;
        sb.append(quotient);
        if(remain > 0) {
            sb.append(".");
        }
        Map<Long, Integer> map = new HashMap<>();
        while(remain > 0){
            remain *= 10;
            Integer pos = map.get(remain);
            if(pos == null) {
                quotient = remain / _denominator;
                map.put(remain, sb.length());
                sb.append(quotient);
                remain = remain % _denominator;
            }else{
                /**
                 * 判定无限循环小数的方法是出现了重复的被除数。
                 */
                sb.insert(pos, "(");
                sb.append(")");
                break;
            }
        }
        return sb.toString();
    }
}
