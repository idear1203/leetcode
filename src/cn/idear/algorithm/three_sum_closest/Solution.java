package cn.idear.algorithm.three_sum_closest;

import java.util.Arrays;

/**
 * Created by wangdongwei on 8/26/15.
 * Given an array S of n integers, find three integers in S such that the sum is closest to a given number, target. Return the sum of the three integers. You may assume that each input would have exactly one solution.

 For example, given array S = {-1 2 1 -4}, and target = 1.

 The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).
 */
public class Solution {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int delta = Integer.MAX_VALUE;
        for(int i = 0; i < nums.length - 2; i++){
            int j = i + 1;
            int k = nums.length - 1;
            if(i > 0 && nums[i] == nums[i - 1])
                continue;
            while(j < k){
                int sum = nums[i] + nums[j] + nums[k];
                int d = sum - target;
                if(Math.abs(d) < Math.abs(delta))
                    delta = d;
                if(d == 0)
                    return target;
                else if(d > 0){
                    k--;
                    while (j < k && nums[k] == nums[k + 1]) k--;
                }else if(d < 0){
                    j++;
                    while (j < k && nums[j] == nums[j - 1]) j++;
                }
            }
        }
        return target + delta;
    }
}
