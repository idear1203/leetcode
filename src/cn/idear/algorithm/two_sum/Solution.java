package cn.idear.algorithm.two_sum;

import java.util.HashMap;

/**
 Given an array of integers, find two numbers such that they add up to a specific target number.

 The function twoSum should return indices of the two numbers such that they add up to the target, where index1 must be less than index2. Please note that your returned answers (both index1 and index2) are not zero-based.

 You may assume that each input would have exactly one solution.

 Input: numbers={2, 7, 11, 15}, target=9
 Output: index1=1, index2=2
 */
public class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for(int i = 0; i < nums.length; i++){
            /**
             * 建立从target-nums[i]到i的映射。
             * target-nums[i]是距离target所差的数。
             * 7--0
             * 2--1
             * -2--2
             * -6--3
             */
            map.put(target - nums[i], i);
        }
        for(int i = 0; i < nums.length; i++){
            Integer v = map.get(nums[i]);
            if(v != null && v != i){
                /**
                 * 说明v所对应的下标的数字差num[i]。
                 * 因为nums是从小到大排列的，因而map是从大到小插入的。
                 * 因而key越小，对应的下标越大。
                 */
                return new int[]{i + 1, v + 1};
            }
        }
        throw  new RuntimeException();
    }
}
