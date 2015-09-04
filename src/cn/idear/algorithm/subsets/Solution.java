package cn.idear.algorithm.subsets;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by wangdongwei on 9/4/15.
 *
 */
public class Solution {
   public List<List<Integer>> subsets(int[] nums){
       Arrays.sort(nums);
       List<List<Integer>> result = new ArrayList<>();
       List<Integer> path = new ArrayList<>();
       subsetsHelper(nums, result, 0, path);
       return result;
   }

    private void subsetsHelper(int[] nums, List<List<Integer>> result, int index, List<Integer> path) {
       if(index == nums.length) {
           result.add(new ArrayList<>(path));
       }else{
           /**
            * 选择index位置上的数字。
            */
           path.add(nums[index]);
           subsetsHelper(nums, result, index + 1, path);
           /**
            * 不选择index位置上的数字。
            */
           path.remove(path.size() - 1);
           subsetsHelper(nums, result, index + 1, path);
       }
    }
}
