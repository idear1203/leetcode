package cn.idear.algorithm.jump_game;

/**
 * Created by wangdongwei on 8/29/15.
 */
public class Solution {

    public boolean canJump(int[] nums) {
        /**
         * i可以到达i+nums[i]处。
         */
        if(nums.length <= 1)
            return true;
        int target = nums.length - 1;
        /**
         * count记录可达的最远下标。
         */
        int count = 0;
        for(int i = 0; i < nums.length; i++){
            if(i <= count){
                count = Math.max(count, i + nums[i]);
                if(count >= target)
                    return true;
            }else{
                /**
                 * 说明下标i及i以后的坐标不可达。
                 */
                return false;
            }
        }
        return true;
    }

    /**
     * 超时
     * @param nums
     * @return
     */
    public boolean canJump1(int[] nums) {
        if(nums.length == 0)
            return false;
        return jumpHelper(nums, 0, nums.length - 1);
    }

    private boolean jumpHelper(int[] nums, int index, int target) {
        if(index == target){
            return true;
        }else if(index < target){
            int maxStep = nums[index];
            if(index + maxStep >= target)
                return true;
            else{
                for(int step = maxStep; step >= 1; step--){
                    if(jumpHelper(nums, index + step, target))
                        return true;
                }
            }
        }
        return false;
    }
}
