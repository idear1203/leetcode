package cn.idear.algorithm.isomorphic_strings;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created by wangdongwei on 10/7/15.
 */
public class Solution {
    public boolean isIsomorphic(String s, String t) {
        Map<Character, Character> map = new HashMap<>();
        Set<Character> set = new HashSet<>();
        char[] ss = s.toCharArray();
        char[] tt = t.toCharArray();
        for(int i = 0; i < ss.length; i++){
            Character target = map.get(ss[i]);
            if(target == null){
                if(!set.contains(tt[i])){
                    map.put(ss[i], tt[i]);
                    set.add(tt[i]);
                }
                else
                    return false;
            }
            else if(target != tt[i])
                return false;
        }
        return true;
    }
}
