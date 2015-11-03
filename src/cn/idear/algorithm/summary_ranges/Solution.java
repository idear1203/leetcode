package cn.idear.algorithm.summary_ranges;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by idear on 15-11-3.
 */
public class Solution {
    public List<String> summaryRanges(int[] nums) {
        List<String> result = new ArrayList<>();
        if(nums.length == 0) return result;
        int slow = 0, fast;
        for(fast = 1; fast < nums.length; fast++){
            if(nums[fast] > nums[fast - 1] + 1){
                if(fast > slow + 1){
                    result.add(nums[slow] + "->" + nums[fast - 1]);
                }else{
                    result.add(String.valueOf(nums[slow]));
                }
                slow = fast;
            }
        }
        if(slow < fast){
            if(slow < nums.length - 1)
                result.add(String.valueOf(nums[slow]) + "->" + nums[nums.length - 1]);
            else
                result.add(String.valueOf(nums[slow]));
        }
        return result;
    }

    public List<String> summaryRanges1(int[] nums) {
        List<String> result = new ArrayList<>();
        for(int i = 0; i < nums.length; i++){
            int pre = nums[i];
            for(; i + 1 < nums.length && nums[i + 1] == nums[i] + 1; i++);
            if(nums[i] != pre)
                result.add(String.valueOf(pre) + "->" + nums[i]);
            else
                result.add(String.valueOf(pre));
        }
        return result;
    }
}
