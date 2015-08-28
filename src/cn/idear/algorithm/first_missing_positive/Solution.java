package cn.idear.algorithm.first_missing_positive;

/**
 * Created by wangdongwei on 8/28/15.
 * Given an unsorted integer array, find the first missing positive integer.

 For example,
 Given [1,2,0] return 3,
 and [3,4,-1,1] return 2.

 Your algorithm should run in O(n) time and uses constant space.
 */
public class Solution {
    public int firstMissingPositive(int[] nums) {
        /**
         * 桶排序
         */
        for(int i = 0; i < nums.length; i++){
            while(nums[i] != i + 1){
                if(nums[i] < 1 || nums[i] > nums.length || nums[i] == nums[nums[i] - 1])
                    break;
                /**
                 * nums[i]对应的数字应该放在nums[i]-1位置。
                 * eg: nums[i] = 3
                 * 3应该放在num[2]处。
                 */
                swap(nums, i, nums[i] - 1);
            }
        }
        for(int i = 0; i < nums.length; i++){
            /**
             * 第一次提交写的是if(nums[i] < 1 || nums[i] > nums.length)
             * 对于重复元素的情形结果不正确，eg[1,1]
             */
            if(nums[i] != i + 1)
                return i + 1;
        }
        return nums.length + 1;
    }

    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
