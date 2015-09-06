package cn.idear.algorithm.subsets_ii;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by idear on 15-9-6.
 * Given a collection of integers that might contain duplicates, nums, return all possible subsets.

 Note:
 Elements in a subset must be in non-descending order.
 The solution set must not contain duplicate subsets.
 */
public class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> path = new ArrayList<Integer>();
        subsetsWithDupHelper(nums, result, 0, path);
        return result;
    }

    private void subsetsWithDupHelper(int[] nums, List<List<Integer>> result, int start, List<Integer> path) {
        if(start == nums.length){
            result.add(new ArrayList<Integer>(path));
        }else{
            for(int i = start; i < nums.length; i++){
                if(i > start && nums[i] == nums[i - 1]){

                }
            }
        }
    }
}
