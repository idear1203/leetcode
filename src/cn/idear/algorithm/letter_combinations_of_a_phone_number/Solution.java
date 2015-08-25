package cn.idear.algorithm.letter_combinations_of_a_phone_number;

import java.util.List;

/**
 * Created by wangdongwei on 8/25/15.
 */
public class Solution {
    public List<String> letterCombinations(String digits) {
        return null;
    }

    private String map(char ch){
        switch (ch){
            case '2':
                return "abc";

            case '3':
                return "def";

            case '4':
                return "ghi";

            case '5':
                return "jkl";

            case '6':
                return "mno";

            case '7':
                return "pqrs";

            case '8':
                return "tuv";

            case '9':
                return "wxyz";

            default:
                return "";
        }
    }
}
