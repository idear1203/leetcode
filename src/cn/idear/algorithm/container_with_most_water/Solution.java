package cn.idear.algorithm.container_with_most_water;

/**
 * Created by wangdongwei on 8/25/15.
 */
public class Solution {
    public int maxArea(int[] height) {
        if(height.length < 2)
            return 0;
        int rst = 0;
        for(int i = 0, j = height.length - 1; i < j;){
            int shortLine = Math.min(height[i], height[j]);
            int area =  shortLine * (j - i);
            if(area > rst) rst = area;
            if(shortLine == height[i])
                i++;
            else
                j--;
        }
        return rst;
    }
}
