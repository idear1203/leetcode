package cn.idear.algorithm.longeset_valid_parenthesis;

import java.util.Arrays;
import java.util.Stack;

/**
 * Created by wangdongwei on 8/28/15.
 * Given a string containing just the characters '(' and ')', find the length of the longest valid (well-formed) parentheses substring.

 For "(()", the longest valid parentheses substring is "()", which has length = 2.

 Another example is ")()())", where the longest valid parentheses substring is "()()", which has length = 4.
 */
public class Solution {
    public int longestValidParentheses(String s) {
        Stack<Character> stack = new Stack<Character>();
        int[] count = new int[s.length()];
        int max = 0;
        /**
         * 1. 初始化count数组元素为0
         */
        Arrays.fill(count, 0);
        for(int i = 0; i < s.length(); i++){
            char current = s.charAt(i);
            /**
             * 2. 如果当前字符为左括号/栈为空/栈顶是右括号，直接压栈。
             */
            if(current == '(' || stack.isEmpty() || stack.peek() == ')'){
                stack.push(current);
            }else{
                /**
                 * 3. 否则，栈顶是左括号。
                 */
                /**
                 * 3.1 退栈。
                 */
                stack.pop();
                /**
                 * 3.2 更新新栈顶位置。
                 */
                count[stack.size()] += count[stack.size() + 1] + 2;
                /**
                 * 3.3 清除原栈顶位置count值。
                 */
                count[stack.size() + 1] = 0;
                /**
                 * 3.4 更新最大值。
                 */
                max = Math.max(max, count[stack.size()]);
            }
        }
        return max;
    }
}
