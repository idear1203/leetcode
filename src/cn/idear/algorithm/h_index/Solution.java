package cn.idear.algorithm.h_index;

import java.util.Arrays;

/**
 * Created by wangdongwei on 10/6/15.
 */
//TODO:
public class Solution {
    public int hIndex(int[] citations) {
        if(citations.length == 0) return 0;
        if(citations.length == 1) return 1;
        Arrays.sort(citations);
        int sum = 0;
        for(int i = 0; i < citations.length; i++)
            sum += citations[i];
        sum /= citations.length;
        int i;
        for(i = 1; i < citations.length && citations[i] <= sum; i++);
        return i - 1;
    }
}
