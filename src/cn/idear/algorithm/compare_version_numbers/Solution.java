package cn.idear.algorithm.compare_version_numbers;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by wangdongwei on 9/26/15.
 */
public class Solution {
    public int compareVersion(String version1, String version2) {
        List<Integer> v1 = getVersionNums(version1);
        List<Integer> v2 = getVersionNums(version2);
        for(int i = 0; i < v1.size() || i < v2.size(); i++){
            int n1 = i < v1.size() ? v1.get(i) : 0;
            int n2 = i < v2.size() ? v2.get(i) : 0;
            if(n1 > n2) return 1;
            if(n1 < n2) return -1;
        }
        return 0;
    }

    private List<Integer> getVersionNums(String s){
        String[] ss = s.split("\\.");
        List<Integer> result = new LinkedList<>();
        for(String str : ss)
            result.add(Integer.parseInt(str));
        return result;
    }
}
