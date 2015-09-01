package cn.idear.algorithm.remove_duplicates_from_sorted_array_ii;

import java.util.Arrays;

/**
 * Created by wangdongwei on 8/31/15.
 */
public class Solution {
    public int removeDuplicates(int[] nums) {
        if(nums.length <= 2)
            return nums.length;
        int length = 0;
        for(int i = 0; i < nums.length; i++){
            if(length < 2 || nums[i] != nums[length - 2])
                nums[length++] = nums[i];
        }
        return length;
    }
}
