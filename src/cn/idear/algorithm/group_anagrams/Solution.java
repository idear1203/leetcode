package cn.idear.algorithm.group_anagrams;

import java.util.*;

/**
 * Created by wangdongwei on 8/28/15.
 * Given an array of strings, group anagrams together.

 For example, given: ["eat", "tea", "tan", "ate", "nat", "bat"],
 Return:

 [
 ["ate", "eat","tea"],
 ["nat","tan"],
 ["bat"]
 ]
 */
public class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for(String str :strs){
            char[] array = str.toCharArray();
            Arrays.sort(array);
            String key = new String(array);
            List<String> list = map.get(key);
            if(list == null){
                list = new ArrayList<>();
                map.put(key, list);
            }
            list.add(str);
        }
        List<List<String>> result = new ArrayList<>();
        result.addAll(map.values());
        for(int i = 0; i < result.size(); i++)
            Collections.sort(result.get(i));
        return result;
    }
}
