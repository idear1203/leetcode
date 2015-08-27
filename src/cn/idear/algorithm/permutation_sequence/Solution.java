package cn.idear.algorithm.permutation_sequence;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by wangdongwei on 8/27/15.
 */
public class Solution {
    public String getPermutation(int n, int k) {
        int[] factorials = calFactorials(n);
        List<Character> permutation = calFirstPermutation(n);
        char[] result = new char[n];
        int s = 0;
        /**
         * 勿忘我！算法中的编号从0开始。
         */
        k--;
        for(int i = n - 1; i > 0; i--){
            int f = factorials[i];
            int c = k / f;
            result[s++] = permutation.get(c);
            permutation.remove(c);
            k = k % f;
        }
        result[n - 1] = permutation.get(0);
        return new String(result);
    }

    private List<Character> calFirstPermutation(int n) {
        List<Character> list = new LinkedList<Character>();
        for(int i = 1; i <= n; i++)
            list.add((char)(i + '0'));
        return list;
    }

    private int[] calFactorials(int k) {
        int[] rst = new int[k];
        rst[0] = 1;
        for(int i = 1; i < k; i++)
            rst[i] = rst[i - 1] * i;
        return rst;
    }
}
