package cn.idear.algorithm.largest_number;

import java.util.*;

/**
 * Created by wangdongwei on 10/4/15.
 */
public class Solution {
    public String largestNumber(int[] nums) {
        String[] strs = new String[nums.length];
        /**
         * 学习 Integer.toString
         */
        for(int i = 0; i < nums.length; i++)
            strs[i] = Integer.toString(nums[i]);
        Arrays.sort(strs, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                /**
                 * 本题核心
                 */
                return (o2 + o1).compareTo(o1 + o2);
            }
        });
        if(strs[0].equals("0"))
            return strs[0];
        StringBuilder sb = new StringBuilder();
        for(String str : strs)
            sb.append(str);
        return sb.toString();
    }
}
