package cn.idear.algorithm.maximum_subarray;

/**
 * Created by wangdongwei on 8/29/15.
 */
public class Solution {
    public int maxSubArray(int[] nums) {
        int history = 0;
        int result = Integer.MIN_VALUE;
        for(int i = 0; i < nums.length; i++){
            if(history <= 0)
                history = nums[i];
            else
                history += nums[i];
            result = Math.max(result, history);
        }
        return result;
    }
}
