package cn.idear.algorithm.find_peak_element;

/**
 * Created by wangdongwei on 10/2/15.
 */
public class Solution {
    /**
     * O(n)
     */
    public int findPeakElement1(int[] nums) {
        if(nums.length == 1)
            return 0;
        if(nums[0] > nums[1])
            return 0;
        if(nums[nums.length - 1] > nums[nums.length - 2])
            return nums.length - 1;
        for(int i = 1; i < nums.length - 1; i++)
            if(nums[i] > nums[i - 1] && nums[i] > nums[i + 1])
                return i;
        throw new RuntimeException();
    }

    /**
     * 二分法找数组最大值，O(log n)，最大值一定是极大值
     */
    public int findPeakElement(int[] nums) {
        return findPeakElementHelper(nums, 0, nums.length);
    }

    public int findPeakElementHelper(int[] nums, int start, int end){
        /**
         * 数组元素个数为1
         */
        if(start == end - 1)
            return start;
        else{
            int mid = start + (end - start) / 2;
            int l = findPeakElementHelper(nums, start, mid);
            int r = findPeakElementHelper(nums, mid, end);
            return nums[l] > nums[r] ? l : r;
        }
    }
}
