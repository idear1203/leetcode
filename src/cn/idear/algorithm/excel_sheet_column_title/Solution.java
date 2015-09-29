package cn.idear.algorithm.excel_sheet_column_title;

/**
 * Created by wangdongwei on 9/29/15.
 */
public class Solution {
    /**
     * 递归版本
     */
    // public String convertToTitle(int n) {
    //     if(n <= 26){
    //         return String.valueOf((char)('A' + n - 1));
    //     }
    //     else{
    //         return convertToTitle((n - 1) / 26) + String.valueOf((char)('A' + (n - 1) % 26));
    //     }
    // }

    /**
     * 迭代版本
     */
    public String convertToTitle(int n) {
        StringBuffer sb = new StringBuffer();
        for(; n > 0; n = (n - 1) / 26){
            sb.append((char)('A' + (n - 1) % 26));
        }
        return sb.reverse().toString();
    }
}
