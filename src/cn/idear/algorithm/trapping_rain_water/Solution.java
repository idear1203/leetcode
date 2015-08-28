package cn.idear.algorithm.trapping_rain_water;

import java.util.Arrays;
import java.util.Stack;

/**
 * Created by wangdongwei on 8/28/15.
 */
//TODO:
public class Solution {
    public int trap(int[] height) {
        /**
         * stack用来存当前的左墙高度。
         */
        Stack<Integer> stack = new Stack<Integer>();
        int[] index = new int[height.length];
        int max = 0;
        Arrays.fill(index, 0);
        for(int i = 0; i < height.length; i++){
            int wall = height[i];
            if(wall > 0){
                if (stack.isEmpty()) {
                    stack.push(wall);
                    index[stack.size()] = i;
                }
                else{
                    int peek = stack.peek();
                    if(wall >= peek){
                        max += (wall - peek) * (i - index[stack.size()] - 1);
                        stack.pop();
                        index[stack.size()] = 0;
                        /**
                         * 新栈顶 = 新栈顶 - peek高度。
                         */
                        while(!stack.isEmpty()){
                            int newPeek = stack.pop();
                            if(newPeek <= peek){
                                index[stack.size() + 1] = 0;
                            }else{
                                stack.push(newPeek - peek);
                                break;
                            }
                        }
                    }
                }
            }
        }
        return max;
    }
}
