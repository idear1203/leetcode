package cn.idear.algorithm.implement_strstr;

/**
 * Created by wangdongwei on 8/26/15.
 *
 * Implement strStr().

 Returns the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.

 Update (2014-11-02):
 The signature of the function had been updated to return the index instead of the pointer.
 If you still see your function signature returns a char * or String, please click the reload button  to reset your code definition.
 */
//TODO:
public class Solution {
    /**
     * Accepted. - -||.
     * @param haystack
     * @param needle
     * @return
     */
    public int strStr(String haystack, String needle) {
        return haystack.indexOf(needle);
    }
}
