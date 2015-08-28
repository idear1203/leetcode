package cn.idear.algorithm.wildcard_matching;

/**
 * Created by wangdongwei on 8/28/15.
 */
//TODO:
public class Solution {
    public boolean isMatch(String s, String p) {
        /**
         * 空pattern串只能匹配空串。
         */
        if(p.length() == 0)
            return s.length() == 0;
        char ch = p.charAt(0);
        if(ch != '*') {
            /**
             * ch必须匹配s中的一个字符。
             */
            return s.length() != 0 && (ch == '?' || s.charAt(0) == ch) && isMatch(s.substring(1), p.substring(1));
        }else{
            int next = 1;
            /**
             *  提交超时。考虑*******多个*相连的情况。
             */
            for(next = 1; next < p.length() && p.charAt(next) == '*'; next++);
            /**
             * *可以匹配0个或者任意个字符。
             */
            for(int i = s.length(); i >= 0; i--){
                if(isMatch(s.substring(0, i), p.substring(next)))
                    return true;
            }
            return false;
        }
    }
}
