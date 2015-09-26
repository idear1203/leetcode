package cn.idear.algorithm.triangle;

import java.util.Arrays;
import java.util.List;

/**
 * Created by wangdongwei on 9/26/15.
 */
//TODO:效率极低
public class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        if(triangle.isEmpty())
            return 0;
        int size = triangle.size();
        int[] rst = new int[size];
        Arrays.fill(rst, Integer.MAX_VALUE);
        rst[0] = triangle.get(0).get(0);
        for(int i = 1; i < size; i++) {
            List<Integer> nums = triangle.get(i);
            rst[i] = nums.get(i) + rst[i - 1];
            for (int j = i - 1; j >= 1; j--)
                rst[j] = nums.get(j) + Math.min(rst[j], rst[j - 1]) ;
            rst[0] = nums.get(0) + rst[0];
        }
        int min = Integer.MAX_VALUE;
        for(int i = 0; i < size; i++)
            min = Math.min(min, rst[i]);
        return min;
    }
}
