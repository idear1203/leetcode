package cn.idear.algorithm.search_for_a_range;

import java.util.Arrays;

/**
 * Created by wangdongwei on 8/27/15.
 * Given a sorted array of integers, find the starting and ending position of a given target value.

 Your algorithm's runtime complexity must be in the order of O(log n).

 If the target is not found in the array, return [-1, -1].

 For example,
 Given [5, 7, 7, 8, 8, 10] and target value 8,
 return [3, 4].
 */
public class Solution {

    private static int[] NOT_FOUND = new int[]{-1, -1};

    public int[] searchRange(int[] nums, int target) {
        if(nums.length == 0)
            return NOT_FOUND;
        return searchRangeHelper(nums, target, 0, nums.length - 1);
    }

    private int[] searchRangeHelper(int[] nums, int target, int start, int end) {
        if(start == end) {
            if (nums[start] == target) {
                int lowBound = start;
                int highBound = start;
                while(lowBound - 1 >= 0 && nums[lowBound - 1] == target) lowBound--;
                while(highBound + 1 < nums.length && nums[highBound + 1] == target) highBound++;
                return new int[]{lowBound, highBound};
            }
        }else{
            int half = (start + end)>>1;
            if(nums[end] < target || nums[start] > target){
                return NOT_FOUND;
            }
            int[] front = searchRangeHelper(nums, target, start, half);
            if(front != NOT_FOUND)
                return front;
            return searchRangeHelper(nums, target, half + 1, end);
        }
        return NOT_FOUND;
    }

    private int[] searchRangeHelper1(int[] nums, int target, int start, int end) {
        if(start == end){
            if(nums[start] == target)
                return new int[]{start, start};
        }else{
            int half = (start + end)>>1;
            if(nums[end] < target || nums[start] > target){
                return NOT_FOUND;
            }
            int[] front = searchRangeHelper(nums, target, start, half);
            int[] next = searchRangeHelper(nums, target, half + 1, end);
            if(front == NOT_FOUND)
                return next;
            else if(next == NOT_FOUND)
                return front;
            else{
                return new int[]{front[0], next[1]};
            }
        }
        return NOT_FOUND;
    }
}
