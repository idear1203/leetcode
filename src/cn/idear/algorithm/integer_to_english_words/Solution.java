package cn.idear.algorithm.integer_to_english_words;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by wangdongwei on 10/13/15.
 */
public class Solution {
    private static final Map<Integer, String> map = new HashMap<Integer, String>(){
        {
            put(0, "Zero");
            put(1, "One");
            put(2, "Two");
            put(3, "Three");
            put(4, "Four");
            put(5, "Five");
            put(6, "Six");
            put(7, "Seven");
            put(8, "Eight");
            put(9, "Nine");
            put(10, "Ten");
            put(11, "Eleven");
            put(12, "Twelve");
            put(13, "Thirteen");
            put(14, "Fourteen");
            put(15, "Fifteen");
            put(16, "Sixteen");
            put(17, "Seventeen");
            put(18, "Eighteen");
            put(19, "Nineteen");
            put(20, "Twenty");
            put(30, "Thirty");
            put(40, "Forty");
            put(50, "Fifty");
            put(60, "Sixty");
            put(70, "Seventy");
            put(80, "Eighty");
            put(90, "Ninety");
            put(100, "Hundred");
            put(1000, "Thousand");
            put(1000000, "Million");
            put(1000000000, "Billion");
        }
    };
    public String numberToWords(int num) {
        StringBuilder sb = new StringBuilder();
        if(num <= 20){
            sb.append(map.get(num));
            num = 0;
        }
        else if(num < 100){
            sb.append(map.get(num / 10 * 10));
            num = num % 10;
        }else if(num < 1000){
            sb.append(map.get(num / 100)).append(" ").append(map.get(100));
            num = num % 100;
        }else if(num < 1000000){
            sb.append(numberToWords(num / 1000)).append(" ").append(map.get(1000));
            num = num % 1000;
        }else if(num < 1000000000){
            sb.append(numberToWords(num / 1000000)).append(" ").append(map.get(1000000));
            num = num % 1000000;
        }else{
            sb.append(numberToWords(num / 1000000000)).append(" ").append(map.get(1000000000));
            num = num % 1000000000;
        }
        if(num > 0) sb.append(" ").append(numberToWords(num));
        return sb.toString();
    }
}
