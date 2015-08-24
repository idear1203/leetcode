package cn.idear.algorithm.add_binary;

import java.math.BigInteger;

/**
 * Created by wangdongwei on 8/23/15.
 Given two binary strings, return their sum (also a binary string).

 For example,
 a = "11"
 b = "1"
 Return "100".
 */
public class Solution {
    public String addBinary(String a, String b) {
        BigInteger ai = new BigInteger(a, 2);
        BigInteger bi = new BigInteger(b, 2);
        BigInteger rst = ai.add(bi);
        return rst.toString(2);
    }
}

//public class Solution {
//    public String addBinary(String a, String b) {
//        StringBuilder sb = new StringBuilder();
//        int carry = 0;
//        for(int ai = a.length() - 1, bi = b.length() - 1;
//            ai >= 0 || bi >= 0; ai--, bi--){
//            int aval = (ai >= 0 ? a.charAt(ai) - '0' : 0);
//            int bval = (bi >= 0 ? b.charAt(bi) - '0': 0);
//            int val = carry + aval + bval;
//            int remainder = val & 0x01;
//            sb.insert(0, remainder);
//            carry = val / 2;
//        }
//        if(carry > 0)
//            sb.insert(0, 1);
//        return sb.toString();
//    }
//}

/**
 Runtime Error Message:
 Line 3: java.lang.NumberFormatException: For input string:
 "10100000100100110110010000010101111011011001101110111111111101000000101111001110001111100001101"

 public class Solution {
 public String addBinary(String a, String b) {
 Integer ai = Integer.parseInt(a, 2);
 Integer bi = Integer.parseInt(b, 2);
 String rst = Integer.toBinaryString(ai + bi);
 return rst;
 }
 }
 */
