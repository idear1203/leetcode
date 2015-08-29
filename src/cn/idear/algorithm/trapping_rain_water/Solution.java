package cn.idear.algorithm.trapping_rain_water;

/**
 * Created by wangdongwei on 8/28/15.
 * Given n non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it is able to trap after raining.

 For example,
 Given [0,1,0,2,1,0,1,3,2,1,2,1], return 6.
 */
public class Solution {
    public int trap(int[] height) {
        int[] maxLeft = new int[height.length];
        int[] maxRight = new int[height.length];
        int sum = 0;
        for(int i = 1; i < height.length; i++){
            /**
             * 计算左右最大柱子高度。
             */
            maxLeft[i] = Math.max(maxLeft[i - 1], height[i - 1]);
            maxRight[height.length - 1 - i] = Math.max(maxRight[height.length - i], height[height.length - i]);
        }
        for(int i = 1; i < height.length; i++) {
            int h= Math.min(maxLeft[i], maxRight[i]);
            if(h > height[i])
            sum += h - height[i];
        }
        return sum;
    }
}
