package cn.idear.algorithm.substring_with_concatenation_of_all_words;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by wangdongwei on 8/27/15.
 * You are given a string, s, and a list of words, words, that are all of the same length. Find all starting indices of substring(s) in s that is a concatenation of each word in words exactly once and without any intervening characters.

 For example, given:
 s: "barfoothefoobarman"
 words: ["foo", "bar"]

 You should return the indices: [0,9].
 (order does not matter).
 */
public class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> result = new ArrayList<Integer>();
        if(words.length == 0)
            return result;
        Map<String, Integer> map = initializeMap(words);
        int wordLength = words[0].length();
        int concatLength = wordLength * words.length;
        int slen = s.length();
        if(slen < concatLength)
            return result;
        for(int i = 0; i <= slen - concatLength; i++){
            if(isMatched(s, map, i, concatLength, wordLength)){
                result.add(i);
            }
        }
        return result;
    }

    private boolean isMatched(String s, Map<String, Integer> map, int start, int concatLength, int wordLength) {
        Map<String, Integer> unused = new HashMap<String, Integer>();
        unused.putAll(map);
        for(int j = start; j < start + concatLength; j += wordLength){
            String sub = s.substring(j, j + wordLength);
            Integer val = unused.get(sub) ;
            if(val == null)
                return false;
            if(val == 1)
                unused.remove(sub);
            else
                unused.put(sub, val - 1);
        }
        return unused.size() == 0;
    }


    private Map<String, Integer> initializeMap(String[] words) {
        Map<String, Integer> map =  new HashMap<String, Integer>();
        for(int i = 0; i < words.length; i++){
            Integer val = map.get(words[i]);
            if(val == null){
                map.put(words[i], 1);
            }else{
                map.put(words[i], val + 1);
            }
        }
        return map;
    }
}
