package cn.idear.algorithm.regular_expression_matching;

/**
 * Created by wangdongwei on 8/25/15.
 */
public class Solution {
    public boolean isMatch(String s, String p) {
        if(p.length() == 0)
            return s.length() == 0;
        /**
         * p.length() == 1时的处理，只能匹配单个字符。
         */
        else if(p.length() == 1){
            return s.length() == 1 && (p.charAt(0) == '.' || p.charAt(0) == s.charAt(0));
        }
        char pcur = p.charAt(0);
        char pnext = p.charAt(1);
        if(pnext != '*'){
            /**
             * 1. 如果p的下一个字符不是'*'，只需判断当前字符是否相等，或者`p[cur]='.'`，递归处理`s[1]`和`p[1]`；
             */
            /**
             * 注意判断长度
             */
            if(s.length() == 0)
                return false;
            char scur = s.charAt(0);
            if(pcur == '.' || pcur == scur){
                return isMatch(s.substring(1), p.substring(1));
            }
        }else{
            /**
             * 2. 如果是p的下一个'*'，则当前s和p相等或者`p='.'`情况下，依次判断`s[0...s.length]`和`p[2...p.length]`是否match；
             */
            while (s.length() > 0 && (pcur == s.charAt(0) || pcur == '.')) {
                if (isMatch(s, p.substring(2)))
                    return true;
                s = s.substring(1);
            }
            /**
             * s=aab p=c*a*b*
             */
            return isMatch(s, p.substring(2));
        }
        return false;
    }
}
