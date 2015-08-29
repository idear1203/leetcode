package cn.idear.algorithm.wildcard_matching;

/**
 * Created by wangdongwei on 8/28/15.
 * Implement wildcard pattern matching with support for '?' and '*'.
 */
public class Solution {

    public boolean isMatch(String s, String p) {
       if(p.length() == 0)
           return s.length() == 0;
        int  j = 0, checkS = -1, checkP = -1;
        for(int i = 0; i < s.length(); ){
            boolean isMatched = false;
            if(j < p.length()){
                char ch = p.charAt(j);
                /**
                 * ?匹配任意字符，因此可以匹配直接下一轮迭代。
                 */
                if(ch == '?' || ch == s.charAt(i)){
                    i++;
                    j++;
                    isMatched = true;
                }else if(ch == '*'){
                    /**
                     * 记录回滚的位置。
                     */
                    checkS = i;
                    checkP = j + 1;
                    j++;
                    isMatched = true;
                }
            }
            /**
             * 说明没有匹配上。
             */
            if(!isMatched) {
                if (checkS < 0) {
                    /**
                     * checkS < 0说明没有遇到*
                     */
                    return false;
                } else {
                    i = checkS++;
                    j = checkP;
                }
            }
        }
        /**
         * 至此，s为空字符串。那么如果p不为空字符串，则必须是一串*号。
         */
        for(; j < p.length() && p.charAt(j) == '*'; j++);
        return j == p.length();
    }
//    /**
//     * 超时。
//     * @param s
//     * @param p
//     * @return
//     */
//    public boolean isMatch(String s, String p) {
//        /**
//         * 空pattern串只能匹配空串。
//         */
//        if(p.length() == 0)
//            return s.length() == 0;
//        char ch = p.charAt(0);
//        if(ch != '*') {
//            /**
//             * ch必须匹配s中的一个字符。
//             */
//            return s.length() != 0 && (ch == '?' || s.charAt(0) == ch) && isMatch(s.substring(1), p.substring(1));
//        }else{
//            int next = 1;
//            /**
//             *  提交超时。考虑*******多个*相连的情况。
//             */
//            for(next = 1; next < p.length() && p.charAt(next) == '*'; next++);
//            /**
//             * *可以匹配0个或者任意个字符。
//             */
//            for(int i = s.length(); i >= 0; i--){
//                if(isMatch(s.substring(0, i), p.substring(next)))
//                    return true;
//            }
//            return false;
//        }
//    }
}
