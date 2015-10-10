package cn.idear.algorithm.contains_duplicate;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by wangdongwei on 10/8/15.
 */
public class Solution {
    // public boolean containsDuplicate(int[] nums) {
    //     if(nums.length < 2) return false;
    //     Arrays.sort(nums);
    //     for(int i = 1; i < nums.length; i++)
    //         if(nums[i] == nums[i - 1])
    //             return true;
    //     return false;
    // }

    public boolean containsDuplicate(int[] nums){
        Set<Integer> set = new HashSet<>();
        for(int num : nums){
            if(set.contains(num))
                return true;
            set.add(num);
        }
        return false;
    }
}
