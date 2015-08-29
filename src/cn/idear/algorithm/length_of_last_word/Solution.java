package cn.idear.algorithm.length_of_last_word;

/**
 * Created by wangdongwei on 8/29/15.
 */
public class Solution {
    public int lengthOfLastWord(String s) {
        s = s.trim();
        if(s.length() == 0)
            return 0;
        int index = s.lastIndexOf(' ');
        if(index == -1)
            return s.length();
        else
            return s.length() - index - 1;
    }
}
