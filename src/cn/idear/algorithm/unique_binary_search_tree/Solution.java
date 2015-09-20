package cn.idear.algorithm.unique_binary_search_tree;

import cn.idear.algorithm.util.TreeNode;

import java.util.List;

/**
 * Created by wangdongwei on 9/20/15.
 */
public class Solution {
    /**
     * 动态规划方法。
     * @param n
     * @return
     */
    public int numTrees(int n) {
        int[] f = new int[Math.max(n + 1, 2)];
        f[0] = 1;
        f[1] = 1;
        /**
         * 计算f[2]...f[n]
         */
        for(int i = 2; i <= n; i++) {
            for (int k = 0; k < i; k++){
                f[i] += f[k] * f[i - 1 - k];
            }
        }
        return f[n];
    }
}
