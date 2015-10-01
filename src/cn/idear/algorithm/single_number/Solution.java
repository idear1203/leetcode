package cn.idear.algorithm.single_number;

/**
 * Created by wangdongwei on 10/1/15.
 */
public class Solution {
    public int singleNumber(int[] nums) {
        int rst = 0;
        for(int i = 0; i < nums.length; i++)
            rst = rst^nums[i];
        return rst;
    }
}
