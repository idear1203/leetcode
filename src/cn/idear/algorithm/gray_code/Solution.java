package cn.idear.algorithm.gray_code;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by wangdongwei on 9/4/15.
 *
 The gray code is a binary numeral system where two successive values differ in only one bit.
 Given a non-negative integer n representing the total number of bits in the code, print the sequence of gray code.
 A gray code sequence must begin with 0.
 */
public class Solution {
    public List<Integer> grayCode(int n){
        List<Integer> result = new ArrayList<>();
        int size = 1 << n;
        for(int i = 0; i < size; i++ )
            result.add(toGray(i));
        return result;
    }

    private int toGray(int n) {
        return n ^ (n >> 1);
    }
}
