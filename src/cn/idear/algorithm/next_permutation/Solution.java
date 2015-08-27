package cn.idear.algorithm.next_permutation;

/**
 * Created by wangdongwei on 8/27/15.
 * Implement next permutation, which rearranges numbers into the lexicographically next greater permutation of numbers.

 If such arrangement is not possible, it must rearrange it as the lowest possible order (ie, sorted in ascending order).

 The replacement must be in-place, do not allocate extra memory.

 Here are some examples. Inputs are in the left-hand column and its corresponding outputs are in the right-hand column.
 1,2,3 → 1,3,2
 3,2,1 → 1,2,3
 1,1,5 → 1,5,1
 */
public class Solution {
    public void nextPermutation(int[] nums) {
        if(nums.length <= 1)
            return;
        /**
         * 1.从右向左找到降序的第一个数字。
         */
        int index = findFirstDecreaseNumber(nums);
        /**
         * 如果找不到，说明目前的排列已经是最大的数字，如321。跳过2，直接将其逆序。
         */
        if(index != -1) {
            /**
             * 2. 从右向左找到第一个比这个数字大的数字。 231，找到3.
             */
            int bigger = findFirstLargerNumber(nums, index);
            /**
             * 3.交换两个数字。
             */
            swap(nums, index, bigger);
        }
        /**
         * 翻转index右侧的数字。
         */
        reverse(nums, index + 1);
    }

    private void reverse(int[] nums, int start) {
        /**
         * 第一次提交交换次数计算有误。0...start - 1总共start个数字，因此从start...length - 1总共length - start个数字。`
         int times = (nums.length - 1 -  start) / 2;
         */
        int times = (nums.length - start) / 2;
        for(int i = 0; i < times; i++){
           swap(nums, start + i, nums.length - 1 - i);
        }
    }

    private void swap(int[] nums, int l, int r) {
        int tmp = nums[l];
        nums[l] = nums[r];
        nums[r] = tmp;
    }

    private int findFirstLargerNumber(int[] nums, int index) {
        int pivot = nums[index];
        for(int i = nums.length - 1; i >= 0; i--){
            if(nums[i] > pivot)
                return i;
        }
        assert false;
        return 0;
    }

    private int findFirstDecreaseNumber(int[] nums) {
        for(int i = nums.length - 1; i >= 0; i--){
            if(i < nums.length - 1){
               if(nums[i] < nums[i + 1])
                   return i;
            }
        }
        return -1;
    }
}
