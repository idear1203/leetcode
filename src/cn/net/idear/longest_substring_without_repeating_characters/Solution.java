package cn.net.idear.longest_substring_without_repeating_characters;

import java.util.Arrays;

/**
 * Created by wangdongwei on 8/24/15.
 Given a string, find the length of the longest substring without repeating characters.
 For example, the longest substring without repeating letters for "abcabcbb" is "abc", which the length is 3.
 For "bbbbb" the longest substring is "b", with the length of 1.
 */
public class Solution {

    /**
     * 提交导致runtime error,原因是原来认为测试数据中只有小写字符构成的串，而实际上还有大写字母数字等
     private static final int MAX_ALPHABET = 26;
     */
    private static final int MAX_ASCII = 128;

    public int lengthOfLongestSubstring(String s) {
        /**
         * last用来记录一个字母最后出现的位置。这是这道题的精髓。
         * 如abcabcbb在结束时，last['a'] = 3， last['b'] = 7
         */
        int[] last = new int[MAX_ASCII];
        /**
         * start用以记录当前最长子串的起始下标。
         * 因为不允许有重复的字母，因而新的迭代从last[alphabet] + 1开始。
         */
        int start = 0;
        int maxLen = 0;
        Arrays.fill(last, -1);

        for(int i = 0; i < s.length(); i++){
            char ch = s.charAt(i);
            /**
             * 初版代码的判断条件是，是错误的。if(ch == s.charAt(start))
             * 这个判断是用来判断当前的字母是否在最长子串中出现过。s.charAt(start)相当于仅仅比较了最长子串的首字母，而没有与
             * 最长子串中间的字母进行比较。实际上当if(last[ch] >= start)时都说明当前字母已经出现过
             * eg: abcabcbb 当i=6时，此时last['b']=4。如果按照第一种判断方法，则会误认为字母b没有出现过，导致错误。
             *
             * run algorithm, idear!
             */
            if(last[ch] >= start){
                maxLen = Math.max(maxLen, i - start);
                start = last[ch] + 1;
            }
            /**
             * 初版代码每次都对maxLen进行更新，这是没有必要的，只是等价于+1罢了。
             */
//            else{
//               maxLen = Math.max(maxLen, i - start + 1);
//            }
            last[ch] = i;
        }
        /**
         * 对于"abcd"，如果不加最后一次比较会返回0。注意边界！
         */
        return Math.max(maxLen, s.length() - start);
    }
}
