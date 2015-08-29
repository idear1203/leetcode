package cn.idear.algorithm.jump_game;

/**
 * Created by wangdongwei on 8/29/15.
 */
//TODO:
public class Solution {

    public boolean canJump(int[] nums) {
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
