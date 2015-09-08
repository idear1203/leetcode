package cn.idear.algorithm.sort_colors;

import java.util.Arrays;

/**
 * Created by idear on 15-9-6.
 * Given an array with n objects colored red, white or blue, sort them so that objects of the same color are adjacent, with the colors in the order red, white and blue.

 Here, we will use the integers 0, 1, and 2 to represent the color red, white, and blue respectively.

 Note:
 You are not suppose to use the library's sort function for this problem.
 */
public class Solution {
    /**
     * 针对本题只有三个元素的特殊性，可以使用夹逼法
     */
    public void sortColors(int[] nums) {
        int red = 0, blue = nums.length - 1;
        for(int i = 0; i <= blue;){
            /**
             * 注意i++的触发时间。往前换是安全的，往后换是不安全的。例如可能把后面的0换到前面来。
             * nums: 0      2       1       0
             *       red    i               blue
             */
           if(nums[i] == 0)
               swap(nums, red++, i++);
            else if(nums[i] == 2)
               swap(nums, blue--, i);
            else i++;
        }
    }

    private void swap(int[] nums, int left, int right) {
        int tmp = nums[left];
        nums[left] = nums[right];
        nums[right] = tmp;
    }

    /**
     * 计数排序。
     * 因为只有0,1,2，因此可以记录每种数字出现的频数。然后根据频数对数组进行重新赋值。
     * @param nums
     */
    public void sortColors2(int[] nums) {
        int[] count = new int[]{0, 0, 0};
        for(int i = 0; i < nums.length; i++)
            count[nums[i]]++;
        int s = 0;
        for(int i = 0; i < 3; i++)
            for(int j = 0; j < count[i]; j++)
                nums[s++] = i;
    }
    /**
     * Accepted.
     * @param nums
     */
    public void sortColors1(int[] nums) {
        Arrays.sort(nums);
    }
}
