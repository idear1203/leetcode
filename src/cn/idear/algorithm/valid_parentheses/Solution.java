package cn.idear.algorithm.valid_parentheses;

import java.util.Stack;

/**
 * Created by wangdongwei on 8/25/15.
 * Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.

 The brackets must close in the correct order, "()" and "()[]{}" are all valid but "(]" and "([)]" are not
 */
public class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<Character>();
        for(int i = 0; i < s.length(); i++){
            char ch = s.charAt(i);
            if(ch == '(' || ch == '{' || ch == '[')
                stack.push(ch);
            else{
                if(stack.isEmpty())
                    return false;
                char peek = stack.peek();
                if(ch == ')'){
                    if(peek != '(')
                        return false;
                }else if(ch == '}'){
                   if(peek != '{')
                       return false;
                }else if(ch == ']'){
                    if(peek != '[')
                        return false;
                }
                stack.pop();
            }
        }
        return stack.isEmpty();
    }
}
