package cn.idear.algorithm.three_sum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by wangdongwei on 8/26/15.
 Given an array S of n integers, are there elements a, b, c in S such that a + b + c = 0? Find all unique triplets in the array which gives the sum of zero.

 Note:
 Elements in a triplet (a,b,c) must be in non-descending order. (ie, a ≤ b ≤ c)
 The solution set must not contain duplicate triplets.
 */
public class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> rstList = new ArrayList<List<Integer>>();
        Arrays.sort(nums);
        for(int i = 0; i < nums.length; i++){
            if(i > 0 && nums[i] == nums[i - 1])
                continue;
            int j = i + 1;
            int k = nums.length - 1;
            while(j < k){
                if(nums[i] + nums[j] + nums[k] > 0){
                    k--;
                    while(k > j && nums[k] == nums[k + 1]) k--;
                }else if(nums[i] + nums[j] + nums[k] < 0){
                    j++;
                    while(j < k && nums[j] == nums[j - 1]) j++;
                }else{
                    /**
                     * 学习Arrays.asList
                     */
                    rstList.add(Arrays.asList(nums[i],nums[j],nums[k]));
                    k--;
                    j++;
                    while(k > j && nums[k] == nums[k + 1]) k--;
                    while(k > j && nums[j] == nums[j - 1]) j++;
                }
            }
        }
        return rstList;
    }
}
