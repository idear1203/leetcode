package cn.idear.algorithm.simplify_path;

import java.util.Stack;

/**
 * Created by wangdongwei on 8/30/15.
 */
public class Solution {
    public String simplifyPath(String path) {
        String[] directories = path.split("/");
        Stack<String> s = new Stack<>();
        for (String directory : directories) {
            if (directory.length() != 0) {
                if (directory.equals("..")) {
                    if (!s.isEmpty())
                        s.pop();
                } else if (!directory.equals(".")) {
                    s.push(directory);
                }
            }
        }
        StringBuffer sb = new StringBuffer();
        if(s.size() == 0)
            return "/";
        for (String value : s) sb.append('/').append(value);
        return sb.toString();
    }
}
