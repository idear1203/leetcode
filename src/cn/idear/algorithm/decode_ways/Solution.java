package cn.idear.algorithm.decode_ways;

/**
 * Created by wangdongwei on 9/8/15.
 * A message containing letters from A-Z is being encoded to numbers using the following mapping:
 */
//TODO: need to improve the code
public class Solution {
    private int[] record;
    public int numDecodings(String s) {
        record = new int[s.length() + 1];
        return numDecodingsHelper(s, 0);
    }

    private int numDecodingsHelper(String s, int index) {
        if(record[index] > 0)
            return record[index];
        if(index == s.length())
            return record[index] = 0;
        char ch = s.charAt(index);
        if(ch == '0')
            return record[index] = 0;
        if(index == s.length() - 1)
            return record[index] = 1;
        int result = 0;
        int next = s.charAt(index + 1);
        if(ch == '1'){
            if(index == s.length() - 2)
                result = next == '0' ? 1 : 2;
            else if(next == '0') {
                result = numDecodingsHelper(s, index + 2);
            }
            else
            {
                result = numDecodingsHelper(s, index + 1) + numDecodingsHelper(s, index + 2);
            }
        }else if(ch == '2'){
            if(index == s.length() - 2)
                result = next >= '1' && next <= '6' ? 2 : 1;
            else if(next <= '6')
                result = numDecodingsHelper(s, index + 2) + numDecodingsHelper(s, index + 1);
            else
                result = numDecodingsHelper(s, index + 2);
        }
        else // if (ch >= '3' && ch <= '9')
            result = numDecodingsHelper(s, index + 1);
        return record[index] = result;
    }
}
