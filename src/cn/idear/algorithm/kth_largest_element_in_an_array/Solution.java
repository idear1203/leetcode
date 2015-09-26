package cn.idear.algorithm.kth_largest_element_in_an_array;

/**
 * Created by wangdongwei on 9/26/15.
 */
//TODO: 锦标赛排序、优先队列
public class Solution {

    public int findKthLargest(int[] nums, int k) {
        return findKthLargestHelper(nums, k, 0, nums.length);
    }

    private int findKthLargestHelper(int[] nums, int k, int start, int end){
        for(int i = 1; i <= k; i++){
            int index = findLargestIndex(nums, start, end);
            swap(nums, start++, index);
        }
        return nums[k - 1];
    }

    private void swap(int[] nums, int l, int r){
        int tmp = nums[l];
        nums[l] = nums[r];
        nums[r] = tmp;
    }

    private int findLargestIndex(int[] nums, int start, int end){
        int max = start;
        for(int i = start + 1; i < end; i++){
            if(nums[i] > nums[max])
                max = i;
        }
        return max;
    }
}
