package cn.idear.algorithm.valid_palindrome;

/**
 * Created by wangdongwei on 9/26/15.
 */
public class Solution {
    public boolean isPalindrome(String s) {
        int len = s.length();
        if(len == 0)
            return true;
        int start = 0, end = len - 1;
        while(start < end){
            while(start < end && !Character.isLetterOrDigit(s.charAt(start))) start++;
            while(start < end && !Character.isLetterOrDigit(s.charAt(end))) end--;
            if(start < end) {
                if (Character.toLowerCase(s.charAt(start)) != Character.toLowerCase(s.charAt(end)))
                    return false;
                else {
                    start++;
                    end--;
                }
            }
        }
        return true;
    }
}
