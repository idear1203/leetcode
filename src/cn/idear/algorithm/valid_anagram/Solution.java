package cn.idear.algorithm.valid_anagram;

import java.util.Arrays;

/**
 * Created by idear on 15-11-3.
 */
public class Solution {
    public boolean isAnagram(String s, String t) {
        char[] ss = s.toCharArray();
        char[] tt = t.toCharArray();
        Arrays.sort(ss);
        Arrays.sort(tt);
        return Arrays.equals(ss, tt);
    }
}
