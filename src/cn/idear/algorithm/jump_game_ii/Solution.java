package cn.idear.algorithm.jump_game_ii;

import java.util.Arrays;

/**
 * Created by wangdongwei on 8/29/15.
 * Given an array of non-negative integers, you are initially positioned at the first index of the array.

 Each element in the array represents your maximum jump length at that position.

 Your goal is to reach the last index in the minimum number of jumps.

 For example:
 Given array A = [2,3,1,1,4]

 The minimum number of jumps to reach the last index is 2. (Jump 1 step from index 0 to 1, then 3 steps to the last index.)
 */
//TODO:
public class Solution {

    /**
     * 超时
     * @param nums
     * @return
     */
      public int jump(int[] nums){
          int n = nums.length;
          if(n == 0)
              return 0;
          int[] jumps = new int[nums.length];
          Arrays.fill(jumps, Integer.MAX_VALUE);
          jumps[nums.length - 1] = 0;
          for(int i = nums.length - 2; i >= 0; i--){
              int maxStep = nums[i];
              /**
               * 一步之遥
               */
              if(i + maxStep >= n)
                  jumps[i] = 1;
              else{
                  /**
                   * 1 + nums[i+j]步之遥。
                   */
                  for(int j = maxStep; j >= 1; j--){
                      if(nums[i + j] < Integer.MAX_VALUE){
                          /**
                           * i + j位置可以到达终点。
                           */
                          nums[i] = Math.min(nums[i], 1 + nums[i + j]);
                      }
                  }
              }
          }
          return jumps[0];
      }

//    private int minJump = Integer.MIN_VALUE;
//
//    /**
//     * 超时。
//     */
//    public int jump(int[] nums) {
//        if(nums.length == 0)
//            return 0;
//        return jumpHelper(nums, 0, 0, nums.length - 1);
//    }
//
//    private int jumpHelper(int[] nums,  int curJump, int index, int target) {
//        if(index == target){
//            if(curJump < minJump)
//                minJump = curJump;
//        }else if(index < target){
//            int maxStep = nums[index];
//            if(index + maxStep >= target)
//                return jumpHelper(nums, curJump + 1, target, target);
//            else{
//                for(int step = maxStep; step >= 1; step--){
//                    jumpHelper(nums, curJump + 1, index + step, target);
//                }
//            }
//        }
//        return minJump;
//    }
}
