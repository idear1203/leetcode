package cn.idear.algorithm.find_minimum_in_rotated_sorted_array_ii;

/**
 * Created by wangdongwei on 8/28/15.
 */
public class Solution {
    public int findMin(int[] nums) {
        return findMinHelper(nums, 0, nums.length - 1);
    }

    private int findMinHelper(int[] nums, int start, int end) {
        if(start == end)
            return nums[start];
        else if(start == end - 1)
            return Math.min(nums[start], nums[end]);
        else{
            int mid = (start + end) >> 1;
            int s = nums[start];
            int e = nums[end];
            int m = nums[mid];
            if(s < e){
                /**
                 * 没有旋转。
                 */
                return s;
            }else if(s > e){
                /**
                 * s e不等，则与无重复元素等同。
                 */
                if(s <= m)
                    return findMinHelper(nums, mid + 1, end);
                else
                    return findMinHelper(nums, start, mid);
            }
            else{
                return Math.min(s, findMinHelper(nums, start + 1, end - 1));
            }
        }
    }
}
