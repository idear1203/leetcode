package cn.idear.algorithm.triangle;

import java.util.Arrays;
import java.util.List;

/**
 * Created by wangdongwei on 9/26/15.
 */
public class Solution {
    /**
     * 状态转移方程：f(i, j ) = f(i, j) + min(f(i + 1, j), f(i + 1, j + 1))
     * @param triangle
     * @return
     */
    public int minimumTotal(List<List<Integer>> triangle) {
        if(triangle.isEmpty())
            return 0;
        int[] s = new int[triangle.size()];
        for(int i = 0; i < triangle.size(); i++)
            s[i] = triangle.get(triangle.size() - 1).get(i);
        for(int i = triangle.size() - 2; i >= 0; i--)
            for(int j = 0; j <= i; j++)
                s[j] = Math.min(s[j], s[j + 1]) + triangle.get(i).get(j);
        return s[0];
    }

    /**
     * 这个思路不错，但是由于是自顶向下的，因此最后需要一次O(n)的比较
     * @param triangle
     * @return
     */
    public int minimumTotal1(List<List<Integer>> triangle) {
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
