package cn.idear.algorithm.product_of_array_except_self;

/**
 * Created by idear on 15-11-3.
 */
public class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] result = new int[nums.length];
        if(nums.length == 0)
            return result;
        result[0] = 1;
        /**
         * result[i] = nums[0] * ... * nums[i - 1];
         */
        for(int i = 1; i < nums.length; i++)
            result[i] = result[i - 1] * nums[i - 1];
        int tmp = nums[nums.length - 1];
        /**
         * 用一个临时变量存储nums[i+1]....nums[n - 1]
         */
        for(int i = nums.length - 2; i >= 0; i--){
            result[i] *= tmp;
            tmp *= nums[i];
        }
        return result;
    }
}
