package cn.idear.algorithm.zigzag_conversation;

/**
 * Created by wangdongwei on 8/25/15.
 The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this: (you may want to display this pattern in a fixed font for better legibility)

 P   A   H   N
 A P L S I I G
 Y   I   R
 And then read line by line: "PAHNAPLSIIGYIR"
 Write the code that will take a string and make this conversion given a number of rows:

 string convert(string text, int nRows);
 convert("PAYPALISHIRING", 3) should return "PAHNAPLSIIGYIR".
 */
public class Solution {
    public String convert(String s, int numRows) {
        StringBuilder sb = new StringBuilder();
        if(s.length() <= 1 || numRows <= 1)
            return s;
        for(int i = 0; i < numRows; i++){
            for(int j = 0; j <= s.length(); j++){
                /**
                 * 计算竖直列下标。
                 */
                int index = i + 2 * (numRows - 1) * j;
                if(index < s.length())
                    sb.append(s.charAt(index));
                else {
                    /**
                     *原来的代码写的是continue，效率超过了27.x%的人。改为break，效率超过了99.76%的人。论严谨的重要性。
                     */
                    break;
                }
                /**
                 * 计算插入列下标。
                 */
                /**
                 * 第1行和第numRows行没有插入列
                 */
                if(i == 0 || i == numRows - 1)
                    continue;
                index = 2 * (numRows - 1) * (j + 1) - i;
                if(index < s.length())
                    sb.append(s.charAt(index));
            }
        }
        return sb.toString();
    }
}
