package cn.idear.algorithm.search_in_rotated_sorted_array_ii;

/**
 * Created by wangdongwei on 8/28/15.
 * Follow up for "Search in Rotated Sorted Array":
 What if duplicates are allowed?

 Would this affect the run-time complexity? How and why?

 Write a function to determine if a given target is in the array.
 */
public class Solution {
    public boolean search(int[] nums, int target) {
        return searhHelper(nums, target, 0, nums.length - 1);
    }

    private boolean searhHelper(int[] nums, int target, int start, int end){
        if(start == end)
            return target == nums[start];
        else if(start < end){
            int midpos = (start + end) >> 1;
            int s = nums[start];
            int e = nums[end];
            int m = nums[midpos];
            if(target == m)
                return true;
            else if(target < m){
                if(s < m){
                    /**
                     * 前半段是非递减序列
                     */
                    if(target < s)
                        return searhHelper(nums, target, midpos + 1, end);
                    else
                        return searhHelper(nums, target, start, midpos - 1);
                }else if(s > m){
                    /**
                     * 比m小的都在前半段。
                     */
                    return searhHelper(nums, target, start, midpos - 1);
                }else if(s == m){
                    /**
                     * 不能确定是什么情况，往中间夹逼
                     */
                    return searhHelper(nums, target, start + 1, end);
                }
            }
            else{ // if(target > m)
                if(m < e){
                    /**
                     * 说明后半段是非递减序列
                     */
                    if(target > e)
                        return searhHelper(nums, target, start, midpos - 1);
                    else
                        return searhHelper(nums, target, midpos + 1, end);
                }else if(m > e){
                    /**
                     * 说明比m大的都在后半段
                     */
                    return searhHelper(nums, target, midpos + 1, end);
                }else{  //if(m == e)
                    return searhHelper(nums, target, start, end - 1);
                }
            }
        }
        return false;
    }

    /**
     * Accepted
     * @param nums
     * @param target
     * @param start
     * @param end
     * @return
     */
    private boolean searhHelper1(int[] nums, int target, int start, int end){
        if(start == end){
            if(target == nums[start])
                return true;
        }else if(start < end){
            int midpos = (start + end) / 2;
            int m = nums[midpos];
            if(target == m)
                return true;
            boolean rst = searhHelper1(nums, target, start, midpos);
            if(rst)
                return true;
            return searhHelper1(nums, target, midpos + 1, end);
        }
        return false;
    }
}
