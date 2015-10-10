package cn.idear.algorithm.minimum_size_subarray_sum;

/**
 * Created by wangdongwei on 10/10/15.
 */
public class Solution {
    /**
     *
     * @param s
     * @param nums
     * @return
     */
    public int minSubArrayLen(int s, int[] nums) {
        int sum = 0;
        boolean hasReached = false;
        int slow = 0;
        int min = nums.length;
        for(int fast = 0; fast < nums.length; fast++){
            sum += nums[fast];
            if(sum >= s && !hasReached) hasReached = true;
            while(sum >= s){
                min = Math.min(min, fast - slow + 1);
                sum -= nums[slow++];
            }
        }
        return hasReached ? min : 0;
    }
}
