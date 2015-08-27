package cn.idear.algorithm.search_insert_position;

/**
 * Created by wangdongwei on 8/27/15.
 * Given a sorted array and a target value, return the index if the target is found. If not, return the index where it would be if it were inserted in order.

 You may assume no duplicates in the array.

 Here are few examples.
 [1,3,5,6], 5 → 2
 [1,3,5,6], 2 → 1
 [1,3,5,6], 7 → 4
 [1,3,5,6], 0 → 0
 */
public class Solution {


    public int searchInsert(int[] nums, int target) {
        if(nums.length == 0)
            return 0;
        return searchInsertHelper(nums, target, 0, nums.length - 1);
    }

    int searchInsertHelper(int[] nums, int target, int start, int end){
        if(start == end){
            if(target <= nums[start])
                return start;
        }
        else if(target > nums[end])
            return end + 1;
        else{
            int half = (start + end)>>1;
            int rst = searchInsertHelper(nums, target, start, half);
            if(rst != half + 1)
                return rst;
            return searchInsertHelper(nums, target, half + 1, end);
        }
        return end + 1;
    }
    /**
     * Accepted.
     * @param nums
     * @param target
     * @return
     */
    public int searchInsert1(int[] nums, int target) {
        int i;
        for(i = 0; i < nums.length; i++){
           if(nums[i] >= target)
               return i;
        }
        return i;
    }
}
