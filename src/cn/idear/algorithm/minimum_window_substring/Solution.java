package cn.idear.algorithm.minimum_window_substring;

/**
 * Created by wangdongwei on 10/10/15.
 */
public class Solution {
    public String minWindow(String s, String t) {
        if(t.length() == 0 || s.length() < t.length()) return "";
        char[] ss = s.toCharArray();
        char[] tt = t.toCharArray();
        int[] countT = new int[256];
        int[] countS = new int[256];
        boolean found = false;
        int slow = 0;
        int total = 0;
        int from = 0;
        int to = 1;
        int min = Integer.MAX_VALUE;
        /**
         * countT用以计数t中每个字符出现的频数
         */
        for(int i = 0; i < tt.length; i++)
            countT[tt[i]]++;
        for(int fast = 0; fast < ss.length; fast++){
            /**
             * 如果ss[fast]在t串中出现，total++;
             */
            if(countS[ss[fast]]++ < countT[ss[fast]]) total++;
            if(total == tt.length && !found)
                found = true;
            while(total == tt.length){
                if(min > fast - slow + 1){
                    min = fast - slow + 1;
                    from = slow;
                    to = fast + 1;
                }
                if(--countS[ss[slow]] < countT[ss[slow]])
                    total--;
                slow++;
            }
        }
        return found ? s.substring(from, to) : "";
    }
}
