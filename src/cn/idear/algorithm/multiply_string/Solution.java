package cn.idear.algorithm.multiply_string;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by wangdongwei on 8/23/15.
 */

/**
 * Accepted
 */
public class Solution {

    class BigInt {
        List<Integer> elements = new ArrayList<Integer>();

        public BigInt(List<Integer> elements){
            this.elements = elements;
        }

        public BigInt(String num) {
            int len = num.length();
            for(int i = 0; i < len; i++)
                elements.add(num.charAt(len - 1 - i) - '0');
        }

        int getElement(int i){
            return elements.get(i);
        }

        int length(){
            return elements.size();
        }

        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder();
            int index = length() - 1;
            while(index >=0 && elements.get(index) == 0)
                index--;
            for(; index >= 0; index--)
                sb.append(elements.get(index));
            String rst = sb.toString();
            if(rst.length() == 0)
                return "0";
            return sb.toString();
        }
    }

    private String multiply(BigInt num1, BigInt num2){
        int alen = num1.length();
        int blen = num2.length();
        int clen = alen + blen;
        ArrayList<Integer> rst = new ArrayList<Integer>();
        for(int i = 0; i < clen; i++)
            rst.add(0);
        for(int ai = 0; ai < alen; ai++){
            for(int bi = 0; bi < blen; bi++) {
                int aval = num1.getElement(ai);
                int bval = num2.getElement(bi);
                int cval = rst.get(ai + bi);
                int val = aval * bval + cval;
                rst.set(ai + bi, val % 10);
                if(val >= 10)
                    rst.set(ai + bi + 1, rst.get(ai + bi + 1) + val / 10);
            }
        }
        return new BigInt(rst).toString();
    }

    public String multiply(String num1, String num2) {
        BigInt b1 = new BigInt(num1);
        BigInt b2 = new BigInt(num2);
        return multiply(b1, b2);
    }
}


///**
// * Accepted
// */
//public class Solution {
//    public String multiply1(String num1, String num2) {
//        BigInteger n1 = new BigInteger(num1);
//        BigInteger n2 = new BigInteger(num2);
//        return n1.multiply(n2).toString();
//    }
//}
