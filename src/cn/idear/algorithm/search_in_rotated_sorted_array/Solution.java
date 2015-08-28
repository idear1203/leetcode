package cn.idear.algorithm.search_in_rotated_sorted_array;

/**
 * Created by wangdongwei on 8/28/15.
 * Suppose a sorted array is rotated at some pivot unknown to you beforehand.

 (i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).

 You are given a target value to search. If found in the array return its index, otherwise return -1.

 You may assume no duplicate exists in the array.
 */
public class Solution {
    public int search(int[] nums, int target) {
        return searchHelper(nums, target, 0, nums.length - 1);
    }

    private int searchHelper(int[] nums, int target, int start, int end) {
        if(start == end){
            if(target == nums[start])
                return start;
        }else if(start < end){
            int midpos = (start + end)>>1;
            int s = nums[start];
            int m = nums[midpos];
            int e = nums[end];
            if(target == m)
                return midpos;
            if(s <= m && m <= e){
                /**
                 * nums: 1 2 3 4 5
                 * t: 2
                 */
                if(target < m)
                    return searchHelper(nums, target, start, midpos);
                else
                    return searchHelper(nums, target, midpos + 1, end);
            }else if(s <= m && m >= e){
                /**
                 * nums: 2 3 4 5 1
                 * t: 2
                 */
                if(target > m || target < s)
                    return searchHelper(nums, target, midpos + 1, end);
                else
                    return searchHelper(nums, target, start, midpos);
            }else if(s >= m && m <= e){
                /**
                 * nums: 4 5 1 2 3
                 * t: 2
                 */
                if(target < m || target > e)
                    return searchHelper(nums, target, start, midpos);
                else
                    return searchHelper(nums, target, midpos + 1, end);
            }
        }
        return -1;
    }
}
