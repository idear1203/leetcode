package cn.idear.algorithm.majority_element_ii;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by wangdongwei on 10/2/15.
 */
public class Solution {
    public List<Integer> majorityElement(int[] nums) {
        if(nums.length == 0)
            return Collections.emptyList();
        /**
         * 满足题意的最多只有两个元素。
         */
        int[] candidates = new int[]{nums[0], nums[0]};
        int[] counters = new int[]{0, 0};
        for(int i = 0; i < nums.length; i++){
            if(counters[0] <= 0 && nums[i] != candidates[1]){
                counters[0] = 1;
                candidates[0] = nums[i];
            }else if(counters[1] <= 0 && nums[i] != candidates[0]){
                counters[1] = 1;
                candidates[1] = nums[i];
            }else if(nums[i] == candidates[0]){
                counters[0]++;
            }else  if(nums[i] == candidates[1]){
                counters[1]++;
            }else{ // if nums[i] != candidate[0..1] && counter[0..1] > 0
                counters[0]--;
                counters[1]--;
            }
        }
        /**
         * 测试用例[2, 2, 1, 3]无法通过。注意这里的counter只是票数，而非元素在数组中出现的频数。票数表示最可能作为结果的值。
         */
//        List<Integer> result = new ArrayList<>();
//        if(counters[0] > nums.length / 3)
//            result.add(candidates[0]);
//        if(counters[1] > nums.length / 3 && candidates[1] != candidates[0])
//            result.add(candidates[1]);
        /**
         * 正确解法
         */
        List<Integer> result = new ArrayList<>();
        counters[0] = counters[1] = 0;
        for(int i = 0; i < nums.length; i++){
            if(nums[i] == candidates[0])
                counters[0]++;
            else if(nums[i] == candidates[1])
                counters[1]++;
        }
        if(counters[0] > nums.length / 3)
            result.add(candidates[0]);
        if(counters[1] > nums.length / 3)
            result.add(candidates[1]);
        return result;
    }
}
