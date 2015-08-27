package cn.idear.algorithm.count_and_say;

/**
 * Created by wangdongwei on 8/27/15.
 * The count-and-say sequence is the sequence of integers beginning as follows:
 1, 11, 21, 1211, 111221, ...

 1 is read off as "one 1" or 11.
 11 is read off as "two 1s" or 21.
 21 is read off as "one 2, then one 1" or 1211.
 Given an integer n, generate the nth sequence.

 Note: The sequence of integers will be represented as a string.
 */
public class Solution {
    public String countAndSay(int n) {
        if(n == 0)
            return "";
        else if(n == 1)
            return "1";
        else{
            String s = countAndSay(n - 1);
            StringBuffer sb = new StringBuffer();
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
