package cn.idear.algorithm.plus_one;

import java.util.Arrays;

/**
 * Created by wangdongwei on 8/23/15.
 */
public class Solution{
    public int[] plusOne(int[] digits) {
        int[] rst = new int[digits.length + 1];
        int carry = 1;
        for(int i = digits.length - 1; i >= 0; i--){
            int val = digits[i] + carry;
            rst[i + 1] = val % 10;
            carry = val / 10;
        }
        if(carry == 0)
            return Arrays.copyOfRange(rst, 1, rst.length);
        rst[0] = 1;
        return rst;
    }
}
///**
// * Accepted
// */
//public class Solution {
//    public int[] plusOne(int[] digits) {
//        List<Integer> rst = new ArrayList<Integer>();
//        int i;
//        int carry = 1;
//        for(i = digits.length - 1; i >= 0 && carry > 0; i--){
//            int val = digits[i] + carry;
//            carry = (val >= 10 ? 1 : 0);
//            rst.add(val % 10);
//        }
//        /**
//         * 第一次提交出错：注意上个for出口处已经i--，故而此处无须对i赋初值。
//         */
//        for(; i >= 0; i--)
//            rst.add(digits[i]);
//        if(carry > 0)
//            rst.add(carry);
//        int [] rstArray = new int[rst.size()];
//        for(int j = 0; j < rstArray.length; j++)
//            rstArray[j] = rst.get(rstArray.length - 1 - j);
//        return rstArray;
//    }
//}

