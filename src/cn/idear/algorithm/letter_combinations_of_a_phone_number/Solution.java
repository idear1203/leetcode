package cn.idear.algorithm.letter_combinations_of_a_phone_number;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by wangdongwei on 8/25/15.
 * Given a digit string, return all possible letter combinations that the number could represent.

 A mapping of digit to letters (just like on the telephone buttons) is given below.
 */
public class Solution {
    private  static final String[] phone = {" ", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
    public List<String> letterCombinations(String digits) {
        List<String> paths = new ArrayList<String>();
        letterCombinationsHelper(digits, 0, paths, "");
        return paths;
    }

    private void letterCombinationsHelper(String digits, int i, List<String> paths, String s) {
        if(i == digits.length()) {
            if(s.length() > 0)
                paths.add(s);
        }else{
            String alpha = phone[digits.charAt(i) - '0'];
            for(int j = 0; j < alpha.length(); j++) {
                letterCombinationsHelper(digits, i + 1, paths, s + alpha.charAt(j));
            }
        }
    }
}
