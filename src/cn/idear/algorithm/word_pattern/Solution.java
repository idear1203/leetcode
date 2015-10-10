package cn.idear.algorithm.word_pattern;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by idear on 15-10-10.
 */
public class Solution {
    public boolean wordPattern(String pattern, String str) {
        String[] strs = str.split(" ");
        String[] table = new String[26];
        Set<String> set = new HashSet<>();
        char[] chars = pattern.toCharArray();
        if(strs.length != chars.length) return false;
        for(int i = 0; i < strs.length; i++){
            String value = table[chars[i] - 'a'];
            if(value == null){
                if(set.contains(strs[i])) return false;
                table[chars[i] - 'a'] = strs[i];
                set.add(strs[i]);
            }else if(!value.equals(strs[i]))
                return false;
        }
        return true;
    }
}
