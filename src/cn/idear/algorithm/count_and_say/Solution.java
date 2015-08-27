package cn.idear.algorithm.count_and_say;

/**
 * Created by wangdongwei on 8/27/15.
 */
public class Solution {
    public String countAndSay(int n) {
        if(n == 0)
            return "";
        else if(n == 1)
            return "1";
        else{
            String s = countAndSay(n - 1);
            StringBuilder sb = new StringBuilder();
            for(int i = 0; i < s.length();) {
                int next = getNext(s, i);
                /**
                 * count and say.
                 */
                sb.append(next - i).append(s.charAt(i));
                i = next;
            }
            return  sb.toString();
        }
    }

    private int getNext(String s, int start) {
        int pivot = s.charAt(start);
        for(int i = start + 1; i < s.length(); i++)
            if(pivot != s.charAt(i))
                return i;
        return s.length();
    }
}
