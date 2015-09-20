package cn.idear.algorithm.move_zeros;

/**
 * Created by wangdongwei on 9/20/15.
 */
public class Solution {
    public void moveZeroes(int[] nums) {
        int s = 0;
        for(int i = 0; i < nums.length; i++){
            if(nums[i] != 0)
                nums[s++] = nums[i];
        }
        for (int i = s; i < nums.length; i++)
            nums[i] = 0;
    }
}
