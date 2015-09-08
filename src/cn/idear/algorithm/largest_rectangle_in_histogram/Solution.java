package cn.idear.algorithm.largest_rectangle_in_histogram;

import java.util.Arrays;
import java.util.Stack;

/**
 * Created by wangdongwei on 9/8/15.
 * TODO: NOT ACCEPTED.
 */
public class Solution {
    public int largestRectangleArea(int[] height) {
        height = Arrays.copyOf(height, height.length + 1);
        height[height.length - 1] = 0;
        /**
         * 栈元素s, 右侧高度都至少为s+1。
         */
        Stack<Integer> stack = new Stack<>();
        int result = 0;
        for(int i = 0; i < height.length;){
            /**
             * 第一次提交写的>，一串1的时候会超时。
             */
           if(stack.isEmpty() || height[i] >= height[stack.peek()]){
               /**
                * 当新的矩形高度比栈内现有矩形高度大时，入栈。
                */
               stack.push(i);
               i++;
           }else {
               /**
                * 说明，当前height小于栈顶height。根据栈顶height更新最大高度。
                 */
                int peek = stack.pop();
               int width;
               /**
                * 栈为空，说明i位置对应的高度是遇到的最小高度。
                */
               if(stack.isEmpty())
                   width = i;
               else {
                   /**
                    * 退栈后，当前栈顶是第一处不大于原栈顶高度的位置。
                    * 也就是从当前栈顶+1处开始到i-1的坐标的高度都不小于原栈顶位置高度
                    * 考虑[3, 2, 5]。原来想的是原栈顶的左端点，是不正确的。对于最大为2的矩形，左端点从下标0就开始了。
                    */
                   width = i - 1 - (stack.peek() + 1) + 1;
               }
               result = Math.max(result, height[peek] * width);
           }
        }
        return result;
    }
}
