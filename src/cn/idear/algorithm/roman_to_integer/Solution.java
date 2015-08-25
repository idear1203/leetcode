package cn.idear.algorithm.roman_to_integer;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by wangdongwei on 8/25/15.
 * Given a roman numeral, convert it to an integer.

 Input is guaranteed to be within the range from 1 to 3999.
 I	1
 V	5
 X	10
 L	50
 C	100
 D	500
 M	1,000
 */
public class Solution {
    public int romanToInt(String s) {
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        map.put('M', 1000);
        map.put('D', 500);
        map.put('C', 100);
        map.put('L', 50);
        map.put('X', 10);
        map.put('V', 5);
        map.put('I', 1);
        int rst = map.get(s.charAt(0));
        for(int i = 1; i < s.length(); i++ ){
            char cur = s.charAt(i);
            int v1 = map.get(cur);
            rst += v1;
            int v2 = map.get(s.charAt(i - 1));
            if(v1 > v2) {
                /**
                 * 实际应该加v1 - v2
                 * 上一次迭代加了一次v2，
                 * 所以本次应该加 v1 - 2 * v2
                 */
                rst -= v2 * 2;
            }
        }
        return rst;
    }

    public int romanToInt1(String s) {
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        map.put('M', 1000);
        map.put('D', 500);
        map.put('C', 100);
        map.put('L', 50);
        map.put('X', 10);
        map.put('V', 5);
        map.put('I', 1);
        int rst = 0;
        for(int i = 0; i < s.length(); ){
            char cur = s.charAt(i);
            int v1 = map.get(cur);
            if(i < s.length() - 1){
                char next = s.charAt(i + 1);
                int v2 = map.get(next);
                if(v1 < v2) {
                    rst += v2 - v1;
                    i += 2;
                    continue;
                }
            }
            rst += v1;
            i++;
        }
        return rst;
    }
}
