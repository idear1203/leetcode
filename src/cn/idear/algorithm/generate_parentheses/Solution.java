package cn.idear.algorithm.generate_parentheses;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by wangdongwei on 8/26/15.
 * Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.

 For example, given n = 3, a solution set is:

 "((()))", "(()())", "(())()", "()(())", "()()()"
 */
public class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> rst = new ArrayList<String>();
        generateParenthesisHelper(n, rst, "", 0, 0);
        return rst;
    }

    private void generateParenthesisHelper(int n, List<String> rst, String s, int l, int r) {
        if(l == n) {
            for(int i = r; i < l; i++)
               s += ")";
            rst.add(s);
        }else{
                generateParenthesisHelper(n, rst, s + "(", l + 1, r);
            if(l > r)
                generateParenthesisHelper(n, rst, s + ")", l , r + 1);
        }
    }
}
