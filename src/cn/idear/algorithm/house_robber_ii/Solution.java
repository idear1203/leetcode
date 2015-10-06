package cn.idear.algorithm.house_robber_ii;

/**
 * Created by wangdongwei on 10/6/15.
 */
public class Solution {
    public int rob(int[] nums) {
        if(nums.length == 0) return 0;
        if(nums.length == 1) return nums[0];
        /**
         * 如果偷了第0家，最多可以偷到第nums.length - 2家。如果不偷第0家，则可以偷第1...nums.length - 1家。
         */
        return Math.max(robHelper(nums, 0, nums.length - 2), robHelper(nums, 1, nums.length - 1));
    }

    public int robHelper(int[] nums, int start, int end){
        if(end - start < 0)    return 0;
        if(end - start == 0) return nums[start];
        int[] f = new int[end - start + 1];
        f[0] = nums[start];
        f[1] = Math.max(nums[start], nums[start + 1]);
        for(int i = 2; i <= end - start; i++)
            f[i] = Math.max(f[i - 2] + nums[start + i], f[i - 1]);
        return f[end - start];
    }
}
