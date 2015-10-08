package cn.idear.algorithm.excel_sheet_column_number;

/**
 * Created by wangdongwei on 10/2/15.
 */
public class Solution {
    /**
     * 递归
     */
    public int titleToNumber1(String s) {
        int rst = 0;
        if(s.length() == 1)
            rst =  s.charAt(0) - 'A' + 1;
        else{
            rst = titleToNumber(s.substring(0, s.length() - 1)) * 26 + s.charAt(s.length() - 1) - 'A' + 1;
        }
        return rst;
    }

    /**
     * 迭代
     */
    public int titleToNumber(String s) {
        int rst = 0;
        char[] buffer = s.toCharArray();
        for(int i = 0; i < buffer.length; i++)
            rst = rst * 26 + buffer[i] - 'A' + 1;
        return rst;
    }
}
